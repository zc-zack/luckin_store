package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.dto.BehaviorDTO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description: 行为记录的service
 */
public interface BehaviorService {
    /**
     * @description 更新行为标注，如果没有这个行为的记录则创建一个新的
     * @author 张成
     * @date 2019/10/11 16:11
     * @param behaviorDTO
     * @return result 如果更新成功则result.data为1否则为0
     */
    Result<Integer> updateBehaviorById(BehaviorDTO behaviorDTO);


}
