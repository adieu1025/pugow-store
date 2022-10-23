package com.atguigu.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/20 22:57 周四
 * description: 购物车接收参数
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartParam {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("product_id")
    private Integer productId;
    private Integer num;
}
