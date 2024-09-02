package org.example.mpdemo.demos.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mpdemo.demos.entity.User;

import java.util.List;

/**
 * 以下内容属于MyBatis的知识，使用Mybatis-Plus可以对其进行简化
 */
@Mapper // 表明这是一个Mapper，不过在Application中已经有@MapperScan了，可以不用写也行
public interface UserMapperMybatis {

    // 会自动查找配置文件中的数据库， 然后会将查询结果封装成一个个的User对象，放到List中去，也就实现了ORM
    // 查询返回的不止一条记录，就可以设置为List集合来表示
    @Select("select * from user")
    public List<User> find();

    //可以使用user对象中的属性，使用#{}的格式
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public int insert(User user);   //返回值代表插入几条记录


    @Delete("delete from user where id=#{id}")
    public int delete(int id);

    @Update("update user set username=#{username},password=#{password},birthday=#{birthday} where id=#{id}")
    public int update(User user);

    @Select("select * from user where id=#{id}")
    public User findById(int id);
}


