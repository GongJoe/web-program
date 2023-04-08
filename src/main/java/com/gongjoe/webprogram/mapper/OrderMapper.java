package com.gongjoe.webprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gongjoe.webprogram.pojo.Order;
import com.gongjoe.webprogram.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: GongJoe
 * Date: 2023/4/7 13:31
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);

    @Select("select * from t_order")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "amount", property = "amount"),
            @Result(column = "uid", property = "user", javaType = User.class,
                    one = @One(select = "com.gongjoe.webprogram.mapper.UserMapper.selectById")
            )
    })
    List<Order> selectAllOrderAndUser();
}
