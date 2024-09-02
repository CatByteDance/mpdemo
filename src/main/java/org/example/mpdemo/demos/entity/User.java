package org.example.mpdemo.demos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;


public class User {

    @TableId(type= IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String birthday;

//   描述用户的所有订单, 因为orders字段在user表里是不存在的所以需要添加@TableField(exist=false)
//   orders字段必需要自己来完成映射
//    注意 @TableField(exist=false)只是在Mybatis-Plus中自动生成sql时有用，在使用mybatis时手写sql语句有没有无所谓
//    @TableField(exist=false)
    private List<Order> orders;


    // alt + insert快捷键

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", birthday='" + birthday + '\'' +
                '}';
    }

}
