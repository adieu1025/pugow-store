package com.atguigu.carousel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 16:56 周一
 * description: 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.carousel.mapper")
public class CarouselApplication {


    public static void main(String[] args) {
        SpringApplication.run(CarouselApplication.class,args);
    }

}
