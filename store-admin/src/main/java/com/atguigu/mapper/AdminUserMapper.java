package com.atguigu.mapper;

import com.atguigu.pojo.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/22 10:42 周六
 * description: 用户mapper
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
}
