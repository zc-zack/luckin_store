package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    /**
     * @description 插入评价数据
     * @author 张成
     * @date 2019/10/12 0:53
     * @param goodsIdList
     * @return int 如果插入成功则返回1 否则返回0
     */
    int insertComment(@Param("list")List<Integer> goodsIdList, @Param("content")String content, @Param("userId")Integer userId);

    /**
     * @description 通过商品id获取所有评价列表
     * @author 张成
     * @date 2019/10/12 14:42
     * @param goodsId
     * @return list 评价列表
     */
    List<CommentDTO> selectCommentByGoodsId(Integer goodsId);
}