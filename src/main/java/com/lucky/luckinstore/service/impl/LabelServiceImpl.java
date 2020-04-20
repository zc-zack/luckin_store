package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.mapper.LabelMapper;
import com.lucky.luckinstore.pojo.ao.LabelAO;
import com.lucky.luckinstore.pojo.dto.LabelDTO;
import com.lucky.luckinstore.pojo.entity.Label;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.LabelVO;
import com.lucky.luckinstore.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/10/8
 * @description: 标签操作的service层
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private HttpSession session;

    @Override
    public List<LabelVO> selectNameAndId() {
        List<LabelDTO> labelDTOList = labelMapper.selectNameAndId();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(labelDTOList));
        List<LabelVO> labelVOList = JSONObject.parseArray(jsonArray.toJSONString(), LabelVO.class);
        return labelVOList;
    }

    /**
     * @param labelDTO
     * @return int
     * @description 通过标签id修改标签
     * @author 张成
     * @date 2019/10/8 14:53
     */
    @Override
    public int updateLabelNameById(LabelDTO labelDTO) {
        User user = (User) session.getAttribute("user");
        labelDTO.setModifier(user.getId());
        return labelMapper.updateLabelNameById(labelDTO);
    }

    /**
     * @param deleted
     * @return list
     * @description 通过deleted获取标签
     * @author 张成
     * @date 2019/10/8 15:19
     */
    @Override
    public List<LabelAO> selectAllLabelByDeleted(Boolean deleted) {
        List<LabelDTO> labelDTOList = labelMapper.selectAllLabelByDeleted(deleted);
        JSONArray labelJSON = JSONArray.parseArray(JSON.toJSONString(labelDTOList));
        List<LabelAO> labelAOList = JSONObject.parseArray(labelJSON.toJSONString(), LabelAO.class);
        return labelAOList;
    }
}
