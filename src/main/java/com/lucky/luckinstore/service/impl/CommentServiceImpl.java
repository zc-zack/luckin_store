package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.mapper.CommentMapper;
import com.lucky.luckinstore.mapper.OrderGoodsMapper;
import com.lucky.luckinstore.mapper.OrderMapper;
import com.lucky.luckinstore.pojo.dto.CommentDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.vo.CommentVO;
import com.lucky.luckinstore.service.CommentService;
import com.lucky.luckinstore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/10/12
 * @description: 评价的service的实现层
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderMapper orderMapper;
    /**
     * @param commentDTO
     * @return result 如果插入成功则result.data为1，否则为0
     * @description 插入新的评价
     * @author 张成
     * @date 2019/10/12 10:26
     */
    @Override
    public Result<Integer> insertComment(CommentDTO commentDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<Integer> goodsIdList = orderGoodsMapper.selectGoodsIdByOrderId(commentDTO.getOrderId());
        Result<Integer> result = new Result<>();
        result.setData(commentMapper.insertComment(goodsIdList, commentDTO.getContent(), userDTO.getId()));
        orderMapper.updateOrderStatusById(StaticVariable.STATUS_COMMENTED, commentDTO.getOrderId());
        return result;
    }

    /**
     * @param goodsId
     * @return List 评价列表
     * @description 根据商品名获取商品评价
     * @author 张成
     * @date 2019/10/12 14:40
     */
    @Override
    public List<CommentVO> selectCommentByGoodsId(Integer goodsId) {
        List<CommentDTO> commentDTOList = commentMapper.selectCommentByGoodsId(goodsId);
        JSONArray commentJSON = JSONArray.parseArray(JSON.toJSONString(commentDTOList));
        List<CommentVO> commentVOList = JSONObject.parseArray(commentJSON.toJSONString(), CommentVO.class);
        return commentVOList;
    }
}
