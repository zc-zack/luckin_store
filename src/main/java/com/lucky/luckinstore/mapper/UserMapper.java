package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.MemberDTO;
import com.lucky.luckinstore.pojo.dto.PasswordDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.dto.UserPortraitDTO;

import java.util.List;

public interface UserMapper {

    /**
     * @param username
     * @return userDTO
     * @description 通过用户名获取密码
     * @author 张成
     * @date 2019/9/19 19:47
     */
    UserDTO selectUserByUsername(String username);


    /**
     * @param tele
     * @return List
     * @description 通过用户的状态来获取所有用户
     * @author 张成
     * @date 2019/9/20 10:50
     */
    List<UserDTO> selectAllUserByTele(String tele);

    /**
     * @return list
     * @description 查询所有的用户名用来前端验证
     * @author 张成
     * @date 2019/9/21 10:12
     */
    List<String> selectAllUsername();

    /**
     * @param userDTO
     * @return int
     * @description 插入新的用户
     * @author 张成
     * @date 2019/9/21 11:27
     */
    int insertUser(UserDTO userDTO);

    /**
     * @param userDTO
     * @return int
     * @description 更新用户注册时的修改者和创建者信息
     * @author 张成
     * @date 2019/9/21 11:41
     */
    int updateRegister(UserDTO userDTO);

    /**
     * @description 所用会员的信息
     * @author 张成
     * @date 2019/9/23 0:04
     * @return list
     */
    List<MemberDTO> selectAllMemberByStatus(Integer status);

    /**
     * @description  根据用户ID修改密码
     * @author 张成
     * @date 2019/9/23 2:04
     * @param passwordDTO
     * @return int
     */
    int updatePasswordByUserId(PasswordDTO passwordDTO);

    /**
     * @description 更新用户状态通过用户id
     * @author 张成
     * @date 2019/9/24 11:00
     * @param userDTO
     * @return int
     */
    int updateUserStatusById(UserDTO userDTO);

    /**
     * @description 通过用户名获取用户id
     * @author 张成
     * @date 2019/9/26 17:07
     * @param username
     * @return int
     */
    Integer selectUserIdByUsername(String username);

    /**
     * @description 根据用户id返回用户信息
     * @author 张成
     * @date 2019/9/29 19:14
     * @param userId
     * @return userDTO
     */
    UserDTO selectUserById(Integer userId);

    /**
     * @description 更新用户信息
     * @author 张成
     * @date 2019/9/30 1:47
     * @param userDTO
     * @return int
     */
    int updateUserById(UserDTO userDTO);

    /**
     * @Description 更新用户头像
     * @Author 张成
     * @Date 2019/10/13 14:47
     * @param userPortraitDTO
     * @return int 如果更新成功则返回1
     */
    int updatePortraitById(UserPortraitDTO userPortraitDTO);
}