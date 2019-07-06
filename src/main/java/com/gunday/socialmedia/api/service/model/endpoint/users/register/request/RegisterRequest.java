package com.gunday.socialmedia.api.service.model.endpoint.users.register.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class RegisterRequest {
    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String fullName;
}
