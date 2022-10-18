package com.atguigu.product.controller;

import com.atguigu.param.ProductParamsString;
import com.atguigu.product.ProductApplication;
import com.atguigu.product.param.ProductParamInteger;
import com.atguigu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 22:16 周一
 * description: 商品controller
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("promo")
    public Object indexPromo(@RequestBody Map<String,String> params){
        String categoryName = params.get("categoryName");
        return productService.promo(categoryName);
    }


    @PostMapping("hots")
    public Object indexHots(@RequestBody ProductParamsString productParamsString){

        return productService.hots(productParamsString);
    }

    @PostMapping("category/list")
    public  Object categoryList(){

        return productService.clist();
    }


    /**
     * 类别查询
     * @param productParamInteger
     * @return
     */
    @PostMapping("bycategory")
    public Object byCategory(@RequestBody ProductParamInteger productParamInteger){

        return productService.byCategory(productParamInteger);
    }

    /**
     * 查询全部商品,可以复用业务!
     * @param productParamInteger
     * @return
     */
    @PostMapping("all")
    public Object all(@RequestBody ProductParamInteger productParamInteger){

        return productService.all(productParamInteger);
    }


    @PostMapping("detail")
    public Object detail(@RequestBody Map<String,Integer> param){
        Integer productID = param.get("productID");
        return productService.detail(productID);
    }

    @PostMapping("pictures")
    public Object productPictures(@RequestBody Map<String,Integer> param){
        Integer productID = param.get("productID");
        return productService.pictures(productID);
    }


}
