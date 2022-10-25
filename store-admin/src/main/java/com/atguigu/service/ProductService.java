package com.atguigu.service;

import com.atguigu.param.ProductParamsSearch;
import com.atguigu.param.ProductSaveParam;
import com.atguigu.pojo.Product;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/24 15:51 周一
 * description:
 */
public interface ProductService {

    /**
     * 商品分页,关键字分页查询!
     * @param productParamsSearch
     * @return
     */
    Object list(ProductParamsSearch productParamsSearch);

    /**
     * 保存商品业务!
     *    1.保存商品
     *    2.保存商品图片 [异步]
     *    3.商品缓存数据处理 [注解]
     *    4.添加缓存es处理 [异步]
     * @param saveParam
     * @return
     */
    Object save(ProductSaveParam saveParam);

    /**
     * 修改商品信息
     *   1.修改商品信息
     *   2.清空商品缓存集合
     *   3.更新缓存es处理 [异步]
     * @param product
     * @return
     */
    Object update(Product product);

    /**
     * 删除商品数据
     * @param productId
     * @return
     */
    Object remove(Integer productId);
}
