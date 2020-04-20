package com.lucky.luckinstore.service.impl;

import com.lucky.luckinstore.mapper.ScoreMapper;
import com.lucky.luckinstore.mapper.UserMapper;
import com.lucky.luckinstore.pojo.dto.ScoreDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.service.RegisterService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 注册的service实现层
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    //已经注册的返回值
    final private int REGISTERED = 0;

    //未被注释的返回值
    final private int UNREGISTER = 1;
    //信息完善时的值
    private final static Integer OK = 1;
    //信息不完善时的值
    private final static Integer ERROR = 0;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    private final static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    /**
     * @param username
     * @return int
     * @description 验证用户名是否已经被注册，如果没有返回1，否则返回0
     * @author 张成
     * @date 2019/9/21 10:15
     */
    @Override
    public Result<Integer> checkUsername(String username) {
        Result<Integer> result = new Result<>();
        Integer userId = userMapper.selectUserIdByUsername(username);
        logger.info(String.valueOf(userId));
        if(userId != null){
            result.setData(0);
            logger.info("in");
            result.setMsg("用户名已被注册");
        }else {
            result.setData(1);
        }
        return result;
    }

    /**
     * @param userDTO
     * @return int
     * @description 插入新的用户
     * @author 张成
     * @date 2019/9/21 11:28
     */
    @Override
    public Result<Integer> insertUser(UserDTO userDTO) {
        Result<Integer> result = checkRegisterInfo(userDTO);
        if(ERROR.equals(result.getData())){
            return result;
        }
        //插入用户基础信息返回用户id
        userMapper.insertUser(userDTO);
        ScoreDTO scoreDTO = new ScoreDTO();
        //将返回的用户id用于生成用户的积分表
        scoreDTO.setUserId(userDTO.getId());
        scoreMapper.insertScoreRecord(scoreDTO);
        //将用户生成的积分表存入用户信息中
        userDTO.setScoreId(scoreDTO.getId());
        result.setCode(userMapper.updateRegister(userDTO));
        return result;
    }

    /**
     * @param userDTO
     * @return result
     * @description 后台验证注册信息是否完善
     * @author 张成
     * @date 2019/10/9 1:29
     */
    @Override
    public Result<Integer> checkRegisterInfo(UserDTO userDTO) {
        Result<Integer> result = new Result<>();
        Integer userId = userMapper.selectUserIdByUsername(userDTO.getUsername());
        //验证注册的信息是否完整，如果不满足条件则data的值为0否则为1
        if(userId != null){
            result.setData(ERROR);
            result.setMsg("用户名已被注册");
        }else if("".equals(userDTO.getTele()) || userDTO.getTele() == null){
            result.setData(ERROR);
            result.setMsg("电话号码为空");
        }else{
            result.setData(OK);
        }
        return result;
    }
}
