package com.gongjoe.webprogram.controller;

import com.gongjoe.webprogram.mapper.OrderMapper;
import com.gongjoe.webprogram.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: GongJoe
 * @Date: 2023/4/7 14:04
 */
@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order/findAll")
    public List findAll(){
        return orderMapper.selectAllOrderAndUser();
    }
}
