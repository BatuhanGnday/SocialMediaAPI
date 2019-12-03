package com.gunday.socialmedia.database;

import com.gunday.socialmedia.database.dao.IMessageDao;
import com.gunday.socialmedia.database.dao.IPostDao;
import com.gunday.socialmedia.database.dao.IUserDao;
import lombok.Getter;
import org.skife.jdbi.v2.DBI;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DatabaseService {
    @Getter
    private IUserDao userDao;

    @Getter
    private IMessageDao messageDao;

    @Getter
    private IPostDao postDao;

    @Bean
    private DBI dbi() {
        return new DBI("jdbc:mysql://localhost:8080/social_media_api?useSSL=false", "root", "");
    }

    @PostConstruct
    public void init() {
        DBI dbi = dbi();

        this.userDao = dbi.onDemand(IUserDao.class);
        this.messageDao = dbi.onDemand(IMessageDao.class);
        this.postDao = dbi.onDemand(IPostDao.class);
    }
}
