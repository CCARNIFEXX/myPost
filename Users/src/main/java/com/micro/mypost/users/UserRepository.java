package com.micro.mypost.users;

public interface UserRepository {

    /**
     * Поиск пользователя по логину.
     *
     * @param login логин
     * @return Пользователь
     */
    User getByLogin(String login);
}
