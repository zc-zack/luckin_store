package com.lucky.luckinstore.mapper;


import com.lucky.luckinstore.pojo.ao.GoodsAO;
import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import com.lucky.luckinstore.pojo.dto.SearchGoodsDTO;
import com.lucky.luckinstore.pojo.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    /**
     * @return list
     * @description 从数据库获取所有商品
     * @author 张成
     * @date 2019/9/19 22:18
     */
    List<GoodsAO> selectAllGoods(Integer status);

    /**
     * @param goodsDTO
     * @return int
     * @description 插入新的商品
     * @author 张成
     * @date 2019/9/20 13:44
     */
    int insertGoods(GoodsDTO goodsDTO);

    /**
     * @description 修改商品信息
     * @author 张成
     * @date 2019/9/23 21:49
     * @param goodsDTO
     * @return int
     */
    int updateGoodsById(GoodsDTO goodsDTO);

    /**
     * @description 修改商品状态
     * @author 张成
     * @date 2019/9/24 10:23
     * @param goodsDTO
     * @return int
     */
    int updateGoodsStatusById(GoodsDTO goodsDTO);

    /**
     * @description 根据商品名模糊查询
     * @author 张成
     * @date 2019/9/24 18:08
     * @param goodsName
     * @return list
     */
    List<GoodsDTO> selectGoodsByName(String goodsName);

    /**
     * @description 根据商品id获取详细的商品信息
     * @author 张成
     * @date 2019/9/27 14:08
     * @param id
     * @return GoodsDTO
     */
    GoodsDTO selectGoodsById(Integer id);

    /**
     * @description 根据商品名字搜索所有商品
     * @author 张成
     * @date 2019/10/7 16:07
     * @param searchGoodsDTO
     * @return list
     */
    List<GoodsDTO> selectGoodsBySearchGoodsDTO(SearchGoodsDTO searchGoodsDTO);

    /**
     * @description 根据goodsList中的id批量查询商品
     * @author 张成
     * @date 2019/10/9 15:59
     * @param goodsDTOList 商品的list
     * @return list
     */
    List<GoodsDTO> selectGoodsListById(List<GoodsDTO> goodsDTOList);

    /**
     * @description 商品购买后更新商品的数量
     * @author 张成
     * @date 2019/10/9 18:06
     * @param goodsDTO 商品
     * @return int
     */
    int updateGoodsAmount(GoodsDTO goodsDTO);

    /**
     * @description 更新商品热度
     * @author 张成
     * @date 2019/10/11 16:59
     * @param goodsDTO
     * @return int
     */
    int updateHotById(GoodsDTO goodsDTO);

    /**
     * @description 根据商品id获取商品id
     * @author 张成
     * @date 2019/10/11 17:12
     * @param id
     * @return labelId
     */
    int selectLabelIdById(Integer id);

    /**
     * @description 把数据库剩余的商品查出
     * @author 张成
     * @date 2019/10/11 23:24
     * @param goodsIdList
     * @param status
     * @return list 商品的list
     */
    List<GoodsDTO> selectResidueGoodsById(@Param("list")List<Integer> goodsIdList, @Param("status") Integer status);

    /**
     * @Description 取消订单的数量回滚
     * @Author 张成
     * @Date 2019/10/14 1:19
     * @param goodsDTOList
     * @return int
     */
    int updateAmountByCancelOrder(List<GoodsDTO> goodsDTOList);

    /**
     * @Description 根据商品id批量查询
     * @Author 张成
     * @Date 2019/10/14 1:34
     * @param idList
     * @return list
     */
    List<GoodsDTO> selectGoodsListByGoodsId(List<Integer> idList);
}