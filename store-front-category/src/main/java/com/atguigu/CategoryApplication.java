package com.atguigu;

import com.atguigu.clients.ProductClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 21:28 周一
 * description: 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.mapper")
@EnableFeignClients(clients = {ProductClient.class})
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class,args);
    }

}
