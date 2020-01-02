package com.hb.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Result {

    @ApiModelProperty("是否成功")
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    private Result() {

    }


    public static Result success() {
        Result result = new Result();
        result.setIsok(true);
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setIsok(true);
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}