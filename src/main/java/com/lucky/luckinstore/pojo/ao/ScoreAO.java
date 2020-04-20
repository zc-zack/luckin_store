package com.lucky.luckinstore.pojo.ao;

import com.lucky.luckinstore.pojo.entity.Score;

/**
 * @author: 张成
 * @date: Create in 2019/9/24
 * @description:
 */
public class ScoreAO extends Score {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
