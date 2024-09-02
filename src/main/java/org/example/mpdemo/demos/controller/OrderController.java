package org.example.mpdemo.demos.controller;


import org.example.mpdemo.demos.entity.Order;
import org.example.mpdemo.demos.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("order/findAll")
    public List<Order>findAll(){
        return orderMapper.selectAllOrdersAndUser();
    }
}
