package com.micro.mypost.fileSystem;

import com.micro.mypost.users.User;
import com.micro.mypost.users.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("FileSystem")
class FileSystUserRepository implements UserRepository {
    @Override
    public Optional<User> getByLogin(String login) {
        return Optional.of(new User().setNickname("adam").setEmail("adam@mail.com"));
    }
}
