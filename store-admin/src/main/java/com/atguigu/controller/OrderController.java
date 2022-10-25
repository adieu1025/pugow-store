package com.atguigu.controller;

import com.atguigu.param.PageParam;
import com.atguigu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/25 15:01 周二
 * description: 订单管理controller
 */
@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping("list")
    public Object list(PageParam pageParam){

        return orderService.list(pageParam);
    }

}
