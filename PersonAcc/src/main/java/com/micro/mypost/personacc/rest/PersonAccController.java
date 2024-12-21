package com.micro.mypost.personacc.rest;

import com.micro.mypost.personacc.client.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonAccController {
    @Autowired
    private UserAPI userAPI;

    @GetMapping(value = "/")
    public String getIndex() {
        return userAPI.getUser("Adam2").toString();
    }
}
