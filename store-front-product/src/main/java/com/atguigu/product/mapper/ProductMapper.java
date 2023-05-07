package com.atguigu.product.mapper;

import com.atguigu.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/17 22:21 周一
 * description: 商品mapper
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
