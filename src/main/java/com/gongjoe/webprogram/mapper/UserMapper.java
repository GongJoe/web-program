package com.gongjoe.webprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gongjoe.webprogram.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: GongJoe
 * @Date: 2023/4/7 11:10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where id = #{id}")
    User selectById(int id);

    @Select("select * from t_user")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "id", property = "order", javaType = List.class,
                            many = @Many(select = "com.gongjoe.webprogram.mapper.OrderMapper.selectByUid")
                    )
            }
    )
    List<User> selectAllUserAndOrder();

//    @Select("select * from user")
//    public List<User> find();

//    @Insert("insert into user values (#{id}, #{username}, #{password}, #{birthday})")
//    public int insert(User user);
}
