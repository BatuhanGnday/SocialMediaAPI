package com.gunday.socialmedia.api.service.model.endpoint.users.login.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class LoginRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
