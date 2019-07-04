package com.gunday.socialmedia.api.controller;

import com.gunday.socialmedia.api.service.UserService;
import com.gunday.socialmedia.api.service.model.endpoint.users.login.request.LoginRequest;
import com.gunday.socialmedia.api.service.model.endpoint.users.register.request.RegisterRequest;
import com.gunday.socialmedia.api.service.model.endpoint.users.login.response.LoginResponse;
import com.gunday.socialmedia.api.service.model.endpoint.users.register.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody @Valid RegisterRequest request) {
        return userService.register(request);
    }

    @RequestMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }
}
