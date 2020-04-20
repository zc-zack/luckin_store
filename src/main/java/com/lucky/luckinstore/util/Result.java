package com.lucky.luckinstore.util;

/**
 * @author: 张成
 * @date: Create in 2019/10/4
 * @description: 泛型，用户返回数据
 */
public class Result<T> {

    //返回的信息
    private String msg = "";

    //返回的状态码
    private Integer code = 0;

    private Integer count;

    //返回的一些数据
    private T data;

    public Result(){

    }

    public Result(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
