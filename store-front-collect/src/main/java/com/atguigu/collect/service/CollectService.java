package com.atguigu.collect.service;

import com.atguigu.param.CollectParam;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/20 14:50 周四
 * description:
 */
public interface CollectService {

    /**
     * 收藏保存服务
     * @param collectParam
     * @return
     */
    Object save(CollectParam collectParam);

    /**
     * 查询收藏列表
     * @param collectParam
     * @return
     */
    Object list(CollectParam collectParam);

    /**
     * 删除收藏业务
     * @param collectParam
     * @return
     */
    Object remove(CollectParam collectParam);
}
