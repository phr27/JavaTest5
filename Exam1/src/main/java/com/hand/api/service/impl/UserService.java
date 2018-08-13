package com.hand.api.service.impl;

import com.hand.api.service.IUserService;
import com.hand.domain.entity.User;
import com.hand.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public boolean auth(String name, String password) {
        return userMapper.countByNameAndPassword(name, password) != 0;
    }

    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
