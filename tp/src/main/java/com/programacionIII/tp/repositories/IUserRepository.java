package com.programacionIII.tp.repositories;

import com.programacionIII.tp.models.User;

public interface IUserRepository {

    User saveUser(User user);
    User findByUsername(String name);
}
