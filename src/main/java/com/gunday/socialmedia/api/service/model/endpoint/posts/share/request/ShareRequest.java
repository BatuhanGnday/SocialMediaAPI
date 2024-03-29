package com.gunday.socialmedia.api.service.model.endpoint.posts.share.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ShareRequest {

    @NotNull
    private String content;

    @NotNull
    private int authorId;
}
