package com.atguigu.user.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.pojo.User;
import com.atguigu.user.constants.UserConstants;
import com.atguigu.user.mapper.UserMapper;
import com.atguigu.user.service.UserService;
import com.atguigu.utils.MD5Util;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    /**
     * 检查账号是否可用
     *
     * @param userName
     * @return
     */
    @Override
    public R check(String userName) {

        //1.账号非空校验
        if (StringUtils.isEmpty(userName)){
            log.info("UserServiceImpl.check业务开始，参数:{}",userName);
            return R.fail("账号为null,不可用!");
        }
        //2.数据库查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        Long count = userMapper.selectCount(queryWrapper);

        //3.结果处理
        log.info("UserServiceImpl.check业务结束，结果:{}",count);

        if (count > 0 ){

            return R.fail("账号已经存在,不可用!");
        }

        return R.ok("账号不存在,可以使用!");
    }

    /**
     * 进行账号注册
     *
     * @param user 参数没有校验
     * @return
     */
    @Override
    public R register(User user) {

        //1.参数校验
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword()))
        {
            log.info("UserServiceImpl.register业务结束，结果:{}",user);
            return R.fail("账号或者密码为null,注册失败!");
        }
        //2.数据库查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",user.getUserName());
        Long count = userMapper.selectCount(queryWrapper);

        if (count>0) {
            log.info("UserServiceImpl.register业务结束，结果:{}",count);
            return R.fail("账号已经存在,不可用!");
        }
        //3.数据库插入

        //代码加密处理,注意加盐,生成常量
        String newPwd = MD5Util.encode(user.getPassword() + UserConstants.USER_SLAT);

        user.setPassword(newPwd);

        int rows = userMapper.insert(user);
        //4.结果处理
        if (rows > 0){
            log.info("UserServiceImpl.register业务结束，注册成功,结果:{}",rows);
            return R.ok("注册成功!");
        }

        return R.fail("账号已经存在,不可用!");
    }

    /**
     * 进行账号登录
     *
     * @param user
     * @return
     */
    @Override
    public R login(User user) {

        //1.参数校验
        //1.参数校验
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword()))
        {
            log.info("UserServiceImpl.login业务结束，结果:{}",user);
            return R.fail("账号或者密码为null,登录失败!");
        }

        //2.数据库查询
        //代码加密处理,注意加盐,生成常量
        String newPwd = MD5Util.encode(user.getPassword() + UserConstants.USER_SLAT);
        user.setPassword(newPwd);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        queryWrapper.eq("password",user.getPassword());

        User loginUser = userMapper.selectOne(queryWrapper);

        //3.结果封装

        if (loginUser == null) {
            log.info("UserServiceImpl.login业务结束，登录失败,结果:{}",loginUser);
            return R.fail("账号或者密码错误,登录失败!");
        }

        //设置为null,配合NoN_NULL注解,不返回给前端
        loginUser.setPassword(null);
        //注意修改 user的别名
        log.info("UserServiceImpl.login业务结束，登录成功,结果:{}",loginUser);
        return R.ok("登录成功!",loginUser);
    }
}
