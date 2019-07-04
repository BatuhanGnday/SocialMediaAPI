package com.gunday.twitterdashboard.api.service;

import com.gunday.twitterdashboard.api.service.model.endpoint.register.request.LoginRequest;
import com.gunday.twitterdashboard.api.service.model.endpoint.register.request.RegisterRequest;
import com.gunday.twitterdashboard.api.service.model.endpoint.register.response.LoginResponse;
import com.gunday.twitterdashboard.api.service.model.endpoint.register.response.LoginResponseType;
import com.gunday.twitterdashboard.api.service.model.endpoint.register.response.RegisterResponse;
import com.gunday.twitterdashboard.api.service.model.endpoint.register.response.RegisterResponseType;
import com.gunday.twitterdashboard.database.DatabaseService;
import com.gunday.twitterdashboard.database.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final DatabaseService databaseService;

    @Autowired
    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = databaseService.getUserDao().getByUsername(request.getUsername());

        if(request.getPassword().equals(user.getPassword())){
            return new LoginResponse(LoginResponseType.SUCCESS);
        }else {
            return  new LoginResponse(LoginResponseType.PASSWORD_FAIL);
        }
    }
    public RegisterResponse register(RegisterRequest request) {
        // TODO: Check if email is a valid email
        // TIP: There is an apache dependency for this thing(EmailValidator.getInstance()....)

        // TODO: Check if password is secure enough to use? Min. 6 characters, at least one upper case character etc.
        // TIP: Regex

        // TODO: Check if full name is correct? At least one space in full name etc.

        // Check if user or email exists
        if (this.databaseService.getUserDao().isExistsByUsernameOrEmail(request.getUsername(), request.getEmail())) {
            return new RegisterResponse(RegisterResponseType.USERNAME_OR_EMAIL_EXISTS);
        }

        // Create user
        User user = new User(request.getFullName(), request.getUsername(), request.getPassword(), request.getEmail());

        // Insert user to database and set user's id
        user.setId(
                this.databaseService.getUserDao().createUser(user)
        );

        // Return register success
        return new RegisterResponse(RegisterResponseType.SUCCESS);
    }
}
