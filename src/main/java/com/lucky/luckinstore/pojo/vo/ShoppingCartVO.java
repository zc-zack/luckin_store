package com.lucky.luckinstore.pojo.vo;

/**
 * @author: 张成
 * @date: Create in 2019/10/4
 * @description:
 */
public class ShoppingCartVO {
    //购物车的id
    private Integer id;
    //商品id
    private Integer goodsId;
    //商品名
    private String goodsName;
    //加入购物车时的数量
    private Integer num;
    //商品的价格
    private Double price;
    //图片的路径
    private String image;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShoppingCartVO{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
