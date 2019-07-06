package com.gunday.socialmedia.api.controller;

import com.gunday.socialmedia.api.service.PostService;
import com.gunday.socialmedia.api.service.model.endpoint.posts.share.request.ShareRequest;
import com.gunday.socialmedia.api.service.model.endpoint.posts.share.response.ShareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/share")
    public ShareResponse share(@RequestBody @Valid ShareRequest request) {
        return postService.sharePost(request);
    }
}
