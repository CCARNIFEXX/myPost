package com.micro.mypost.postgres.users;

import com.micro.mypost.users.User;
import com.micro.mypost.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("Postgres")
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {

    private final PostgresRepository repository;

    /**
     * {@inheritDoc} Реализация в Postgres
     *
     * @param login {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Optional<User> getByLogin(String login) {
        return repository.findByNickname(login)
                .map(user -> new User().setNickname(user.getNickname()).setEmail(user.getEmail()));
    }
}
