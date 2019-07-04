package com.gunday.twitterdashboard.database.models;

import lombok.Data;
import lombok.NonNull;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
public class Post {

    private int id;

    private Timestamp creationDate;

    @NonNull
    private String content;

    @NonNull
    private int authorId;


    public static class Mapper implements ResultSetMapper<Post> {

        @Override
        public Post map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

            int id = resultSet.getInt("id");
            Timestamp creationDate = resultSet.getTimestamp("creation_date");
            String content = resultSet.getString("content");
            int authorId = resultSet.getInt("author_id");
            Post post = new Post(content, authorId);
            post.setCreationDate(creationDate);
            post.setId(id);
            return post;
        }
    }
}
