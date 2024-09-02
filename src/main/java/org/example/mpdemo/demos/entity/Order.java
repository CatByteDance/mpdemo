package org.example.mpdemo.demos.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.boot.SpringApplication;


@TableName("t_order")
public class Order {

    private int id;
    private String ordertime;
    private double total;
//    private int uid;

//    @TableField(exist = false ) 除非使用了Mybatis-Plus,否则没用
    private User user;

//    public int getUid() {
//        return uid;
//    }
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
