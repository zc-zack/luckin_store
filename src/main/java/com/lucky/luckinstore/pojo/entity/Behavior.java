package com.lucky.luckinstore.pojo.entity;

import java.util.Date;

public class Behavior {
    //行为id
    private Integer id;
    //标签id
    private Integer labelId;
    //用户id
    private Integer userId;
    //用户行为，1点击商品，2为收藏商品，3为加入购物车，4为购买商品
    private Integer behavior;
    //创建者
    private Integer creator;
    //创建时间
    private Date createTime;
    //修改者
    private Integer modifier;
    //修改时间
    private Date modifyTime;

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

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "Behavior{" +
                "id=" + id +
                ", labelId=" + labelId +
                ", userId=" + userId +
                ", behavior=" + behavior +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", modifier=" + modifier +
                ", modifyTime=" + modifyTime +
                '}';
    }
}