package com.atguigu.product.service.impl;

import com.atguigu.clients.CategoryClient;
import com.atguigu.param.ProductParamsString;
import com.atguigu.pojo.Category;
import com.atguigu.pojo.Product;
import com.atguigu.product.mapper.ProductMapper;
import com.atguigu.product.service.ProductService;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 22:20 周一
 * description:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    //导入客户端
    @Autowired
    private CategoryClient categoryClient;

    /**
     * 类别名称,查询商品集合,最多查询7条
     * @param categoryName
     * @return
     */
    @Override
    public Object promo(String categoryName) {

        //调用category-service,查询名称对应的类别信息
        Category category = categoryClient.detail(categoryName);
        //根据类别id查询商品集合,最多查询7条!
        if (category == null){
            return R.fail("查询失败");
        }
        Integer categoryId = category.getCategoryId();

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id",categoryId);
        queryWrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1,7);

        IPage<Product> iPage = productMapper.selectPage(page, queryWrapper);
        //结果封装
        List<Product> records = iPage.getRecords();
        long total = iPage.getTotal();
        System.out.println("total = " + total);

        log.info("ProductServiceImpl.promo业务结束，结果:{}",records);
        return R.ok(records);
    }

    /**
     * 热门商品查询,最多查询7条
     *
     * @param productParamsString
     * @return
     */
    @Override
    public Object hots(ProductParamsString productParamsString) {

        //调用category-service,查询名称对应的类别id
        List<Integer> ids = categoryClient.names(productParamsString);

        //根据类别id查询商品集合,最多查询7条!
        if ( ids == null || ids.size() == 0){
            return R.fail("查询失败");
        }

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id",ids);
        queryWrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1,7);

        IPage<Product> iPage = productMapper.selectPage(page, queryWrapper);
        //结果封装
        List<Product> records = iPage.getRecords();
        long total = iPage.getTotal();
        System.out.println("total = " + total);

        log.info("ProductServiceImpl.hots业务结束，结果:{}",records);
        return R.ok(records);
    }
}
