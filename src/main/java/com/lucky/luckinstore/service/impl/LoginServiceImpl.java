package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.mapper.UserMapper;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.service.LoginService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 登录服务层的实现
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;
    //日志
    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * @param userDTO
     * @return 是否密码正确，正确返回1， 错误返回0
     * @description
     * @author 张成
     * @date 2019/9/19 19:51
     */
    @Override
    public Result<Integer> checkPassWord(UserDTO userDTO) {
        Result<Integer> result = new Result<>();
        UserDTO checkUser = userMapper.selectUserByUsername(userDTO.getUsername());
        //检查是否能查到用户的信息，如果为null说明用户名输入错误
        if (checkUser != null) {
            if (0 == checkUser.getStatus()) {
                result.setCode(0);
                result.setMsg("此用户已被封禁！");
            } else if ( checkUser.getPassword().equals(userDTO.getPassword()) ) {
                userDTO.setId(checkUser.getId());
                session.setAttribute("user", userDTO);
                result.setCode(1);
                result.setData(checkUser.getRole());
            } else {
                result.setMsg("密码错误！");
                result.setCode(0);
            }
        } else {
            result.setMsg("用户不存在！");
            result.setCode(0);
        }
        logger.info(result.toString());
        return result;
    }

    /**
     * @return void
     * @description 清除session中的user，退出登录
     * @author 张成
     * @date 2019/10/10 9:59
     */
    @Override
    public void removeSessionUser() {
        session.removeAttribute("user");
    }
}
