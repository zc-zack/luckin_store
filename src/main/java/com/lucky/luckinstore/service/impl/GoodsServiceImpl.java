package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.mapper.BehaviorMapper;
import com.lucky.luckinstore.mapper.GoodsMapper;
import com.lucky.luckinstore.mapper.LabelMapper;
import com.lucky.luckinstore.pojo.ao.GoodsAO;
import com.lucky.luckinstore.pojo.ao.LabelAO;
import com.lucky.luckinstore.pojo.dto.*;
import com.lucky.luckinstore.pojo.entity.Label;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.GoodsVO;
import com.lucky.luckinstore.pojo.vo.LabelVO;
import com.lucky.luckinstore.service.BehaviorService;
import com.lucky.luckinstore.service.GoodsService;
import com.lucky.luckinstore.util.LayuiUtil;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: GoodsService的实现层
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private BehaviorService behaviorService;

    @Autowired
    private BehaviorMapper behaviorMapper;

    private  LayuiUtil layuiUtil;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Override
    public JSONObject selectAllGoodsJSON(Integer status) {
        layuiUtil = new LayuiUtil();
        List<GoodsAO> goodsAOList = selectAllGoodsList(status);
        JSONObject goodsJSON = layuiUtil.getLayuiJSON(goodsAOList);
        return goodsJSON;
    }

    @Override
    public Result<Integer> insertGoods(GoodsDTO goodsDTO) {
        Result<Integer> result = new Result<>();
        result.setData(goodsMapper.insertGoods(goodsDTO));
        return result;
    }

    /**
     * @param deleted
     * @return json
     * @description 返回所有的标签
     * @author 张成
     * @date 2019/9/21 14:06
     */
    @Override
    public JSONObject selectAllLabelJSON(Boolean deleted) {
        layuiUtil = new LayuiUtil();
        List<LabelVO> labelAOList = selectAllLabelListByDeleted(deleted);
        JSONObject labelJSON = layuiUtil.getLayuiJSON(labelAOList);
        return labelJSON;
    }

    /**
     * @param labelDTO
     * @return int
     * @description 插入新的标签
     * @author 张成
     * @date 2019/9/21 14:54
     */
    @Override
    public Result<Integer> insertLabel(LabelDTO labelDTO) {
        UserDTO user = (UserDTO) session.getAttribute("user");
        labelDTO.setCreator(user.getId());
        labelDTO.setModifier(user.getId());
        Result<Integer> result = new Result<>();
        result.setData(labelMapper.insertLabel(labelDTO));
        return result;
    }

    /**
     * @param deleted
     * @return list
     * @description 获取所有标签的list
     * @author 张成
     * @date 2019/9/23 9:18
     */
    @Override
    public List<LabelVO> selectAllLabelListByDeleted(Boolean deleted) {
        List<LabelDTO> labelDTOList = labelMapper.selectAllLabelByDeleted(deleted);
        JSONArray labelJSON = JSONArray.parseArray(JSON.toJSONString(labelDTOList));
        List<LabelVO> labelVOList = JSONObject.parseArray(labelJSON.toJSONString(), LabelVO.class);
        return labelVOList;
    }

    /**
     * @param status
     * @return list
     * @description 获取所有商品的List
     * @author 张成
     * @date 2019/9/23 18:02
     */
    @Override
    public List<GoodsAO> selectAllGoodsList(Integer status) {
        List<GoodsAO> goodsAOList = goodsMapper.selectAllGoods(status);
        for(GoodsAO goodsAO: goodsAOList){
            //根据标签id获得标签名
            goodsAO.setLabelName(labelMapper.selectLabelById(goodsAO.getLabelId()));
            if( goodsAO.getStatus() == 1 ){
                goodsAO.setStatusName("出售中");
            } else if( goodsAO.getStatus() == 0 ){
                goodsAO.setStatusName("已下架");
            } else if( goodsAO.getStatus() == -1 ){
                goodsAO.setStatusName("已移除");
            }
        }
        return goodsAOList;
    }

    /**
     * @param goodsDTO
     * @return int
     * @description 修改商品信息的service
     * @author 张成
     * @date 2019/9/23 21:50
     */
    @Override
    public Result<Integer> updateGoodsById(GoodsDTO goodsDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        Result<Integer> result = new Result<>();
        goodsDTO.setModifier(userDTO.getId());
        result.setData(goodsMapper.updateGoodsById(goodsDTO));
        return result;
    }

    /**
     * @param goodsDTO
     * @return int
     * @description 修改商品状态
     * @author 张成
     * @date 2019/9/24 10:25
     */
    @Override
    public Result<Integer> updateGoodsStatusById(GoodsDTO goodsDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        goodsDTO.setModifier(userDTO.getId());
        Result<Integer> result = new Result<>();
        result.setData(goodsMapper.updateGoodsStatusById(goodsDTO));
        return result;
    }

    /**
     * @param goodsName
     * @return
     * @description
     * @author 张成
     * @date 2019/9/24 18:10
     */
    @Override
    public Result<List> selectGoodsByNameList(String goodsName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsDTO> goodsDTOList = goodsMapper.selectGoodsByName(goodsName);
        PageInfo<GoodsDTO> pageInfo = new PageInfo<GoodsDTO>(goodsDTOList);
        logger.info(goodsDTOList.toString());
        for(GoodsDTO goodsDTO: goodsDTOList){
            if( goodsDTO.getStatus() == 1 ){
                goodsDTO.setStatusName("出售中");
            } else if( goodsDTO.getStatus() == 0 ){
                goodsDTO.setStatusName("已下架");
            } else if( goodsDTO.getStatus() == -1 ){
                goodsDTO.setStatusName("已移除");
            }
        }
        Result<List> result = new Result<>();
        result.setData(goodsDTOList);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    /**
     * @param id
     * @return goodAO
     * @description 通过商品的id获取商品的详细信息
     * @author 张成
     * @date 2019/9/26 16:04
     */
    @Override
    public GoodsVO selectGoodsById(Integer id) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        BehaviorDTO behaviorDTO = new BehaviorDTO();
        GoodsDTO goodsDTO = goodsMapper.selectGoodsById(id);
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goodsDTO, goodsVO);
        //点击商品时更新商品热度
        goodsDTO.setHot(StaticVariable.CLICK);
        goodsMapper.updateHotById(goodsDTO);
        //如果用户登录了则进行行为记录,记录点击操作
        if (userDTO != null){
            //获取商品标签id
            behaviorDTO.setLabelId(goodsMapper.selectLabelIdById(id));
            behaviorDTO.setUserId(userDTO.getId());
            behaviorDTO.setBehavior(StaticVariable.CLICK);
            behaviorService.updateBehaviorById(behaviorDTO);
        }

        return goodsVO;
    }

    /**
     * @param goodsName
     * @param status
     * @return list
     * @description 通过商品名字获取商品信息
     * @author 张成
     * @date 2019/10/7 16:11
     */
    @Override
    public List<GoodsVO> selectGoodsByNameAndStatusList(String goodsName, Integer labelId, Integer status) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<GoodsVO> goodsVOList = null;
        logger.info("labelId: " + labelId);
        //当登录时，并且点击首页
        if (userDTO != null && (labelId == null || labelId.equals(""))){
            goodsVOList = selectGoodsByBehavior(goodsName);
        } else {
            SearchGoodsDTO searchGoodsDTO = new SearchGoodsDTO();
            searchGoodsDTO.setGoodsName(goodsName);
            searchGoodsDTO.setLabelId(labelId);
            searchGoodsDTO.setStatus(status);
            List<GoodsDTO> goodsDTOList = goodsMapper.selectGoodsBySearchGoodsDTO(searchGoodsDTO);
            JSONArray goodsJSON = JSONArray.parseArray(JSON.toJSONString(goodsDTOList));
            goodsVOList = JSONObject.parseArray(goodsJSON.toJSONString(), GoodsVO.class);
        }


        return goodsVOList;
    }

    /**
     * @param goodsDTOList 商品的List
     * @return result
     * @description 对购物车里的订单进行验证
     * @author 张成
     * @date 2019/10/9 16:16
     */
    @Override
    public Result<Integer> selectGoodsListById(List<GoodsDTO> goodsDTOList) {
        //查询到的最新的商品信息
        List<GoodsDTO> goodsResultList = goodsMapper.selectGoodsListById(goodsDTOList);
        Result<Integer> result = new Result<>();
        if(goodsResultList == null){
            result.setData(StaticVariable.ERROR);
            return result;
        }
        result.setData(StaticVariable.OK);
        //将用户购买的商品数量赋值
        for(int i = 0; i < goodsDTOList.size();i++){
           GoodsDTO goodsTemp = goodsDTOList.get(i);
           GoodsDTO goodsResult = goodsResultList.get(i);
           goodsResult.setNum(goodsTemp.getNum());
        }
        //处理好的数据暂存session里
        session.setAttribute("goodsList", goodsResultList);
        return result;
    }

    /**
     * @return list 商品的list
     * @description 从session里获取订单的商品列表
     * @author 张成
     * @date 2019/10/9 16:35
     */
    @Override
    public List<GoodsVO> getOrderGoodsList() {
        //获取商品列表
        logger.info("--------------");
        List<GoodsDTO> goodsDTOList = (List<GoodsDTO>) session.getAttribute("goodsList");
        //转化为VO的list
        JSONArray goodsJSON = JSONArray.parseArray(JSONArray.toJSONString(goodsDTOList));
        List<GoodsVO> goodsVOList = JSONObject.parseArray(goodsJSON.toJSONString(), GoodsVO.class);
        logger.info("goodsVOList:" + goodsVOList.toString());
        return goodsVOList;
    }

    /**
     * @param goodsDTOList
     * @return Integer
     * @description 购买商品后商品数量的更新
     * @author 张成
     * @date 2019/10/9 18:07
     */
    @Override
    public Integer updateGoodsAmount(List<GoodsDTO> goodsDTOList) {
        for(GoodsDTO goodsDTO: goodsDTOList){
            goodsMapper.updateGoodsAmount(goodsDTO);
        }
        return StaticVariable.OK;
    }

    /**
     * @param goodsName
     * @return list
     * @Description 通过根据热度返回商品信息
     * @author 张成
     * @date 2019/10/11 21:08
     */
    @Override
    public List<GoodsVO> selectGoodsByBehavior(String goodsName) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        SearchGoodsDTO searchGoodsDTO = new SearchGoodsDTO();
        searchGoodsDTO.setGoodsName(goodsName);
        searchGoodsDTO.setStatus(StaticVariable.GOODS_STATUS_SELL);
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        //商品id的list 用于排除重复
        List<Integer> goodsIdList = new ArrayList<>();
        //获取行为标注下的标签id 倒叙
        List<Integer> labelIdList = behaviorMapper.selectLabelIdByUserId(userDTO.getId());
        if (labelIdList != null){
            for(Integer labelId: labelIdList){
                searchGoodsDTO.setLabelId(labelId);
                List<GoodsDTO> tempList = goodsMapper.selectGoodsBySearchGoodsDTO(searchGoodsDTO);
                goodsDTOList.addAll(tempList);
                //将商品的id保存到list 用于数据防止数据重复
                for(GoodsDTO goodsDTO: tempList){
                    goodsIdList.add(goodsDTO.getId());
                }
            }
            logger.info("goodsIdList: " + goodsIdList.toString());
            //将剩余的商品查出
            List<GoodsDTO> tempList = goodsMapper.selectResidueGoodsById(goodsIdList, StaticVariable.GOODS_STATUS_SELL);
            goodsDTOList.addAll(tempList);
        }
        JSONArray goodsJSON = JSONArray.parseArray(JSON.toJSONString(goodsDTOList));
        List<GoodsVO> goodsVOList = JSONObject.parseArray(goodsJSON.toJSONString(), GoodsVO.class);
        return goodsVOList;
    }

    /**
     * @param goodsDTOList
     * @return int
     * @Description 取消订单回滚操作
     * @Author 张成
     * @Date 2019/10/14 1:21
     */
    @Override
    public int updateAmountByCancelOrder(List<GoodsDTO> goodsDTOList) {
        return goodsMapper.updateAmountByCancelOrder(goodsDTOList);
    }
}
