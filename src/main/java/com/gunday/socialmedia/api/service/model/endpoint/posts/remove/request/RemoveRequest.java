package com.gunday.socialmedia.api.service.model.endpoint.posts.remove.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class RemoveRequest {

    @NotNull
    private int userId;

    @NotNull
    private int postId;
}
