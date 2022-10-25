package com.atguigu.product;

import com.atguigu.clients.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 20:38 周一
 * description: 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.product.mapper")
//开启feign客户端,引入对应的客户端
@EnableFeignClients(clients = {CategoryClient.class, SearchClient.class,
        OrderClient.class, CartClient.class,CollectClient.class})
@EnableCaching //开启缓存支持
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }

}
