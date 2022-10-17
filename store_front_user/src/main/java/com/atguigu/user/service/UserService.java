package com.atguigu.user.service;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/16 21:30 周日
 * description:
 */
public interface UserService{

    List<User> list();
}
