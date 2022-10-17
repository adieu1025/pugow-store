package com.atguigu.carousel.controller;

import com.atguigu.carousel.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 17:42 周一
 * description:
 */

@RestController
@RequestMapping("carousel")
public class CarouselController  {

    @Autowired
    private CarouselService carouselService;

    /**
     * 查询首页数据,查询优先级最高的四条
     * @return
     */
    @PostMapping("list")
    public Object list(){

        return  carouselService.list();
    }

}
