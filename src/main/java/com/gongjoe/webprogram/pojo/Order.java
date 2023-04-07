package com.gongjoe.webprogram.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * @Author: GongJoe
 * @Date: 2023/4/7 12:29
 */
@TableName("t_order")
public class Order {
    private int id;
    private String ordertime;
    private String amount;
    private int uid;
    @TableField(exist = false)
    private List<User> user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime='" + ordertime + '\'' +
                ", amount='" + amount + '\'' +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
