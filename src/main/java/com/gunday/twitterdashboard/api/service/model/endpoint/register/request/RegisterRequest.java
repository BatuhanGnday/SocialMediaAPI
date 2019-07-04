package com.gunday.twitterdashboard.api.service.model.endpoint.register.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class RegisterRequest {
    //<editor-fold desc="Fields">

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String fullName;

    //</editor-fold>
}
