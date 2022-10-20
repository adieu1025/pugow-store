package com.atguigu.search.service;

import com.atguigu.param.ProductParamsSearch;
import com.atguigu.utils.R;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/19 18:55 周三
 * description:
 */
public interface SearchService {

    /**
     * 商品搜索
     * @param productParamsSearch
     * @return
     */
    R search(ProductParamsSearch productParamsSearch) throws JsonProcessingException;
}
