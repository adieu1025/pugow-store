package com.atguigu.product.mapper;

import com.atguigu.pojo.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/18 12:40 周二
 * description: 图片数据库mapper
 */
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {
}
