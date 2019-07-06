package com.gunday.socialmedia.api.service;

import com.gunday.socialmedia.api.service.model.endpoint.posts.share.request.ShareRequest;
import com.gunday.socialmedia.api.service.model.endpoint.posts.share.response.ShareResponse;
import com.gunday.socialmedia.api.service.model.endpoint.posts.share.response.ShareResponseType;
import com.gunday.socialmedia.database.DatabaseService;
import com.gunday.socialmedia.database.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final DatabaseService databaseService;

    @Autowired
    public PostService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public ShareResponse sharePost(ShareRequest request) {
        // Check the content character limit
        if (request.getContent().length() > 240) {
            return new ShareResponse(ShareResponseType.OUT_OF_LIMIT);
        }

        // Check author
        if (!this.databaseService.getUserDao().isExistById(request.getAuthorId())) {
            return new ShareResponse(ShareResponseType.INVALID_AUTHOR);
        }

        // Create post
        Post post = new Post(request.getContent(), request.getAuthorId());

        // Insert post to database and set post's id
        post.setId(
                this.databaseService.getPostDao().sharePost(post)
        );

        // Return post share success
        return new ShareResponse(ShareResponseType.SUCCESS);
    }
}
