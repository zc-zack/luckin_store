package com.lucky.luckinstore.pojo.ao;

/**
 * @author: 张成
 * @date: Create in 2019/9/29
 * @description: 付款的AO实体类
 */
public class PayAO {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 用户id
     */
    private Integer userId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PayAO{" +
                "orderId=" + orderId +
                ", status=" + status +
                '}';
    }
}
