package com.lucky.luckinstore.pojo.ao;

/**
 * @author: 张成
 * @date: Create in 2019/10/13
 * @description:
 */
public class UserPortraitAO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户头像url
     */
    private String portrait;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public String toString() {
        return "UserPortraitAO{" +
                "id=" + id +
                ", portrait='" + portrait + '\'' +
                '}';
    }
}
