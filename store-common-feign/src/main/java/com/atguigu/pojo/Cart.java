package com.atguigu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/20 21:40 周四
 * description: 购物车pojo
 */
@Data
public class Cart implements Serializable {

    public static final Long serialVersionUID = 1L;

    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer num;

}
