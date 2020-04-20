package com.lucky.luckinstore.util;

/**
 * @author: 张成
 * @date: Create in 2019/10/4
 * @description:
 */
public class Layui<T> {

    private String msg;

    private Integer code;

    private T t;

    public Layui(){

    }

    public Layui(T t){
        this.t = t;
    }
}
