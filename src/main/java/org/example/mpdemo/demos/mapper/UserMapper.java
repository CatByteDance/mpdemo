package org.example.mpdemo.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.mpdemo.demos.entity.User;

import java.util.List;

//
///**
// * Mybatis-Plus继承BaseMapper
// * 传入一个类，告诉它要操作谁，会根据这个类找到对应的表，来做CRUD，类的名字要和表的名字保持一致
// */
@Mapper
public interface UserMapper extends BaseMapper<User> {

//  查询用户及其所有订单，只能自己来实现他们之间的映射关系了，Mybatis-plus只是针对单表
    @Select("select * from t_user")
//  @Results用来做结果集的映射：即从数据库里查出来的结果应该怎样去给这个对象赋上值
    @Results(
            {       // 给每一个字段进行赋值，例：表里面的id列的值赋给类里面的id属性
//                  使用了@Results之后必需将每个属性完成映射，即使名称一致
                    @Result(column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "birthday", property = "birthday"),

                    // 对orders进行赋值
//
                    @Result(column = "id", property = "orders", javaType = List.class,
                            many=@Many(select = "com.example.mpdemo.mapper")
                    )
            }
    )
    List<User> selectAllUserAndOrders();
}



















