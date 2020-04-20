package com.lucky.luckinstore.pojo.vo;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
public class GoodsVO {
    //商品id
    private Integer id;
    //商品名称
    private String goodsName;
    //商品数量
    private Integer num;
    //商品价格
    private Double price;
    //商品描述
    private String description;
    //商品图片地址
    private String image;
    //商品数量
    private Integer amount;
    //标签名
    private String labelName;
    //商品状态
    private Integer status;
    //状态名
    private String statusName;
    //商品标签id
    private Integer labelId;
    //商品总价
    private Double total;
    /**
     * 商品热度
     */
    private Integer hot;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", amount=" + amount +
                ", labelName='" + labelName + '\'' +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", labelId=" + labelId +
                ", total=" + total +
                ", hot=" + hot +
                '}';
    }
}
