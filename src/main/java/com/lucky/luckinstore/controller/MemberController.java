package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.dto.PasswordDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.service.UserService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/20
 * @description: 对会员进行操作的controller层
 */
@RestController
public class MemberController {

    @Autowired
    private UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    /**
     * @description 返回所有
     * @author 张成
     * @date 2019/9/23 0:41
     * @param
     * @return
     */
    @GetMapping("/getAllMember")
    public Result<List> getAllMember(@RequestParam String tele, Integer page, Integer limit) {
        logger.info("page: " + page + "limit: " + limit);
        return userService.selectAllUserByTeleList(tele, page, limit);
    }

    /**
     * @description 重置用户密码
     * @author 张成
     * @date 2019/9/24 11:23
     * @param passwordDTO
     * @return int
     */
    @RequestMapping("/resetPassword")
    public Result<Integer> resetPassword(@RequestBody PasswordDTO passwordDTO){
        Result<Integer> result = new Result<>();
        result.setData(userService.updatePasswordByUserId(passwordDTO));
        return result;
    }

    @RequestMapping("/admin/alterUserStatus")
    public int alterUserStatus(@RequestBody UserDTO userDTO){
        return userService.updateUserStatusById(userDTO);
    }

    /**
     * @description 获取所有封禁的用户
     * @author 张成
     * @date 2019/9/24 11:51
     * @return json
     */
    @RequestMapping("/getBannedMember")
    public JSONObject getBannedMember(){
        return userService.selectAllUserByTeleJSON("");
    }

}
