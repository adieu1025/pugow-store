package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/17 11:12 周一
 * description: 地址pojo
 */
@Data
@TableName("address")
public class Address {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String province;
    private String city;
    private String region;
    private String detail;
    private String linkman;
    private String phone;
    @TableField("user_id")
    private Integer userId;

}
