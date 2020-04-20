package com.lucky.luckinstore.pojo.ao;

import com.lucky.luckinstore.pojo.dto.GoodsDTO;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 商品的AO
 */
public class GoodsAO  {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 标签名
     */
    private String labelName;
    /**
     * 状态名
     */
    private String statusName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 标签id
     */
    private Integer labelId;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品数量
     */
    private Integer amount;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GoodsAO{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                ", statusName='" + statusName + '\'' +
                ", status=" + status +
                ", goodsName='" + goodsName + '\'' +
                ", num=" + num +
                ", labelId=" + labelId +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
