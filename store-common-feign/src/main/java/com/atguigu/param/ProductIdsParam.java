package com.atguigu.param;

import lombok.Data;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/20 15:25 周四
 * description: 商品id集合
 */
@Data
public class ProductIdsParam {

    private List<Integer> productIds;
}
