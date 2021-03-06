package com.simon.shardingsphere.order.controller;

import com.simon.shardingsphere.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "shardingsphere/order")
public class OrderController {

    @Value("${test.name}")
    private String name;

    @Autowired
    OrderService orderService;

    @GetMapping(value = "getName")
    public String getName() {
        return name;
    }

    @GetMapping(value = "/saveOrder")
    public String saveOrder() {
        return orderService.saveOrder();
    }

    @GetMapping(value = "getOrders")
    public String getOrders() {
        return orderService.getOrders();
    }
}
