package com.atguigu.collect.mapper;

import com.atguigu.collect.pojo.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/20 14:51 周四
 * description: 收藏mapper
 */
@Mapper
public interface CollectMapper extends BaseMapper<Collect> {
}
