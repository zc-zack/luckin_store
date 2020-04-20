package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.luckinstore.mapper.UserMapper;
import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.dto.MemberDTO;
import com.lucky.luckinstore.pojo.dto.PasswordDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.dto.UserPortraitDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.UserVO;
import com.lucky.luckinstore.service.UserService;
import com.lucky.luckinstore.util.LayuiUtil;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * @description 返回用户的所有信息
     * @author 张成
     * @date 2019/9/23 0:32
     * @return json
     */
    @Override
    public JSONObject selectAllUserByTeleJSON(String tele) {
        return null;
    }

    /**
     * @param passwordDTO
     * @return int
     * @description 根据用户id修改密码
     * @author 张成
     * @date 2019/9/23 2:06
     */
    @Override
    public int updatePasswordByUserId(PasswordDTO passwordDTO) {

        return userMapper.updatePasswordByUserId(passwordDTO);
    }

    /**
     * @param userDTO
     * @return int
     * @description 修改用户状态
     * @author 张成
     * @date 2019/9/24 11:02
     */
    @Override
    public int updateUserStatusById(UserDTO userDTO) {
        return userMapper.updateUserStatusById(userDTO);
    }

    /**
     * @return list
     * @description 根据用户状态获取用户
     * @author 张成
     * @date 2019/9/24 16:54
     */
    @Override
    public Result<List> selectAllUserByTeleList(String tele, Integer pageNum, Integer pageSize) {
        //数据库分页
        Result<List> result = new Result<>();
        PageHelper.startPage(pageNum, pageSize);
        List<UserDTO> userDTOList = userMapper.selectAllUserByTele(tele);
        PageInfo<UserDTO> pageInfo = new PageInfo<UserDTO>(userDTOList);
        JSONArray userJSON = JSONArray.parseArray(JSON.toJSONString(userDTOList));
        List<UserVO> userVOList = JSONObject.parseArray(userJSON.toJSONString(), UserVO.class);
        logger.info("userVOList: " +  userVOList.toString());
        for(UserVO userVO: userVOList){
            if( userVO.getRole() == 0 ){
                userVO.setRoleName("普通用户");
            }
        }
        result.setData(userVOList);
        result.setCount(userVOList.size());
        return result;
    }

    /**
     * @return userVO
     * @description 获取一些用户信息用于登录后
     * @author 张成
     * @date 2019/9/29 16:26
     */
    @Override
    public UserVO getUser() {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        UserVO userVO = new UserVO();
        if(userDTO != null){
            BeanUtils.copyProperties(userDTO, userVO);
        }
        return userVO;
    }

    /**
     * @return UserVO
     * @description 获取用户信息
     * @author 张成
     * @date 2019/9/29 20:41
     */
    @Override
    public UserVO selectUserById() {
        UserDTO user = (UserDTO) session.getAttribute("user");
        logger.info(String.valueOf(user.getId()));
        UserDTO userDTO = userMapper.selectUserById(user.getId());
        logger.info(userDTO.toString());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDTO, userVO);
        userVO.setId(user.getId());
        return userVO;
    }

    /**
     * @param userDTO
     * @return int
     * @description 更新用户信息
     * @author 张成
     * @date 2019/9/30 1:48
     */
    @Override
    public int updateUserById(UserDTO userDTO) {
        User user = (User) session.getAttribute("user");
        userDTO.setId(user.getId());
        return userMapper.updateUserById(userDTO);
    }

    /**
     * @param userPortraitDTO
     * @return 如果更新成功则result.data为1
     * @Description 更新用户头像
     * @Author 张成
     * @Date 2019/10/13 14:48
     */
    @Override
    public Result<Integer> updatePortraitById(UserPortraitDTO userPortraitDTO) {
        Result<Integer> result = new Result<>();
        result.setData(userMapper.updatePortraitById(userPortraitDTO));
        return result;
    }


}
