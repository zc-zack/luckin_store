package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.dto.ScoreDTO;
import com.lucky.luckinstore.pojo.vo.ScoreVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description:
 */
public interface ScoreService {

    /**
     * @return json
     * @description 获取所有积分情况
     * @author 张成
     * @date 2019/9/21 9:52
     */
    List<ScoreVO> selectAllScore();

    /**
     * @description 更新用户的积分
     * @author 张成
     * @date 2019/9/23 14:33
     * @param scoreDTO
     * @return result，如果更新成功，则result.data为1，否则为0
     */
    Result<Integer> updateScoreByUserId(ScoreDTO scoreDTO);

    /**
     * @description 用户完成订单后增加积分
     * @author 张成
     * @date 2019/9/29 22:06
     * @param scoreDTO
     * @return int
     */
    int updatePayScoreByUserId(ScoreDTO scoreDTO);
}
