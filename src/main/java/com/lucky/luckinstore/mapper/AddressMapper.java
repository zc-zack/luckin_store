package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.AddressDTO;
import com.lucky.luckinstore.pojo.dto.SearchOrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    /**
     * @description 地址信息
     * @author 张成
     * @date 2019/9/27 9:14
     * @param addressId
     * @return AddressDTO
     */
    AddressDTO selectAddressById(Integer addressId);

    /**
     * @description 获取所有地址
     * @author 张成
     * @date 2019/9/27 11:11
     * @param userId
     * @param deleted
     * @return list
     */
    List<AddressDTO> selectAddressByUserId(@Param("userId") Integer userId, @Param("deleted") Boolean deleted);

    /** 
     * @description 插入新的地址
     * @author 张成
     * @date 2019/9/27 15:01
     * @param addressDTO
     * @return int
     */
    int insertAddress(AddressDTO addressDTO);

    /**
     * @description 更新地址信息
     * @author 张成
     * @date 2019/10/11 2:32
     * @param addressDTO
     * @return int 更新成功就返回1，否则返回0
     */
    int updateAddressById(AddressDTO addressDTO);

    /**
     * @description 更新地址是否被删除
     * @author 张成
     * @date 2019/10/11 3:09
     * @param addressDTO
     * @return 如果更新成功返回1 否则返回0
     */
    int updateDeletedById(AddressDTO addressDTO);
}