package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.pojo.ao.AddressAO;
import com.lucky.luckinstore.pojo.dto.AddressDTO;
import com.lucky.luckinstore.pojo.entity.Address;
import com.lucky.luckinstore.service.AddressService;
import com.lucky.luckinstore.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * @description 新增地址的C层
     * @author 张成
     * @date 2019/9/27 15:24
     * @param addressAO
     * @return int
     */
    @PostMapping ("/addAddress")
    public Result<Integer> addAddress(@RequestBody AddressAO addressAO){
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(addressAO, addressDTO);
        Result<Integer> result = addressService.insertAddress(addressDTO);
        return result;
    }

    /**
     * @description 修改购物车数据
     * @author 张成
     * @date 2019/10/11 2:21
     * @param addressAO
     * @return result 如果成功则result.data为1，否则为0
     */
    @PostMapping("/updateAddress")
    public Result<Integer> updateAddress(@RequestBody AddressAO addressAO){
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(addressAO, addressDTO);
        Result<Integer> result = addressService.updateAddressById(addressDTO);
        return result;
    }

    /**
     * @description 更新地址是否被删除状态的结构
     * @author 张成
     * @date 2019/10/11 3:13
     * @param addressAO
     * @return result, 如果更新成功，result.data为1， 否则为0
     */
    @PostMapping("/updateDeleted")
    public Result<Integer> updateDeleted(@RequestBody AddressAO addressAO){
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(addressAO, addressDTO);
        Result<Integer> result = addressService.updateDeletedById(addressDTO);
        return result;
    }

}
