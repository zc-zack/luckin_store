package com.lucky.luckinstore.pojo.vo;

import java.util.Date;

/**
 * @author: 张成
 * @date: Create in 2019/10/12
 * @description: 评论的VO
 */
public class CommentVO {
    /**
     * 评论表的id
     */
    private Integer id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论者
     */
    private String username;
    /**
     * 评论的商品id
     */
    private Integer goodsId;
    /**
     * 评论时间
     */
    private Date commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", goodsId=" + goodsId +
                ", commentTime=" + commentTime +
                '}';
    }
}
