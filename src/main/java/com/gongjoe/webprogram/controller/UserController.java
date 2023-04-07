package com.gongjoe.webprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gongjoe.webprogram.mapper.UserMapper;
import com.gongjoe.webprogram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: GongJoe
 * @Date: 2023/4/7 10:20
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

//    @ApiOperation("获取用户")
//    @GetMapping("/user/{id}")
//    public String getUserById(@PathVariable int id) {
//        System.out.println(id);
//        return "根据ID获取用户信息";
//    }

//    @ApiOperation("添加用户")
//    @PostMapping("/user")
//    public String saves(User user) {
//        return "添加用户";
//    }

//    @ApiOperation("修改用户")
//    @PutMapping("user")
//    public String update(User user) {
//        return "修改用户";
//    }
//
//    @ApiOperation("删除用户")
//    @DeleteMapping("/user/{id}")
//    public String deleteById(@PathVariable int id) {
//        System.out.println(id);
//        return "根据ID删除用户";
//    }

    @GetMapping("/user")  //查询用户
    public String query() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return "查询用户" + list;
    }

    @PostMapping("/user")  //添加用户
    public String save(User user) {
        int i = userMapper.insert(user);
        System.out.println(user);
        if (i > 0) {
            return "插入成功";
        } else {
            return "插入失败";
        }
    }

    @GetMapping("/user/findAll")  //查询用户订单
    public List find() {
        return userMapper.selectAllUserAndOrder();
    }

    @GetMapping("/user/find")  //条件查询
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username","mike");
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/user/findByPage")  //分页查询
    public IPage findByPage(){
        Page<User> page = new Page<>(0,2);  //设置起始值及每页条数
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }
}
