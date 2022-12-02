package com.cjs.example.sharding.controller;

import com.cjs.example.sharding.entity.OrderEntity;
import com.cjs.example.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2020-06-18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/save")
    public String save(@RequestParam("userId") Integer userId, @RequestParam(value = "phone", required = false) String phone) {
        OrderEntity entity = new OrderEntity();
        entity.setUserId(userId);
        entity.setPhone(phone);
        orderService.save(entity);
        return "ok";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<OrderEntity> findAll(@RequestParam(value = "userId", required = false) Integer userId,
                                     @RequestParam(value = "orderId", required = false) Long orserId,
                                     @RequestParam(value = "status", required = false) Integer status,
                                     @RequestParam(value = "phone", required = false) String phone) {
        OrderEntity entity = new OrderEntity();
        entity.setUserId(userId);
        entity.setOrderId(orserId);
        entity.setStatus(status);
        entity.setPhone(phone);
        return orderService.findAll(entity);
    }
}
