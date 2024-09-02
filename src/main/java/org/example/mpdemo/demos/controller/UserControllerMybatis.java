package org.example.mpdemo.demos.controller;

import org.apache.ibatis.annotations.Insert;
import org.example.mpdemo.demos.entity.User;
import org.example.mpdemo.demos.mapper.UserMapperMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerMybatis {

    // 将UserMapperMybatis实例化的对象自动注入到userMapper初始化的对象中去
    @Autowired // 注入功能，属于spring的功能
    private UserMapperMybatis userMapper;

    // 一般要将返回的数据转为json然后传给前端，
    // 这样前端可以去渲染
    // 将返回的对象改为list之后，这样会自动转为json
    @GetMapping("user/find")
    public String find() {
        List<User> list = userMapper.find();
        System.out.println(list);
        return "查询用户成功 ";       //        return list;
    }

    @PostMapping("user/insert")
    public String insert(User user) {
        int i = userMapper.insert(user);
        if (i > 0) {
            return "插入成功";
        }
        else
            return "插入失败";
    }


    @PostMapping("user/delete")
    public String delete(User user) {
        int i = userMapper.delete(user.getId());
        if(i > 0){
            return "delete success";
        }
        else
            return "delete fail";
    }

    @PostMapping("user/update")
    public String update(User user) {
        int i = userMapper.update(user);
        if(i > 0){
            return "更新成功";
        }
        else
            return "更新失败";
    }


    @PostMapping("user/findId")
    public String findId(int id) {
        User user = userMapper.findById(id);
        if (user != null) {
            System.out.println(user);
            return "成功找到该用户";
        }
        else
            return "未找到该用户";
    }
}
