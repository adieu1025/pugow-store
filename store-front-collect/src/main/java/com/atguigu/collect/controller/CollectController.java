package com.atguigu.collect.controller;

import com.atguigu.collect.service.CollectService;
import com.atguigu.param.CollectParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/20 14:49 周四
 * description: 收藏controller
 */
@RestController
@RequestMapping("collect")
public class CollectController {

    @Autowired
    private CollectService collectService;


    @PostMapping("save")
    public Object save(@RequestBody CollectParam collectParam){

        return collectService.save(collectParam);
    }


    @PostMapping("list")
    public Object list(@RequestBody CollectParam collectParam){

        return collectService.list(collectParam);
    }

    @PostMapping("remove")
    public Object remove(@RequestBody CollectParam collectParam){

        return collectService.remove(collectParam);
    }

}
