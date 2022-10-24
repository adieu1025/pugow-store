package com.atguigu.service;

import com.atguigu.param.PageParam;
import com.atguigu.pojo.Category;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/24 10:43 周一
 * description:
 */
public interface CategoryService {

    /**
     * 分页数据查询
     * @param pageParam
     * @return
     */
    Object listPage(PageParam pageParam);

    /**
     * 类别数据修改
     * @param category
     * @return
     */
    Object update(Category category);

    /**
     * 移除类别数据
     * @param categoryId
     * @return
     */
    Object remove(Integer categoryId);

    /**
     * 类别数据保存
     * @param category
     * @return
     */
    Object save(Category category);
}
