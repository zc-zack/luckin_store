package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.dto.AddressDTO;
import com.lucky.luckinstore.pojo.vo.AddressVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
public interface AddressService {

    /**
     * @description 通过用户id和是否被删除获取用户地址
     * @author 张成
     * @date 2019/9/27 11:19
     * @param deleted
     * @return list
     */
    List<AddressVO> selectAddressByUserIdAndDeleted(Boolean deleted);

    /**
     * @description 插入新的地址
     * @author 张成
     * @date 2019/9/27 15:08
     * @param addressDTO
     * @return result 如果插入成功则result.data为1否则为0
     */
    Result<Integer> insertAddress(AddressDTO addressDTO);

    /**
     * @description 更新收货地址
     * @author 张成
     * @date 2019/10/11 2:33
     * @param addressDTO
     * @return result, 如果更新成功，result.data为1， 否则为0
     */
    Result<Integer> updateAddressById(AddressDTO addressDTO);

    /**
     * @description 更新地址是否被删除的状态
     * @author 张成
     * @date 2019/10/11 3:10
     * @param addressDTO
     * @return result, 如果更新成功，result.data为1， 否则为0
     */
    Result<Integer> updateDeletedById(AddressDTO addressDTO);
}
