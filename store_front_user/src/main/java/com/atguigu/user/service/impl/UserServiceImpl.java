package com.atguigu.user.service.impl;

import com.atguigu.pojo.User;
import com.atguigu.user.mapper.UserMapper;
import com.atguigu.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/16 21:31 周日
 * description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectList(null);
        log.info("UserServiceImpl.list业务结束，结果:{}",users);
        return users;
    }
}
