package com.gunday.socialmedia.api.service;

import com.gunday.socialmedia.api.service.model.endpoint.users.login.request.LoginRequest;
import com.gunday.socialmedia.api.service.model.endpoint.users.register.request.RegisterRequest;
import com.gunday.socialmedia.api.service.model.endpoint.users.login.response.LoginResponse;
import com.gunday.socialmedia.api.service.model.endpoint.users.login.response.LoginResponseType;
import com.gunday.socialmedia.api.service.model.endpoint.users.register.response.RegisterResponse;
import com.gunday.socialmedia.api.service.model.endpoint.users.register.response.RegisterResponseType;
import com.gunday.socialmedia.database.DatabaseService;
import com.gunday.socialmedia.database.models.User;
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
        // Check if user exists
        if (!this.databaseService.getUserDao().isExistByUsername(request.getUsername())) {
            return new LoginResponse(LoginResponseType.INVALID_USERNAME);
        }else {
            if(this.databaseService.getUserDao().loginControl(request.getUsername(), request.getPassword())){
                return new LoginResponse(LoginResponseType.SUCCESS);
            }else{
                return new LoginResponse(LoginResponseType.PASSWORD_FAIL);
            }
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
