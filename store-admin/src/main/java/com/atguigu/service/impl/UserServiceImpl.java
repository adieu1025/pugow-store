package com.atguigu.service.impl;

import com.atguigu.service.UserService;
import com.atguigu.clients.UserClient;
import com.atguigu.param.PageParam;
import com.atguigu.pojo.User;
import com.atguigu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 14:35 周六
 * description: 用户服务
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserClient userClient;

    /**
     * 分页数据查询,用户模块
     *
     * @param pageParam
     * @return
     */
    //添加缓存功能! 修改 和 删除 以及添加用户 要清空 list.user对应缓存
    @Cacheable(value = "list.user",key = "#pageParam.currentPage+'-'+#pageParam.pageSize")
    @Override
    public Object listPage(PageParam pageParam) {

        R r = userClient.listPage(pageParam);

        log.info("UserServiceImpl.listPage业务结束，结果:{}",r);

        return r;
    }

    /**
     * 删除用户数据
     *
     * @param userId
     * @return
     */
    @Caching(
         //删除,清空缓存集合
         //删除,清空对应单条id的数据
         evict = {
                 @CacheEvict(value = "list.user",allEntries = true),
                 @CacheEvict(value = "user",key = "#userId" )
         }
    )
    @Override
    public Object remove(Integer userId) {

        R r = userClient.remove(userId);

        log.info("UserServiceImpl.remove业务结束，结果:{}",r);
        return r;
    }

    /**
     * 修改用户数据
     *
     * @param user
     * @return
     */
    @Caching(
            //删除,清空缓存集合
            //删除,清空对应单条id的数据
            evict = {
                    @CacheEvict(value = "list.user",allEntries = true),
                    @CacheEvict(value = "user",key = "#user.userId" )
            }
    )
    @Override
    public Object update(User user) {

        R r = userClient.update(user);
        log.info("UserServiceImpl.update业务结束，结果:{}",r);
        return r;
    }

    /**
     * 保存用户数据,用户注册功能
     * 清空保存
     * @param user
     * @return
     */
    @Caching(
            //删除,清空缓存集合
            //删除,清空对应单条id的数据
            evict = {
                    @CacheEvict(value = "list.user",allEntries = true)
            }
    )
    @Override
    public Object save(User user) {

        R ok = userClient.save(user);
        log.info("UserServiceImpl.save业务结束，结果:{}",ok);
        return ok;
    }
}
