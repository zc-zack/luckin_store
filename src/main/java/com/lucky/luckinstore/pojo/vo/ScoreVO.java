package com.lucky.luckinstore.pojo.vo;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description:
 */
public class ScoreVO {
    /**
     * 积分id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 当前积分
     */
    private Integer presentScore;
    /**
     * 上一次积分
     */
    private Integer lastScore;
    /**
     * 用户名
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPresentScore() {
        return presentScore;
    }

    public void setPresentScore(Integer presentScore) {
        this.presentScore = presentScore;
    }

    public Integer getLastScore() {
        return lastScore;
    }

    public void setLastScore(Integer lastScore) {
        this.lastScore = lastScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", presentScore=" + presentScore +
                ", lastScore=" + lastScore +
                ", username='" + username + '\'' +
                '}';
    }
}
