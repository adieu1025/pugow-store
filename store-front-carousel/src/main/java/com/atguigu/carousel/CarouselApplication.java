package com.atguigu.carousel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/17 16:56 周一
 * description: 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.carousel.mapper")
@EnableCaching
public class CarouselApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarouselApplication.class,args);
    }

}
