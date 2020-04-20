package com.lucky.luckinstore.service.impl;

import com.lucky.luckinstore.mapper.BehaviorMapper;
import com.lucky.luckinstore.pojo.dto.BehaviorDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.service.BehaviorService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description: 行为标注的serviceimpl
 */
@Service
public class BehaviorServiceImpl implements BehaviorService {

    @Autowired
    private BehaviorMapper behaviorMapper;

    @Autowired
    private HttpSession session;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(BehaviorServiceImpl.class);

    /**
     * @param behaviorDTO
     * @return result 如果更新成功则result.data为1否则为0
     * @description 更新行为标注，如果没有这个行为的记录则创建一个新的
     * @author 张成
     * @date 2019/10/11 16:11
     */
    @Override
    public Result<Integer> updateBehaviorById(BehaviorDTO behaviorDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        Result<Integer> result = new Result<>();
        behaviorDTO.setUserId(userDTO.getId());
        Integer data = 0;
        //查找是否已经有这个行为标注
        Integer id = behaviorMapper.selectIdByUserIdAndLabelId(behaviorDTO);
        logger.info("id: " + id);
        //如果不存在则创建一个新的
        if(id == null){
            logger.info("id = null");
            data = behaviorMapper.insertBehavior(behaviorDTO);
        } else {
            logger.info("id != null");
            behaviorDTO.setId(id);
            logger.info(behaviorDTO.toString());
            data = behaviorMapper.updateBehaviorById(behaviorDTO);
        }
        result.setData(data);
        return result;
    }
}
