package com.atguigu.product.param;

import lombok.Data;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/18 10:42 周二
 * description: 商品类别分组查询
 */
@Data
public class ProductParamInteger {

    private List<Integer> categoryID;
    private int currentPage = 1; //默认值
    private int pageSize = 15; //默认值

}
