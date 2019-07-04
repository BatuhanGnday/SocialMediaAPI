package com.gunday.twitterdashboard.database.dao;

import com.gunday.twitterdashboard.database.models.Post;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface IPostDao {

    @SqlQuery("select * from posts where id = :id")
    @Mapper(Post.Mapper.class)
    Post getById(@Bind("id") int id);

    @SqlUpdate("insert into posts(content, author_id) " +
            "values(:object.content, :object.authorId)")
    @GetGeneratedKeys
    int createPost(@Bind("object") Post post);
}
