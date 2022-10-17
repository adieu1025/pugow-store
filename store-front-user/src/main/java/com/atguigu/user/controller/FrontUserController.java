package com.atguigu.user.controller;

import com.atguigu.pojo.User;
import com.atguigu.user.service.UserService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("check")
    public R check(@RequestBody User user){

        return userService.check(user.getUserName());
    }


    @PostMapping("register")
    public R register(@RequestBody User user){

        return userService.register(user);
    }


    @PostMapping("login")
    public R login(@RequestBody User user){

        return userService.login(user);
    }
}
