package com.atguigu.controller;

import com.atguigu.service.UserService;
import com.atguigu.param.PageParam;
import com.atguigu.pojo.User;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 14:30 周六
 * description: 前台用户模块
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("list")
    @ResponseBody
    public Object list(PageParam pageParam){

        return userService.listPage(pageParam);
    }


    @PostMapping("remove")
    @ResponseBody
    public Object remove(Integer userId){

        if (userId == null){
            return R.fail("删除失败!");
        }
        return userService.remove(userId);
    }


    @PostMapping("update")
    @ResponseBody
    public Object update(User user){

        return userService.update(user);
    }


    @PostMapping("save")
    @ResponseBody
    public Object save(User user){

        return userService.save(user);
    }

}
