package com.gunday.socialmedia.api.service.model.endpoint.posts.reshare.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReShareRequest {

    @NotNull
    private int postId;

    @NotNull
    private int userId;
}
