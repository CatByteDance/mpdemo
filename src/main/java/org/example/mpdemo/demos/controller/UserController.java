package org.example.mpdemo.demos.controller;

import org.apache.ibatis.annotations.Insert;
import org.example.mpdemo.demos.entity.User;
import org.example.mpdemo.demos.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    // 将UserMapper实例化的对象自动注入到userMapper初始化的对象中去
    @Autowired // 注入功能，属于spring的功能
    private UserMapper userMapper;

//    @GetMapping("user")
//    public String query() {
//        List<User> list = userMapper.find();
//        System.out.println(list);
//        return "查询用户";
//    }

    // 一般要将返回的数据转为json然后传给前端，
    // 这样前端可以去渲染
    // 可以 将返回的对象改为list，这样会自动转为json

//  MyBatis
//    @GetMapping("user")
//    public List query() {
//        List<User> list = userMapper.find();
//        System.out.println(list);
//        return list;
//    }
//      MyBatis-Plus,自带特定函数
    @GetMapping("user")
    public List query() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }


    //      MyBatis-Plus,自带特定函数
    @PostMapping("user/insert")
    public String save(User user) {
        int i = userMapper.insert(user);
        if(i > 0){
            return "insert success";
        }
        else
            return "insert fail";
    }


//    Mybatis
//    @PostMapping("user/delete")
//    public String dump(User user) {
//        int i = userMapper.delete(user.getId());
//        if(i > 0){
//            return "delete success";
//        }
//        else
//            return "delete fail";
//    }
//    Mybatis-plus
    @PostMapping("user/delete")
    public String dump(User user) {
        int i = userMapper.deleteById(user.getId());
        if(i > 0){
            return "delete success";
        }
        else
            return "delete fail";
}

//    Mybatis-plus
    @PostMapping("user/update")
    public String change(User user) {
        int i = userMapper.updateById(user);
        if(i > 0){
            return "update success";
        }
        else
            return "update fail";
    }

// Mybatis-plus
    @PostMapping("/user/id")
    public String findById(Integer id) {
        User user = userMapper.selectById(id);
        if (user != null)
            return user.toString();
        else
            return "find fail";
        }
}
