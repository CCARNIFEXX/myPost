package com.micro.mypost.users;

import org.springframework.stereotype.Service;

@Service
public class GetUserQuery {
    public User getById(String id) {
        return User.createDefault();
    }
}
