package org.example.mpdemo.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.mpdemo.demos.entity.Order;
import org.example.mpdemo.demos.entity.User;

import java.util.List;

@Mapper
public interface OrderMapper{

//  对外界提供了selectByUid方法，即根据用户的uid查找用户订单
    @Select("select * from t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);


//   查询所有的订单，同时查询所有的用户
    @Select("select * from t_order")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "totlal"),
            @Result(column = "uid", property = "user", javaType = User.class,
                one=@One(select = "com.example.mpdemo.demo.mapper.UserMapper.selectById")
            )
    })
    List<Order> selectAllOrdersAndUser();

}








