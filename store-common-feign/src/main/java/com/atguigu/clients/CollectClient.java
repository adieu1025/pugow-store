package com.atguigu.clients;

import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/25 9:29 周二
 * description: 收藏client
 */
@FeignClient(value = "collect-service")
public interface CollectClient {

    @PostMapping("/collect/remove/bypid")
    R removeByPID(@RequestBody Integer productId);
}
