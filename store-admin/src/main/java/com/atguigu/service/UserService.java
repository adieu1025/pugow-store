package com.atguigu.service;

import com.atguigu.param.PageParam;
import com.atguigu.pojo.User;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 14:33 周六
 * description:
 */
public interface UserService {

    /**
     * 分页数据查询,用户模块
     * @param pageParam
     * @return
     */
    Object listPage(PageParam pageParam);

    /**
     * 删除用户数据
     * @param userId
     * @return
     */
    Object remove(Integer userId);

    /**
     * 修改用户数据
     * @param user
     * @return
     */
    Object update(User user);

    /**
     * 保存用户数据,用户注册功能
     * @param user
     * @return
     */
    Object save(User user);
}
