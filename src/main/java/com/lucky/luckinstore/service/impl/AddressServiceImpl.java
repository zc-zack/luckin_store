package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.mapper.AddressMapper;
import com.lucky.luckinstore.pojo.dto.AddressDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.AddressVO;
import com.lucky.luckinstore.service.AddressService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private HttpSession session;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
    /**
     * @param deleted
     * @return list
     * @description 通过用户id和是否被删除获取用户地址
     * @author 张成
     * @date 2019/9/27 11:19
     */
    @Override
    public List<AddressVO> selectAddressByUserIdAndDeleted(Boolean deleted) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<AddressDTO> addressDTOList = addressMapper.selectAddressByUserId(userDTO.getId(), false);
        JSONArray addressJSON = JSONArray.parseArray(JSON.toJSONString(addressDTOList));
        List<AddressVO> addressVOList = JSONObject.parseArray(addressJSON.toJSONString(), AddressVO.class);
        return addressVOList;
    }

    /**
     * @param addressDTO
     * @return int
     * @description 插入新的地址
     * @author 张成
     * @date 2019/9/27 15:08
     */
    @Override
    public Result<Integer> insertAddress(AddressDTO addressDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        addressDTO.setUserId(userDTO.getId());
        Result<Integer> result = new Result<>();
        result.setData(addressMapper.insertAddress(addressDTO));
        return result;
    }

    /**
     * @param addressDTO
     * @return result, 如果更新成功，result.data为1， 否则为0
     * @description 更新收货地址
     * @author 张成
     * @date 2019/10/11 2:33
     */
    @Override
    public Result<Integer> updateAddressById(AddressDTO addressDTO) {
        Result<Integer> result = new Result<>();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        addressDTO.setUserId(userDTO.getId());
        logger.info("addressDTO: " + addressDTO.toString());
        result.setData(addressMapper.updateAddressById(addressDTO));
        return result;
    }

    /**
     * @param addressDTO
     * @return result, 如果更新成功，result.data为1， 否则为0
     * @description 更新地址是否被删除的状态
     * @author 张成
     * @date 2019/10/11 3:10
     */
    @Override
    public Result<Integer> updateDeletedById(AddressDTO addressDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        addressDTO.setUserId(userDTO.getId());
        Result<Integer> result = new Result<>();
        result.setData(addressMapper.updateDeletedById(addressDTO));
        return result;
    }


}
