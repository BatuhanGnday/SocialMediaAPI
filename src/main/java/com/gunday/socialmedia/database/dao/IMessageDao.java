package com.gunday.socialmedia.database.dao;

import com.gunday.socialmedia.database.models.Message;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface IMessageDao {

    @SqlQuery("select * from messages where id = :id")
    @Mapper(Message.Mapper.class)
    Message getById(@Bind("id") int id);

    @SqlUpdate("insert into messages(sender_id, receiver_id, content) " +
            "values(:object.senderId, :object.receiverId, :object.content)")
    @GetGeneratedKeys
    int createMessage(@Bind("object") Message message);
}
