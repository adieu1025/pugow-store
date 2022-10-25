package com.atguigu;

import com.atguigu.clients.CategoryClient;
import com.atguigu.clients.OrderClient;
import com.atguigu.clients.ProductClient;
import com.atguigu.clients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 9:38 周六
 * description: 启动类
 */
@MapperScan("com.atguigu.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {UserClient.class, CategoryClient.class, ProductClient.class, OrderClient.class})  //添加客户端引用
@EnableCaching //开启缓存支持
public class AdminApplication  {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
