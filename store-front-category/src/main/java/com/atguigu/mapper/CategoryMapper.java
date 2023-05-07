package com.atguigu.mapper;

import com.atguigu.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/17 21:49 周一
 * description: 类别mapper接口
 */
@Mapper
public interface CategoryMapper  extends BaseMapper<Category> {
}
