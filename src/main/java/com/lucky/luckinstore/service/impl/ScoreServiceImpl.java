package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.mapper.ScoreMapper;
import com.lucky.luckinstore.pojo.dto.ScoreDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.vo.ScoreVO;
import com.lucky.luckinstore.service.ScoreService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description:
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private HttpSession session;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(ScoreServiceImpl.class);

    /**
     * @return json
     * @description 获取所有积分情况
     * @author 张成
     * @date 2019/9/21 9:52
     */
    @Override
    public List<ScoreVO> selectAllScore() {
        List<ScoreDTO> scoreDTOList = scoreMapper.selectAllScore();
        JSONArray scoreJSON = JSONArray.parseArray(JSON.toJSONString(scoreDTOList));
        List<ScoreVO> scoreVOList = JSONObject.parseArray(scoreJSON.toJSONString(), ScoreVO.class);
        logger.info("scoreVOList: " + scoreVOList);
        return scoreVOList;
    }

    /**
     * @param scoreDTO
     * @return int
     * @description result，如果更新成功，则result.data为1，否则为0
     * @author 张成
     * @date 2019/9/23 14:33
     */
    @Override
    public Result<Integer> updateScoreByUserId(ScoreDTO scoreDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        Result<Integer> result = new Result<>();
        result.setData(scoreMapper.updateScoreByUserId(scoreDTO));
        logger.info(result.toString());
        return result;
    }

    /**
     * @param scoreDTO
     * @return int
     * @description 用户完成订单后增加积分
     * @author 张成
     * @date 2019/9/29 22:06
     */
    @Override
    public int updatePayScoreByUserId(ScoreDTO scoreDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        scoreDTO.setUserId(userDTO.getId());
        return scoreMapper.updatePayScoreByUserId(scoreDTO);
    }

}
