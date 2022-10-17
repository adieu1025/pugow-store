package com.atguigu.category.service;

import com.atguigu.param.ProductParamsString;
import com.atguigu.pojo.Category;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 21:48 周一
 * description: 类别业务接口
 */
public interface CategoryService {

    /**
     * 查询类别数据
     * @return 类别集合
     */
    List<Category> list();

    /**
     * 类别详情查询
     * @param categoryName
     * @return
     */
    Category detail(String categoryName);

    /**
     * 类别名称查询,类别id集合
     * @param productParamsString
     * @return 类别id集合
     */
    List<Integer> names(ProductParamsString productParamsString);
}
