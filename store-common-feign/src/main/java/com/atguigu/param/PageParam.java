package com.atguigu.param;

import lombok.Data;

/**
 * projectName: b2c-cloud-store
 *
 * @author: canon
 * time: 2022/10/22 14:32 周六
 * description: 分页参数
 */
@Data
public class PageParam {

    private int    currentPage = 1;
    private int    pageSize = 15;
}
