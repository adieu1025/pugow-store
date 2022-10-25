package com.atguigu.controller;

import com.atguigu.config.AliyunOSSUtils;
import com.atguigu.param.ProductParamsSearch;
import com.atguigu.param.ProductSaveParam;
import com.atguigu.pojo.Product;
import com.atguigu.service.ProductService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import java.io.IOException;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/24 15:45 周一
 * description: 商品查询接口
 */
@RestController
@RequestMapping("product")
public class ProductController {


    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public Object list(ProductParamsSearch productParamsSearch){

        return productService.list(productParamsSearch);
    }

    @PostMapping("upload")
    public Object upload(MultipartFile img) throws Exception {

        String filename = img.getOriginalFilename();
        String contentType = img.getContentType();
        long millis = System.currentTimeMillis();

        filename = millis + filename; //防止重复

        String url = aliyunOSSUtils.uploadImage(filename, img.getBytes(), contentType, 1000);
        System.out.println("url = " + url);
        return R.ok("上传成功",url);

    }


    /**
     * 商品信息保存
     * @param saveParam
     * @return
     */
    @PostMapping("save")
    public Object save(ProductSaveParam saveParam){
        return productService.save(saveParam);
    }


    /**
     * 修改商品信息
     * @param product
     * @return
     */
    @PostMapping("update")
    public Object update(Product product){

        return productService.update(product);
    }


    @PostMapping("remove")
    public Object remove(Product product){

        return productService.remove(product.getProductId());
    }
}
