package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.util.Result;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 登录的service接口
 */
public interface LoginService {

    /**
     * @description 验证账号密码
     * @author 张成
     * @date 2019/10/10 9:57
     * @param userDTO
     * @return result 如果密码正确则result.data为1否则为0
     */
    Result<Integer> checkPassWord(UserDTO userDTO);

    /**
     * @description 清除session中的user，退出登录
     * @author 张成
     * @date 2019/10/10 9:59
     * @return void
     */
    void removeSessionUser();
}
