package com.micro.mypost.users;

import java.util.Optional;

public interface UserRepository {

    /**
     * Поиск пользователя по логину.
     *
     * @param login логин
     * @return Пользователь
     */
    Optional<User> getByLogin(String login);
}
