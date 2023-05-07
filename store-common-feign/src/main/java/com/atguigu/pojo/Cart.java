package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/20 21:40 周四
 * description: 购物车pojo
 */

@TableName("cart")
@Data
public class Cart implements Serializable {

    public static final Long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer num;

}
