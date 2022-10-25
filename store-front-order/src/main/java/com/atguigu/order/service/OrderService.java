package com.atguigu.order.service;

import com.atguigu.param.OrderParam;
import com.atguigu.param.PageParam;
import com.atguigu.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/21  10:07 周五
 * description: 订单业务接口
 */
public interface OrderService extends IService<Order> {

    /**
     * 订单保存业务
     * @param orderParam
     * @return
     */
    Object save(OrderParam orderParam);

    /**
     * 订单数据查询业务
     * @param orderParam
     * @return
     */
    Object list(OrderParam orderParam);

    /**
     * 检查订单是否包含要删除的商品
     * @param productId
     * @return
     */
    Object check(Integer productId);

    /**
     * 分页查询订单数据
     * @param pageParam
     * @return
     */
    Object adminList(PageParam pageParam);
}
