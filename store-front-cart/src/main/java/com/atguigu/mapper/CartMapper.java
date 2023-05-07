package com.atguigu.mapper;

import com.atguigu.pojo.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/20 22:01 周四
 * description:
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}
