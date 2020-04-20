package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.vo.UserVO;
import com.lucky.luckinstore.service.RegisterService;
import com.lucky.luckinstore.service.UserService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 注册的TOC层
 */
@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping("/register")
    public String register(ModelMap modelMap) {
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        return "register";
    }

    /**
     * @param username
     * @return int
     * @description 验证用户名是否被注册
     * @author 张成
     * @date 2019/9/21 10:25
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Result<Integer> checkUsername(@RequestBody String username) {
        logger.info(username);
        Result<Integer> result = registerService.checkUsername(username);
        logger.info("logger:" + result.toString());
        return result;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Result<Integer> addUser(@RequestBody UserAO userAO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userAO, userDTO);
        logger.info(userDTO.toString());
        return registerService.insertUser(userDTO);
    }
}
