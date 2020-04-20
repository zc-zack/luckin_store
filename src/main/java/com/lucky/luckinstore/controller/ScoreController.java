package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.pojo.ao.ScoreAO;
import com.lucky.luckinstore.pojo.dto.ScoreDTO;
import com.lucky.luckinstore.pojo.vo.ScoreVO;
import com.lucky.luckinstore.service.ScoreService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 积分操作的TOC层
 */
@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    //
    private final static Logger logger = LoggerFactory.getLogger(ScoreController.class);

    /**
     * @return result
     * @description 返回所有用户积分情况
     * @author 张成
     * @date 2019/9/21 9:45
     */
    @RequestMapping("/score/getAllScore")
    public Result<List> getAllScore() {
        Result<List> result = new Result<>();
        List<ScoreVO> scoreVOList = scoreService.selectAllScore();
        result.setData(scoreVOList);
        result.setCount(scoreVOList.size());
        return result;
    }

    /**
     * @description 修改积分
     * @author 张成
     * @date 2019/9/23 14:36
     * @param scoreAO
     * @return result, 如果修改成功则result.data为1否则为0
     */
    @PostMapping("/score/alterScore")
    public Result<Integer> alterScore(@RequestBody ScoreAO scoreAO){
        ScoreDTO scoreDTO = new ScoreDTO();
        BeanUtils.copyProperties(scoreAO, scoreDTO);
        logger.info(scoreDTO.toString());
        Result<Integer> result = scoreService.updateScoreByUserId(scoreDTO);
        return result;
    }
}
