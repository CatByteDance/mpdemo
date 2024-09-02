package org.example.mpdemo.demos.controller;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.example.mpdemo.demos.entity.User;
import org.example.mpdemo.demos.mapper.UserMapperMybatis;
import org.example.mpdemo.demos.mapper.UserMapperMybatisPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserControllerMybatisPlus {

    // 将UserMapper实例化的对象自动注入到userMapper初始化的对象中去
    @Autowired // 注入功能，属于spring的功能
    private UserMapperMybatisPlus userMapper;

    //都是使用Mybatis-plus内置的函数
    @GetMapping("user/findp")
    public List find() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("user/deletep")
    public String delete(User user) {
        int i = userMapper.deleteById(user.getId());
        if(i > 0){
            return "delete success";
        }
        else
            return "delete fail";
    }

    @PostMapping("user/updatep")
    public String update(User user) {
        int i = userMapper.updateById(user);
        if(i > 0){
            return "update success";
        }
        else
            return "update fail";
    }

    @PostMapping("user/insertp")
    public String insert(User user) {
        int i = userMapper.insert(user);
        if (i > 0)
            return "insert success";
        else
            return "insert fail";
    }
}
