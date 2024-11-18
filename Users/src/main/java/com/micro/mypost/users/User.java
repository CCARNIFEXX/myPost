package com.micro.mypost.users;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    String nickname;
    String email;

    static User createDefault() {
        return new User().setNickname("adam").setEmail("adam@mail.com");
    }
}
