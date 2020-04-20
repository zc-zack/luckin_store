package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.CartGoodsAO;
import com.lucky.luckinstore.pojo.ao.GoodsAO;
import com.lucky.luckinstore.pojo.dto.CartGoodsDTO;
import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import com.lucky.luckinstore.pojo.dto.ShoppingCartDTO;
import com.lucky.luckinstore.pojo.vo.ShoppingCartVO;
import com.lucky.luckinstore.service.GoodsService;
import com.lucky.luckinstore.service.ShoppingCartService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description: 购物车操作
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    private final static Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @PostMapping("/add")
    public Result<Integer> add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        logger.info("int add cart");
        return shoppingCartService.insertGoodsIntoCart(shoppingCartDTO);
    }

    @GetMapping("/getTotal")
    public Result<Double> getTotal(){
        return null;
    }

    /**
     * @description 返回用户的购物车数据
     * @author 张成
     * @date 2019/10/9 11:08
     * @param
     * @return
     */
    @GetMapping("/getAllCart")
    public Result<List> getAllCart(){
        Result<List> result = new Result<>();
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartService.selectCartByUserId();
        result.setData(shoppingCartVOList);
        return result;
    }

    /**
     * @description 获取用户要下订单的商品的信息
     * @author 张成
     * @date 2019/10/9 15:43
     * @param cartGoodsAOList
     * @return result
     */
    @PostMapping("/addOrder")
    public Result<Integer> addOrder(@RequestBody List<CartGoodsAO> cartGoodsAOList){
        logger.info(cartGoodsAOList.toString());
        JSONArray cartGoodsJSON = JSONArray.parseArray(JSON.toJSONString(cartGoodsAOList));
        List<CartGoodsDTO> cartGoodsDTOList = JSONObject.parseArray(cartGoodsJSON.toJSONString(), CartGoodsDTO.class);
        return shoppingCartService.saveCartGoodsList(cartGoodsDTOList);
    }

    /**
     * @description 删除购物车
     * @author 张成
     * @date 2019/10/11 2:19
     * @param cartGoodsAO
     * @return result
     */
    @PostMapping("/deleteCart")
    public Result<Integer> deleteCart(@RequestBody CartGoodsAO cartGoodsAO){
        Result<Integer> result = shoppingCartService.updateDeletedById(cartGoodsAO.getId());
        return result;
    }
}
