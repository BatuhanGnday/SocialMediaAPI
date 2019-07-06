package com.gunday.socialmedia.api.service.model.endpoint.messages.receive.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReceiveRequest {
    @NotNull
    private int senderId;

    @NotNull
    private int authorId;
}
