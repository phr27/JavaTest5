package com.hand.api.service;

import com.hand.domain.entity.User;

public interface IUserService {

    boolean auth(String name, String password);

    int addUser(User user);
}
