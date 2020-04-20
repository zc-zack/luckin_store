package com.lucky.luckinstore.pojo.ao;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description: 行为实体类的AO
 */
public class BehaviorAO {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 行为
     */
    private Integer behavior;
    /**
     * 标签id
     */
    private Integer labelId;
    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


}
