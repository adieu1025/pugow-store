package com.atguigu.carousel.service.impl;

import com.atguigu.carousel.mapper.CarouselMapper;
import com.atguigu.carousel.service.CarouselService;
import com.atguigu.pojo.Carousel;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 17:50 周一
 * description: 轮播图业务实现类
 */

@Slf4j
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 查询优先级最高的四条轮播图数据
     *
     * @return
     */
    @Cacheable(value = "list.carousel",key = "#root.methodName")
    @Override
    public Object list() {
        //声明数量
        int limit = 4 ; //至多查询四条
        //查询数据库
        IPage<Carousel> iPage = new Page<>(1,limit);
        QueryWrapper<Carousel> carouselQueryWrapper = new QueryWrapper<>();
        carouselQueryWrapper.orderByDesc("priority");
        IPage<Carousel> page = carouselMapper.selectPage(iPage, carouselQueryWrapper);

        List<Carousel> carouselList = page.getRecords();
        long total = page.getTotal();
        System.out.println("total = " + total);

        return R.ok(carouselList);
    }
}
