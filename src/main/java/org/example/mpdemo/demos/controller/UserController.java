package org.example.mpdemo.demos.controller;

import org.example.mpdemo.demos.entity.User;
import org.example.mpdemo.demos.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("user/findAll")
    public List<User> findAll(){return userMapper.selectAllUserAndOrders();}
}
