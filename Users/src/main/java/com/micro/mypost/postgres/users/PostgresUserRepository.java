package com.micro.mypost.postgres.users;

import com.micro.mypost.users.User;
import com.micro.mypost.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public User getByLogin(String login) {
        DBUser dbUser = repository.findByNickname(login);
        return new User().setNickname(dbUser.getNickname()).setEmail(dbUser.getEmail());
    }
}
