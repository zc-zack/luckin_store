package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.pojo.ao.OrderAO;
import com.lucky.luckinstore.pojo.ao.PayAO;
import com.lucky.luckinstore.pojo.dto.OrderDTO;
import com.lucky.luckinstore.pojo.dto.PayDTO;
import com.lucky.luckinstore.service.OrderService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description: 订单页面TOC
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    //日志
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * @description 获取所有订单
     * @author 张成
     * @date 2019/9/23 16:32
     * @return json
     */
    @GetMapping("/order/getAllOrder")
    public Result<List> getAllOrder(@RequestParam String tele, Integer page, Integer limit){
        Result<List> result = orderService.selectOrderByTeleList(tele, StaticVariable.STATUS_NULL, page, limit);
        return result;
    }

    /**
     * @description 修改订单信息
     * @author 张成
     * @date 2019/9/23 16:42
     * @param orderAO
     * @return int
     */
    @PostMapping("/order/alterOrder")
    public Result<Integer> alterOrder(@RequestBody OrderAO orderAO){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderAO, orderDTO);
        logger.info("orderDTO:" + orderDTO.toString());
        Result<Integer> result = orderService.updateOrderByOrderId(orderDTO);
        return result;
    }

    /**
     * @description 根据不同的状态，返回不同的订单
     * @author 张成
     * @date 2019/9/24 23:01
     * @param tele 电话号码
     * @param status 订单状态
     * @return result
     */
    @GetMapping("/order/getOrderByStatus")
    public Result<List> getOrderByStatus(@RequestParam(defaultValue = "") String tele, @RequestParam Integer status, Integer page, Integer limit){
        Result<List> result = orderService.selectOrderByTeleList(tele, status, page, limit);
        logger.info(String.valueOf(status));
        return result;
    }

    /**
     * @description 新增订单的接口
     * @author 张成
     * @date 2019/9/29 10:51
     * @param orderAO
     * @return int
     */
    @PostMapping( "/order/addOrder")
    public Result<Integer> addOrder(@RequestBody OrderAO orderAO){
        OrderDTO orderDTO = new OrderDTO();
        logger.info(orderAO.toString());
        BeanUtils.copyProperties(orderAO, orderDTO);
        Result<Integer> result = orderService.insertOrder(orderDTO);
        return result;
    }

    @PostMapping("/order/payOrder")
    public Result<Integer> payOrder(@RequestBody PayAO payAO){
        logger.info("payAO:" + payAO.toString());
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(payAO, payDTO);
        return orderService.updateStatusByPay(payDTO);
    }

    @PostMapping("/order/cancelOrder")
    public Result<Integer> cancelOrder(@RequestBody OrderAO orderAO){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderAO, orderDTO);
        return orderService.cancelOrder(orderDTO);
    }
}
