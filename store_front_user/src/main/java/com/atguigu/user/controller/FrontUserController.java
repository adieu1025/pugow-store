package com.atguigu.user.controller;

import com.atguigu.pojo.User;
import com.atguigu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/16 21:26 周日
 * description: 用户模块controller
 */

@RestController
@RequestMapping("user")
public class FrontUserController {

    @Autowired
    private UserService userService;


    @GetMapping("list")
    public List<User> list(){

        return userService.list();
    }



}
