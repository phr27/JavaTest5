package com.hand.api.controller;

import com.hand.api.service.IAddressService;
import com.hand.api.service.IUserService;
import com.hand.domain.entity.Address;
import com.hand.domain.entity.User;
import com.hand.infra.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAddressService addressService;

    @PostMapping("/login")
    public ServerResponse<Object> login(@RequestParam String name, @RequestParam String password) {
        if (userService.auth(name, password)) {
            return ServerResponse.createOK();
        } else {
            return ServerResponse.createError(1, "用户名或密码错误");
        }
    }

    @PutMapping
    public ServerResponse<Object> addUser(@RequestBody @Valid User user) {
        Address address = addressService.findByAddress(user.getAddress().getAddress());
        if (address != null) {
            user.setAddress(address);
            userService.addUser(user);
            return ServerResponse.createOK(user.getUid());
        } else {
            return ServerResponse.createError(2, "地址不存在");
        }
    }
}
