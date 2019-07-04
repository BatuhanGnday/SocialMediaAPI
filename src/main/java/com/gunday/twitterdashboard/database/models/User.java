package com.gunday.twitterdashboard.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
public class User {

    private int id;

    @NonNull
    private String fullName;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    private Timestamp creationDate;

    public static class Mapper implements ResultSetMapper<User> {
        @Override
        public User map(int i,ResultSet resultSet, StatementContext statementContext) throws SQLException {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("full_name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            Timestamp creationDate = resultSet.getTimestamp("creationDate");
            User user = new User(fullName, username, password, email);
            user.setId(id);
            user.setCreationDate(creationDate);
            return user;
        }
    }

}
