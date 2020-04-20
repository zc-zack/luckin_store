package com.lucky.luckinstore.pojo.dto;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description:
 */
public class GoodsDTO {

    //标签名
    private String labelName;
    //商品购买时数量
    private Integer num;
    //总价
    private Double total;
    //商品id
    private Integer id;
    //商品名称
    private String goodsName;
    //商品价格
    private Double price;
    //商品图片
    private String image;
    //商品描述
    private String description;
    //商品数量
    private Integer amount;
    //标签id
    private Integer labelId;
    //商品状态
    private Integer status;
    //创建者
    private Integer creator;
    //修改者
    private Integer modifier;
    //状态对应的名字
    private String statusName;
    //商品热度
    private Integer hot;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "labelName='" + labelName + '\'' +
                ", num=" + num +
                ", total=" + total +
                ", id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", labelId=" + labelId +
                ", status=" + status +
                ", creator=" + creator +
                ", modifier=" + modifier +
                '}';
    }
}
