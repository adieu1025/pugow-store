package com.atguigu.service;

import com.atguigu.param.AdminUserParam;
import com.atguigu.pojo.AdminUser;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 10:38 周六
 * description: 后台管理登录响应功能
 */
public interface AdminUserService extends IService<AdminUser> {

    /**
     * 后台管理登录页面
     * @param adminUserParam
     * @return
     */
    R login(AdminUserParam adminUserParam);
}
