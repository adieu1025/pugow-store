package com.atguigu.admin.service.impl;

import com.atguigu.admin.mapper.AdminUserMapper;
import com.atguigu.admin.param.AdminUserParam;
import com.atguigu.admin.pojo.AdminUser;
import com.atguigu.admin.service.AdminUserService;
import com.atguigu.constants.UserConstants;
import com.atguigu.utils.MD5Util;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 10:39 周六
 * description: 后台管理用户业务实现类
 */
@Slf4j
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper,AdminUser> implements AdminUserService {

    /**
     * 后台管理登录页面
     * @param adminUserParam
     * @return
     */
    @Override
    public R login(AdminUserParam adminUserParam) {
        //密码加密处理
        //代码加密处理,注意加盐,生成常量
        String newPwd = MD5Util.encode(adminUserParam.getUserPassword() +
                UserConstants.USER_SLAT);

        //数据库登录查询
        QueryWrapper<AdminUser> adminUserQueryWrapper =
                new QueryWrapper<>();

        adminUserQueryWrapper.eq("user_account",adminUserParam.getUserAccount());
        adminUserQueryWrapper.eq("user_password",newPwd);

        AdminUser adminUser = this.getOne(adminUserQueryWrapper);
        //结果封装

        if (adminUser == null) {
            return R.fail("账号或者密码错误!");
        }

        R ok = R.ok("用户登录成功!", adminUser);
        log.info("AdminUserServiceImpl.login业务结束，结果:{}",ok);

        return ok;
    }
}
