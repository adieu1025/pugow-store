package com.atguigu.user.mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c_cloud_store
 *
 * @author: canon
 * time: 2022/10/16 21:32 周日
 * description: 数据库党文
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
