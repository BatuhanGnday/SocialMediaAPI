package com.gunday.socialmedia.database.dao;

import com.gunday.socialmedia.database.models.Post;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface IPostDao {

    @SqlQuery("select * from posts where id = :id")
    @Mapper(Post.Mapper.class)
    Post getById(@Bind("id") int id);

    @SqlQuery("select * from posts where author_id = :authorId")
    @Mapper(Post.Mapper.class)
    List<Post> getByAuthorId(@Bind("authorId") int authorId);

    @SqlUpdate("insert into posts(content, author_id) " +
            "values(:object.content, :object.authorId)")
    @GetGeneratedKeys
    int sharePost(@BindBean("object") Post post);
}
