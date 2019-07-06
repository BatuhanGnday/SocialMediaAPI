package com.gunday.socialmedia.database.dao;

import com.gunday.socialmedia.database.models.User;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface IUserDao {

    @SqlQuery("select * from user_accounts where id = :id")
    @Mapper(User.Mapper.class)
    User getById(@Bind("id") int id);

    @SqlQuery("select * from user_accounts where username = :username")
    @Mapper(User.Mapper.class)
    User getByUsername(@Bind("username") String username);

    @SqlQuery("select count(*) from user_accounts where username = :username and password = :password")
    boolean loginControl(@Bind("username") String username, @Bind("password") String password);

    @SqlQuery("select count(*) from user_accounts where username = :username")
    boolean isExistByUsername(@Bind("username") String username);

    @SqlQuery("select count(*) from user_accounts where id = :id")
    boolean isExistById(@Bind("id") int id);

    @SqlQuery("select count(*) from user_accounts where username = :username or email = :email")
    boolean isExistsByUsernameOrEmail(@Bind("username") String username, @Bind("email") String email);

    @SqlUpdate("insert into user_accounts(full_name, username, password, email) " +
            "values(:object.fullName, :object.username, :object.password, :object.email)")
    @GetGeneratedKeys
    int createUser(@BindBean("object") User user);
}
