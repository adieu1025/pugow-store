package com.atguigu.param;

import com.atguigu.pojo.Product;
import lombok.Data;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/24 22:21 周一
 * description: 保存商品信息
 */
@Data
public class ProductSaveParam extends Product {

    //商品详情图片地址, 多图片地址使用 + 号拼接
    private String pictures;
}
