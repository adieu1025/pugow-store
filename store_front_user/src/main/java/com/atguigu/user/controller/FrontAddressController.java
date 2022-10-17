package com.atguigu.user.controller;

import com.atguigu.pojo.Address;
import com.atguigu.user.service.AddressService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * projectName: b2c_cloud_store
 *
 * @author: 赵伟风
 * time: 2022/10/17 11:10 周一
 * description: 前台地址维护controller
 */
@RestController
@RequestMapping("/user/address")
public class FrontAddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("list")
    public R list(@RequestBody Map<String,Integer> params){
        Integer userId = params.get("userId");
        return addressService.list(userId);
    }


    @PostMapping("save")
    public R save(@RequestBody Address address){

        return addressService.save(address);
    }


    @PostMapping("remove")
    public R remove(@RequestBody Map<String,Integer> params){
        Integer id = params.get("id");
        return addressService.remove(id);
    }


}
