package com.atguigu.category.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.category.mapper.CategoryMapper;
import com.atguigu.category.service.CategoryService;
import com.atguigu.param.ProductParamsString;
import com.atguigu.pojo.Category;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 21:48 周一
 * description: 类别业务集合
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询类别数据
     * @return 类别集合
     */
    @Override
    public List<Category> list() {

        List<Category> categories = categoryMapper.selectList(null);

        //最多返回12条数据
        List<Category> list = categories.stream().limit(categories.size() > 12
                ? 12 : categories.size()).collect(Collectors.toList());

        log.info("CategoryServiceImpl.list业务结束，结果:{}",list);
        return list;
    }

    /**
     * 类别详情查询
     *
     * @param categoryName
     * @return
     */
    @Override
    public Category detail(String categoryName) {

        //参数判断
        if (StringUtils.isEmpty(categoryName)){
            //如果没有默认类型,给一个手机类型
            categoryName = "手机";
        }
        //数据库查询
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_name",categoryName);
        Category category = categoryMapper.selectOne(queryWrapper);
        //返回对象
        log.info("CategoryServiceImpl.detail业务结束，结果:{}",category);
        return category;
    }

    /**
     * 类别名称查询,类别id集合
     *
     * @param productParamsString
     * @return 类别id集合
     */
    @Override
    public List<Integer> names(ProductParamsString productParamsString) {

        List<Integer> ids = new ArrayList<>();
        //获取类别名称
        List<String> categoryName = productParamsString.getCategoryName();
        //判断返回
        if (categoryName == null || categoryName.size() == 0){
            log.info("CategoryServiceImpl.names业务结束，没有类别名称!结果:{}",ids);
            return ids;
        }
        //查询数据库
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_name",categoryName);
        queryWrapper.select("category_id");
        List<Object> list = categoryMapper.selectObjs(queryWrapper);

        //结果封装
        Integer[] idsArray = list.toArray(new Integer[]{});
        ids = Arrays.asList(idsArray);

        log.info("CategoryServiceImpl.names业务结束，结果:{}",ids);
        return ids;
    }
}
