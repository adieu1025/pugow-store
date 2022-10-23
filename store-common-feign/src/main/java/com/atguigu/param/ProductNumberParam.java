package com.atguigu.param;

import lombok.Data;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/21 10:24 周五
 * description: 商品库存信息保存param
 */
@Data
public class ProductNumberParam {

    //商品id
    private Integer productId;
    //购买数量
    private Integer productNum;
}
