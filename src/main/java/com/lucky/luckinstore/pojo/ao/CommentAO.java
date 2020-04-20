package com.lucky.luckinstore.pojo.ao;

/**
 * @author: 张成
 * @date: Create in 2019/10/12
 * @description: 评价的AO
 */
public class CommentAO {
    /**
     * 订单号
     */
    private Integer orderId;
    /**
     * 评价内容
     */
    private String content;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentAO{" +
                "orderId=" + orderId +
                ", content='" + content + '\'' +
                '}';
    }
}
