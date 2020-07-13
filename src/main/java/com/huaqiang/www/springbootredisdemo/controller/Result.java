package com.huaqiang.www.springbootredisdemo.controller;

public class Result<T> {
    private int code;
    private String msg;
    private  T data;



    public static Object error(int code, String msg) {
       return new Result<>(code,msg);
    }

    public static Result ok(String msg) {
        return new  Result(msg);
    }

    public static Object error(String msg) {
        return new  Result(msg);
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String msg) {
        this.msg = msg;
    }
}
