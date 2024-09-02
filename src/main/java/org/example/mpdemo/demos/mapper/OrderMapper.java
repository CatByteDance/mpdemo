package org.example.mpdemo.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.mpdemo.demos.entity.User;

@Mapper
public interface OrderMapper extends BaseMapper <Order> {

    @Select("select * form t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);


//   查询所有的订单，同时查询所有的用户
    @Select("select * from t_order")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "totlal"),
            @Result(column = "uid", property = "user", javaType = User.class,
                one=@One(select = "com.example.mpdemo.mapper.UserMapper.selectById")
            )
    })
    List<Order> selectAllOrdersAndUser();

}








