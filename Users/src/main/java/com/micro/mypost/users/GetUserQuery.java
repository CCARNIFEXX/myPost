package com.micro.mypost.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GetUserQuery {
    @Autowired
    @Qualifier("Postgres")
    private UserRepository repository;

    public User getById(String id) {
        return repository.getByLogin(id);
    }

}
