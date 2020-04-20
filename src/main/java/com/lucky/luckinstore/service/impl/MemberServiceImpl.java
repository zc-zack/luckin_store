package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.mapper.UserMapper;
import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.service.MemberService;
import com.lucky.luckinstore.util.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/20
 * @description: MemberService的实现层
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserMapper userMapper;

    private LayuiUtil layuiUtil;

    @Override
    public JSONObject getAllUserByStatusJSON(Integer status) {
        layuiUtil = new LayuiUtil();
        List<UserDTO> userList = userMapper.selectAllUserByTele("12");
        JSONObject userJSON = layuiUtil.getLayuiJSON(userList);
        return userJSON;
    }
}
