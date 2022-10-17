package com.atguigu.product.service;

import com.atguigu.param.ProductParamsString;

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
}
