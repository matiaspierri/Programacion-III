package com.programacionIII.tp.services;
import com.programacionIII.tp.models.User;
import java.util.List;

import com


public interface IUserService {
    public User createUser(String firstname, String lastname, String username, String phone, List<Integer> friendsIds);

}

