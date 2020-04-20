package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.util.Result;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 注册的service层
 */
public interface RegisterService {
    /**
     * @param username
     * @return int
     * @description 验证用户名是否已经被注册，如果没有返回1，否则返回0
     * @author 张成
     * @date 2019/9/21 10:15
     */
    Result<Integer> checkUsername(String username);

    /**
     * @param userDTO
     * @return int
     * @description 插入新的用户
     * @author 张成
     * @date 2019/9/21 11:28
     */
    Result<Integer> insertUser(UserDTO userDTO);

    /**
     * @description 后台验证注册信息是否完善
     * @author 张成
     * @date 2019/10/9 1:29
     * @param userDTO
     * @return result
     */
    Result<Integer> checkRegisterInfo(UserDTO userDTO);
}
