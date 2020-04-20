package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.ao.LabelAO;
import com.lucky.luckinstore.pojo.dto.LabelDTO;
import com.lucky.luckinstore.pojo.entity.Label;
import com.lucky.luckinstore.pojo.vo.LabelVO;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/10/8
 * @description:
 */
public interface LabelService {

    /**
     * @description 获取所有标签
     * @author 张成
     * @date 2019/10/8 14:53
     * @return list
     */
    List<LabelVO> selectNameAndId();

    /**
     * @description 通过标签id修改标签
     * @author 张成
     * @date 2019/10/8 14:53
     * @param labelDTO
     * @return int
     */
    int updateLabelNameById(LabelDTO labelDTO);

    /**
     * @description 通过deleted获取标签
     * @author 张成
     * @date 2019/10/8 15:19
     * @param deleted
     * @return list
     */
    List<LabelAO> selectAllLabelByDeleted(Boolean deleted);
}
