package com.atguigu.product.service.impl;

import com.atguigu.clients.CategoryClient;
import com.atguigu.param.ProductParamsString;
import com.atguigu.pojo.Category;
import com.atguigu.pojo.Picture;
import com.atguigu.pojo.Product;
import com.atguigu.product.mapper.PictureMapper;
import com.atguigu.product.mapper.ProductMapper;
import com.atguigu.product.param.ProductParamInteger;
import com.atguigu.product.service.ProductService;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private PictureMapper pictureMapper;

    //导入客户端
    @Autowired
    private CategoryClient categoryClient;

    /**
     * 类别名称,查询商品集合,最多查询7条
     * @param categoryName
     * @return
     */
    @Cacheable(value = "list.product",key = "#categoryName")
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
    @Cacheable(value = "list.product",key = "#productParamsString.categoryName")
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
    /**
     * 查询类别数据集合!
     * 最多返回12条数据
     *
     * @return
     */

    @Override
    @Cacheable(value = "list.category",key = "#root.methodName")
    public Object clist() {

        //1.查询类别数据集合 调用类别服务
        List<Category> list = categoryClient.list();
        //2.结果封装
        R data = R.ok(list);

        log.info("ProductServiceImpl.clist业务结束，结果:{}",data);

        return data;
    }

    /**
     * 类别商品查询 前端传递类别集合
     *
     * @param productParamInteger
     * @return
     */
    @Cacheable(value = "list.product",key =
                                        "#productParamInteger.categoryID+" +
                                        "'-'+#productParamInteger.currentPage+" +
                                        "'-'+#productParamInteger.pageSize")
    @Override
    public Object byCategory(ProductParamInteger productParamInteger) {

        //1.拆分请求参数
        List<Integer> categoryID = productParamInteger.getCategoryID();
        int currentPage = productParamInteger.getCurrentPage();
        int pageSize = productParamInteger.getPageSize();
        //2.请求条件封装
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
        if (categoryID != null && categoryID.size() > 0){
            productQueryWrapper.in("category_id",categoryID);
        }
        IPage<Product> page = new Page<>(currentPage,pageSize);
        //3.数据查询
        IPage<Product> iPage = productMapper.selectPage(page, productQueryWrapper);
        //4.结果封装
        List<Product> productList = iPage.getRecords();
        long total = iPage.getTotal();

        R ok = R.ok(null, productList, total);

        log.info("ProductServiceImpl.byCategory业务结束，结果:{}",ok);
        return ok;
    }

    /**
     * 全部商品查询,可以进行类别集合数据查询业务复用
     *
     * @param productParamInteger
     * @return
     */
    @Cacheable(value = "list.product",key ="#productParamInteger.currentPage+" +
                    "'-'+#productParamInteger.pageSize")
    @Override
    public Object all(ProductParamInteger productParamInteger) {

        return byCategory(productParamInteger);
    }

    /**
     * 查询商品详情
     *
     * @param productID 商品id
     * @return
     */
    @Override
    @Cacheable(value = "product",key = "#productID")
    public Object detail(Integer productID) {

        Product product = productMapper.selectById(productID);

        R ok = R.ok(product);

        log.info("ProductServiceImpl.detail业务结束，结果:{}",ok);

        return ok;
    }

    /**
     * 查询商品图片
     *
     * @param productID
     * @return
     */
    @Cacheable(value = "picture",key = "#productID")
    @Override
    public Object pictures(Integer productID) {

        //参数封装
        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productID);
        //数据库查询
        List<Picture> pictureList = pictureMapper.selectList(queryWrapper);
        //结果封装
        R r = R.ok(pictureList);

        log.info("ProductServiceImpl.pictures业务结束，结果:{}",r);

        return r;
    }
}
