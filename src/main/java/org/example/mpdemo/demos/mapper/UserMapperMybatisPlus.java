package org.example.mpdemo.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.mpdemo.demos.entity.User;
//
///**
// * Mybatis-Plus继承BaseMapper
// * 传入一个类，告诉它要操作谁，会根据这个类找到对应的表，来做CRUD，类的名字要和表的名字保持一致
// */
@Mapper
public interface UserMapperMybatisPlus extends BaseMapper<User> {
}