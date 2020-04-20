package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.pojo.ao.GoodsAO;
import com.lucky.luckinstore.pojo.ao.LabelAO;
import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import com.lucky.luckinstore.pojo.dto.LabelDTO;
import com.lucky.luckinstore.pojo.vo.GoodsVO;
import com.lucky.luckinstore.pojo.vo.LabelVO;
import com.lucky.luckinstore.service.GoodsService;
import com.lucky.luckinstore.service.LabelService;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 商品操作的controller
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private LabelService labelService;

    private final static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    /**
     * @return JSON
     * @description 获取所有商品
     * @author 张成
     * @date 2019/9/19 22:27
     */
    @GetMapping("/goods/getAllGoods")
    public Result<List> getAllGoods(@RequestParam(defaultValue = "") String goodsName, Integer page, Integer limit) {
        logger.info("goodsName:" + goodsName);
        logger.info("page: " + page + " limit:" + limit);
        Result<List> result = goodsService.selectGoodsByNameList(goodsName, page, limit);
        return result;
    }


    /**
     * @param goodsVO
     * @return int
     * @description 添加商品的C层
     * @author 张成
     * @date 2019/9/20 15:03
     */
    @PostMapping("/goods/addNewGoods")
    public Result<Integer> addGoods(@RequestBody GoodsVO goodsVO) {
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goodsVO, goodsDTO);
        logger.info("goodsDTO:" + goodsDTO.toString());
        return goodsService.insertGoods(goodsDTO);
    }

    /**
     * @return json
     * @description 返回未被删除的标签
     * @author 张成
     * @date 2019/9/21 14:12
     */
    @GetMapping("/admin/getUndeletedLabel")
    public Result<List> getUndeletedLabel() {
        List<LabelVO> labelVOList = goodsService.selectAllLabelListByDeleted(StaticVariable.UNDELETE);
        Result<List> result = new Result<>();
        result.setData(labelVOList);
        result.setCount(labelVOList.size());
        logger.info("labelList: " + labelVOList.toString());
        return result;
    }

    @GetMapping("/label/getLabel")
    public Result<List> getLabel(){
        Result<List> result = new Result<>();
        result.setData(labelService.selectAllLabelByDeleted(StaticVariable.UNDELETE));
        return result;
    }


    /**
     * @description 添加新的标签
     * @author 张成
     * @date 2019/9/23 9:13
     * @param labelAO
     * @return result 插入新标签的接口，如果插入成功result.data为1，否则为0
     */
    @PostMapping("/addNewLabel")
    public Result<Integer> addNewLabel(@RequestBody LabelAO labelAO) {
        LabelDTO labelDTO = new LabelDTO();
        BeanUtils.copyProperties(labelAO, labelDTO);
        Result<Integer> result = goodsService.insertLabel(labelDTO);
        return result;
    }

    @PostMapping("/updateLabel")
    public Result<Integer> updateLabel(@RequestBody LabelVO labelVO){
        Result<Integer> result = new Result<>();
        LabelDTO labelDTO = new LabelDTO();
        BeanUtils.copyProperties(labelVO, labelDTO);
        result.setData(labelService.updateLabelNameById(labelDTO));
        return result;
    }

    /**
     * @description 修改商品信息TOC
     * @author 张成
     * @date 2019/9/23 21:55
     * @param goodsAO
     * @return 如果修改成功则result.data为1否则为0
     */
    @PostMapping("/goods/alterGoods")
    public Result<Integer> alterGoods(@RequestBody GoodsAO goodsAO){
        GoodsDTO goodsDTO = new GoodsDTO();
        logger.info("goodsAO:" + goodsAO.toString());
        BeanUtils.copyProperties(goodsAO, goodsDTO);
        logger.info(goodsDTO.toString());
        Result<Integer> result = goodsService.updateGoodsById(goodsDTO);
        return result;
    }

    @PostMapping("/goods/updateStatus")
    public Result<Integer> updateStatus(@RequestBody GoodsAO goodsAO){
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goodsAO, goodsDTO);
        logger.info("goodsDTO: " + goodsDTO.toString());
        Result<Integer> result = goodsService.updateGoodsStatusById(goodsDTO);
        return result;
    }

}
