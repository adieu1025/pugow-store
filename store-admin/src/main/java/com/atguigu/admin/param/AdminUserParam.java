package com.atguigu.admin.param;

import lombok.Data;
import org.checkerframework.common.value.qual.MinLen;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 10:04 周六
 * description: 用户登录接参数实体
 */
@Data
public class AdminUserParam {

    @Length(min = 6)
    private String userAccount; //账号
    @Length(min = 6)
    private String userPassword; //密码
    @NotBlank
    private String verCode;  //验证码

}
