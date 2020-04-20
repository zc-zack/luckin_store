package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.dto.CommentDTO;
import com.lucky.luckinstore.pojo.vo.CommentVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/10/12
 * @description: 评价操作的Service
 */
public interface CommentService {

    /**
     * @description 插入新的评价
     * @author 张成
     * @date 2019/10/12 10:26
     * @param
     * @return
     */
    Result<Integer> insertComment(CommentDTO commentDTO);

    /**
     * @description 根据商品名获取商品评价
     * @author 张成
     * @date 2019/10/12 14:40
     * @param goodsId
     * @return List 评价列表
     */
    List<CommentVO> selectCommentByGoodsId(Integer goodsId);
}
