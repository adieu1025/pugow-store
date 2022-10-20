package com.atguigu.clients;

import com.atguigu.param.ProductParamsSearch;
import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/19 19:18 周三
 * description:
 */
@FeignClient(name = "search-service")
public interface SearchClient {

    /**
     * 搜索服务 商品查询
     * @param productParamsSearch
     * @return
     */
    @PostMapping("/search/product")
    R search(@RequestBody ProductParamsSearch productParamsSearch);

}
