package org.example.mpdemo.demos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

//@TableName("sales")       如果类名和表名不一致时可以在此处添加@TableName注释，对不一致的表名做一个映射(Mybatis-plus)
public class User {
//  对象属性要和查询的表一致


//  如果字段不一致可以使用@TableFiled("nickname")来做映射
    private String username;
    private String password;
//  对于类中存在的字段，而表中没有的话，可以设置@TableFiled(exist = false)，默认为存在
    private String birthday;

    //  @TableId用来描述主键的，如果id在数据库中定义为自增的话，可以单独用@TableId做一个说明
//  前提是要在数据库中先设置自增：ALTER TABLE user MODIFY COLUMN id INT AUTO_INCREMENT;
//  在数据库中设置完之后，如果启用了@TableId(type= IdType.AUTO)，则不管插入值有没有id还是说id不符合自增，都会分配一个自增id值
    @TableId(type= IdType.AUTO)
    private int id;


    // alt + insert快捷键

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", birthday='" + birthday + '\'' +
                '}';
    }

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
}
