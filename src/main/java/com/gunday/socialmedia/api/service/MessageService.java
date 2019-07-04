package com.gunday.socialmedia.api.service;

import com.gunday.socialmedia.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final DatabaseService databaseService;

    @Autowired
    public MessageService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
}
