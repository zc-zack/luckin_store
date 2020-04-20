package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.ScoreDTO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

public interface ScoreMapper {

    /**
     * @return list
     * @description 获取所有用户积分情况
     * @author 张成
     * @date 2019/9/21 9:51
     */
    List<ScoreDTO> selectAllScore();

    /**
     * @param scoreDTO
     * @return int
     * @description 当创建用户时更新积分
     * @author 张成
     * @date 2019/9/21 13:08
     */
    int insertScoreRecord(ScoreDTO scoreDTO);

    /**
     * @description 更新用户积分
     * @author 张成
     * @date 2019/9/23 14:32
     * @param scoreDTO
     * @return int，如果更新成功，则result.data为1，否则为0
     */
    int updateScoreByUserId(ScoreDTO scoreDTO);

    /**
     * @description 当用户下单时更新
     * @author 张成
     * @date 2019/9/29 22:05
     * @param scoreDTO
     * @return int
     */
    int updatePayScoreByUserId(ScoreDTO scoreDTO);
}