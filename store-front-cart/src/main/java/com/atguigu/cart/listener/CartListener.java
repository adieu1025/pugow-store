package com.atguigu.cart.listener;


import com.atguigu.cart.service.CartService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/21 11:47 周五
 * description: 购物车RabbitMQ监听器
 */
@Component
public class CartListener {


    @Autowired
    private CartService cartService;

    /**
     * 购物车数据清空监听
     * @param cartIds //要清空的购物车数据集合
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "clear.queue"),
            exchange = @Exchange("topic.ex"),
            key = "clear.cart"
    ))
    public void subNumber(List<Integer> cartIds){
        System.out.println("CartListener.subNumber");
        System.out.println("cartIds = " + cartIds);

        //调用业务修改库存即可
        cartService.removeBatchByIds(cartIds);
    }

}
