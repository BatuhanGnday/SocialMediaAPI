package com.gunday.socialmedia.database.models;

import lombok.Data;
import lombok.NonNull;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
public class Message {

    private int id;

    @NonNull
    private int senderId;

    @NonNull
    private int receiverId;

    @NonNull
    private String content;

    private Timestamp sendingDate;

    public static class Mapper implements ResultSetMapper<Message> {

        @Override
        public Message map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

            int id = resultSet.getInt("id");
            int senderId = resultSet.getInt("sender_id");
            int receiverId = resultSet.getInt("receiver_id");
            String content = resultSet.getString("content");
            Timestamp sendingDate = resultSet.getTimestamp("sending_date");
            Message message = new Message(senderId, receiverId, content);
            message.setId(id);
            message.setSendingDate(sendingDate);
            return message;
        }
    }

}
