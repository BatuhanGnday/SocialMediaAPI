package com.gunday.twitterdashboard.database;

import com.gunday.twitterdashboard.database.dao.IMessageDao;
import com.gunday.twitterdashboard.database.dao.IPostDao;
import com.gunday.twitterdashboard.database.dao.IUserDao;
import com.gunday.twitterdashboard.database.models.User;
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
        return new DBI("jdbc:mysql://localhost:3306/twitter_dashboard?useSSL=false", "root", "rootroot");
    }

    @PostConstruct
    public void init() {
        DBI dbi = dbi();

        this.userDao = dbi.onDemand(IUserDao.class);
        this.messageDao = dbi.onDemand(IMessageDao.class);
        this.postDao = dbi.onDemand(IPostDao.class);
    }
}
