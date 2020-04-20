package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.dto.PasswordDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.dto.UserPortraitDTO;
import com.lucky.luckinstore.pojo.vo.UserVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description: 用户的操作service层
 */
public interface UserService {

    /**
     * @description 返回用户的所有信息
     * @author 张成
     * @date 2019/9/23 0:32
     * @return json
     */
    JSONObject selectAllUserByTeleJSON(String tele);

    /**
     * @description 根据用户id修改密码
     * @author 张成
     * @date 2019/9/23 2:06
     * @param passwordDTO
     * @return int
     */
    int updatePasswordByUserId(PasswordDTO passwordDTO);

    /**
     * @description 修改用户状态
     * @author 张成
     * @date 2019/9/24 11:02
     * @param userDTO
     * @return int
     */
    int updateUserStatusById(UserDTO userDTO);

    /**
     * @description 根据手机号查询用户
     * @author 张成
     * @date 2019/9/24 16:54
     * @return list
     */
    Result<List> selectAllUserByTeleList(String tele, Integer pageNum, Integer pageSize);

    /**
     * @description 获取一些用户信息用于登录后
     * @author 张成
     * @date 2019/9/29 16:26
     * @return userVO
     */
    UserVO getUser();

    /**
     * @description 获取用户信息
     * @author 张成
     * @date 2019/9/29 20:41
     * @return UserVO
     */
    UserVO selectUserById();

    /**
     * @description 更新用户信息
     * @author 张成
     * @date 2019/9/30 1:48
     * @param userDTO
     * @return int
     */
    int updateUserById(UserDTO userDTO);

    /**
     * @Description 更新用户头像
     * @Author 张成
     * @Date 2019/10/13 14:48
     * @param userPortraitDTO
     * @return 如果更新成功则result.data为1
     */
    Result<Integer> updatePortraitById(UserPortraitDTO userPortraitDTO);
}
