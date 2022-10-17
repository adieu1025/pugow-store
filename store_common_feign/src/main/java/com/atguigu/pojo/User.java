package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/16 21:26 周日
 * description: 用户pojo
 */
@TableName("user")
@Data
public class User implements Serializable {

    public static final Long serialVersionUID = 1L;

    @TableId
    private Integer userId;
    private String  userName;
    private String  password;
    private String  userPhonenumber;
}
