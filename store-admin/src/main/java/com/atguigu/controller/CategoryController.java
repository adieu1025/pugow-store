package com.atguigu.controller;

import com.atguigu.param.PageParam;
import com.atguigu.pojo.Category;
import com.atguigu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/24 10:41 周一
 * description: 后台管理类别controller
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Object list(PageParam pageParam){

        return  categoryService.listPage(pageParam);
    }

    @PostMapping("/update")
    public Object update(Category category){

        return categoryService.update(category);
    }


    @PostMapping("/remove")
    public Object remove(Integer categoryId){

        return categoryService.remove(categoryId);
    }


    @PostMapping("/save")
    public Object save(Category category){

        return categoryService.save(category);
    }
}
