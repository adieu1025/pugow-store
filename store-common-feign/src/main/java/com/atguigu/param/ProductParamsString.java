package com.atguigu.param;

import lombok.Data;

import java.util.List;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/17 22:43 周一
 * description: 类别名称集合参数
 * todo: 对应参数类型 {categoryName:["","",""]}
 */
@Data
public class ProductParamsString {

    private List<String> categoryName;
}
