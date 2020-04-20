package com.lucky.luckinstore.pojo.dto;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description:
 */
public class BehaviorDTO {
    /**
     * 行为id
     */
    private Integer id;
    /**
     * 标签id
     */
    private Integer labelId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户行为，1点击商品，2为收藏商品，3为加入购物车，4为购买商品
     */
    private Integer behavior;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

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

    @Override
    public String toString() {
        return "BehaviorDTO{" +
                "id=" + id +
                ", labelId=" + labelId +
                ", userId=" + userId +
                ", behavior=" + behavior +
                '}';
    }
}
