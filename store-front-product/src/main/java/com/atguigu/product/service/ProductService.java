package com.atguigu.product.service;

import com.atguigu.param.ProductParamsString;
import com.atguigu.product.param.ProductParamInteger;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 22:19 周一
 * description: 商品业务
 */
public interface ProductService {
    /**
     * 类别名称,查询商品集合,最多查询7条
     * @param categoryName
     * @return
     */
    Object promo(String categoryName);

    /**
     * 热门商品查询,最多查询7条
     * @param productParamsString
     * @return
     */
    Object hots(ProductParamsString productParamsString);

    /**
     * 查询类别数据集合!
     * 最多返回12条数据
     * @return
     */
    Object clist();

    /**
     * 类别商品查询 前端传递类别集合
     * @param productParamInteger
     * @return
     */
    Object byCategory(ProductParamInteger productParamInteger);

    /**
     * 全部商品查询,可以进行类别集合数据查询业务复用
     * @param productParamInteger
     * @return
     */
    Object all(ProductParamInteger productParamInteger);

    /**
     * 查询商品详情
     * @param productID 商品id
     * @return
     */
    Object detail(Integer productID);

    /**
     * 查询商品图片
     * @param productID
     * @return
     */
    Object pictures(Integer productID);
}
