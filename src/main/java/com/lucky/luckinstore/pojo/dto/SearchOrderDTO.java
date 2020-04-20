package com.lucky.luckinstore.pojo.dto;

/**
 * @author: 张成
 * @date: Create in 2019/9/24
 * @description:
 */
public class SearchOrderDTO {

    private String tele;

    private Integer status;

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SearchOrderDTO{" +
                "tele='" + tele + '\'' +
                ", status=" + status +
                '}';
    }
}
