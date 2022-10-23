package com.atguigu.param;

import com.atguigu.pojo.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/21 16:49 周五
 * description: 地址收集信息
 */
@Data
public class AddressParam {

    @JsonProperty("user_id")
    private Integer userId;
    private Address add;
}
