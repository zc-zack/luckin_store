package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.ao.LabelAO;
import com.lucky.luckinstore.pojo.dto.LabelDTO;
import com.lucky.luckinstore.pojo.entity.Label;

import java.util.List;

public interface LabelMapper {

    /**
     * @param deleted
     * @return list
     * @description 根据标签是否被删除查找标签
     * @author 张成
     * @date 2019/9/21 13:33
     */
    List<LabelDTO> selectAllLabelByDeleted(Boolean deleted);

    /**
     * @param label
     * @return int
     * @description 插入新的标签
     * @author 张成
     * @date 2019/9/21 14:52
     */
    int insertLabel(Label label);

    /**
     * @description 获取标签名字
     * @author 张成
     * @date 2019/9/23 18:00
     * @param labelId
     * @return String
     */
    String selectLabelById(Integer labelId);

    /**
     * @description 查询标签的id和标签名
     * @author 张成
     * @date 2019/10/8 9:53
     * @return list
     */
    List<LabelDTO> selectNameAndId();

    /**
     * @description 通过标签id修改标签
     * @author 张成
     * @date 2019/10/8 14:50
     * @param labelDTO
     * @return int
     */
    int updateLabelNameById(LabelDTO labelDTO);
}