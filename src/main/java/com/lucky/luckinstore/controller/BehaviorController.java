package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.pojo.ao.BehaviorAO;
import com.lucky.luckinstore.pojo.dto.BehaviorDTO;
import com.lucky.luckinstore.service.BehaviorService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description:
 */
@RestController
@RequestMapping("/behavior")
public class BehaviorController {

    @Autowired
    private BehaviorService behaviorService;

    //日志
    private static final Logger logger = LoggerFactory.getLogger(BehaviorController.class);

    /**
     * @description 更新用户行为数据的接口
     * @author 张成
     * @date 2019/10/11 16:28
     * @param behaviorAO
     * @return result 如果更新成功则result.data为1，否则为0
     */
    @PostMapping("/updateBehavior")
    public Result<Integer> updateBehavior(@RequestBody BehaviorAO behaviorAO){
        logger.info("behavior: " + behaviorAO.toString());
        BehaviorDTO behaviorDTO = new BehaviorDTO();
        BeanUtils.copyProperties(behaviorAO, behaviorDTO);
        return null;
    }
}
