package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.mapper.GoodsMapper;
import com.lucky.luckinstore.mapper.ShoppingCartMapper;
import com.lucky.luckinstore.pojo.dto.*;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.ShoppingCartVO;
import com.lucky.luckinstore.service.BehaviorService;
import com.lucky.luckinstore.service.ShoppingCartService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private HttpSession session;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private BehaviorService behaviorService;

    @Autowired
    private GoodsMapper goodsMapper;
    //成功时的数值
    private final static Integer OK = 1;
    //失败时的数值
    private final static Integer ERROR = 0;

    private User user;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    /**
     * @param shoppingCartDTO
     * @return int
     * @description 添加商品至购物车
     * @author 张成
     * @date 2019/9/26 17:22
     */
    @Override
    public Result<Integer> insertGoodsIntoCart(ShoppingCartDTO shoppingCartDTO) {
        Result<Integer> result = new Result<>();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        GoodsDTO goodsDTO = new GoodsDTO();
        shoppingCartDTO.setUserId(userDTO.getId());
        BehaviorDTO behaviorDTO = new BehaviorDTO();
        //添加购物车行为记录
        behaviorDTO.setLabelId(goodsMapper.selectLabelIdById(shoppingCartDTO.getGoodsId()));
        behaviorDTO.setBehavior(StaticVariable.ADD_CART);
        behaviorService.updateBehaviorById(behaviorDTO);
        //商品热度增加
        goodsDTO.setHot(StaticVariable.ADD_CART);
        goodsDTO.setId(shoppingCartDTO.getGoodsId());
        goodsMapper.updateHotById(goodsDTO);
        Integer id = shoppingCartMapper.selectIdByGoodsIdAndUserId(shoppingCartDTO.getGoodsId(), userDTO.getId());
        //如果没有这个商品在购物车里则插入，否则添加数量
        if (id != null){
            logger.info("cartId!=null");
            result.setData(shoppingCartMapper.updateNumById(id, shoppingCartDTO.getNum()));
        } else {
            result.setData(shoppingCartMapper.insertGoodsIntoCart(shoppingCartDTO));
        }
        return result;
    }

    /**
     * @return list
     * @description 获取所有商品的信息
     * @author 张成
     * @date 2019/10/4 21:59
     */
    @Override
    public List<ShoppingCartVO> selectCartByUserId() {
        UserDTO user = (UserDTO) session.getAttribute("user");
        List<ShoppingCartDTO> shoppingCartDTOList = shoppingCartMapper.selectCartByUserId(user.getId());
        JSONArray shoppingCartJSON = JSONArray.parseArray(JSON.toJSONString(shoppingCartDTOList));
        List<ShoppingCartVO> shoppingCartVOList  = JSONObject.parseArray(shoppingCartJSON.toJSONString(), ShoppingCartVO.class);
        return shoppingCartVOList;
    }

    /**
     * @param cartGoodsDTOList
     * @return result
     * @description 将选中的购物车数据暂存session里
     * @author 张成
     * @date 2019/10/9 20:44
     */
    @Override
    public Result<Integer> saveCartGoodsList(List<CartGoodsDTO> cartGoodsDTOList) {
        //保存购物车的id列表
        List<Integer> cartIdList = new ArrayList<>();
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for(CartGoodsDTO cartGoodsDTO: cartGoodsDTOList){
            //封装购物车id
            cartIdList.add(cartGoodsDTO.getId());
            //封装goodsDTOList
            GoodsDTO goodsDTO = goodsMapper.selectGoodsById(cartGoodsDTO.getGoodsId());
            goodsDTO.setNum(cartGoodsDTO.getNum());
            //计算价格
            goodsDTO.setTotal(goodsDTO.getPrice() * goodsDTO.getNum());
            goodsDTOList.add(goodsDTO);
        }
        session.setAttribute("cartIdList", cartIdList);
        session.setAttribute("goodsList", goodsDTOList);
        logger.info(goodsDTOList.toString());
        //查询到的最新的商品信息
        Result<Integer> result = new Result<>();
        result.setData(OK);
        return result;
    }

    /**
     * @param cartId 购物车id
     * @return result 删除成功result.data 为1 否则为0
     * @description 删除购物车的商品
     * @author 张成
     * @date 2019/10/10 3:13
     */
    @Override
    public Result<Integer> updateDeletedById(Integer cartId) {
        Result<Integer> result = new Result<>();
        Integer data = shoppingCartMapper.updateDeletedById(cartId);
        result.setData(data);
        return result;
    }
}
