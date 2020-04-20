package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.UserVO;
import com.lucky.luckinstore.service.LoginService;
import com.lucky.luckinstore.service.UserService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 登录的控制层
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;
    //日志
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * @return 返回登录页面
     * @description 页面的view
     * @author 张成
     * @date 2019/9/19 18:55
     */
    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        return "login";
    }


    /**
     * @param
     * @return
     * @description
     * @author 张成
     * @date 2019/9/19 19:38
     */
    @PostMapping("/checkPassword")
    @ResponseBody
    public Result<Integer> checkPassword(@RequestBody UserAO userAO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userAO, userDTO);
        logger.info(userDTO.toString());
        Result<Integer> result = loginService.checkPassWord(userDTO);
        return result;
    }

    @GetMapping("/logOut")
    public String logOut(){
        loginService.removeSessionUser();
        return "/login";
    }

}
