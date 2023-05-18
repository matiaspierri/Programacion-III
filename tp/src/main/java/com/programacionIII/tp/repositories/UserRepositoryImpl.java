package com.programacionIII.tp.repositories;

import com.programacionIII.tp.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    public User saveUser(User user) {

        return user;
    }
}
