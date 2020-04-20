package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.BehaviorDTO;

import java.util.List;

public interface BehaviorMapper {

    /**
     * @description 插入新的行为
     * @author 张成
     * @date 2019/10/11 16:00
     * @param behaviorDTO
     * @return int, 如果成功则返回1，否则返回2
     */
    int insertBehavior(BehaviorDTO behaviorDTO);

    /**
     * @description 查询数据库中是否有这个行为的记录
     * @author 张成
     * @date 2019/10/11 16:04
     * @param behaviorDTO
     * @return 行为id
     */
    Integer selectIdByUserIdAndLabelId(BehaviorDTO behaviorDTO);

    /**
     * @description 更新用户的行为权重
     * @author 张成
     * @date 2019/10/11 16:07
     * @param behaviorDTO
     * @return int
     */
    int updateBehaviorById(BehaviorDTO behaviorDTO);

    /**
     * @description 根据用户id返回标签id降序
     * @author 张成
     * @date 2019/10/11 21:28
     * @param userId
     * @return list 标签id
     */
    List<Integer> selectLabelIdByUserId(Integer userId);
}