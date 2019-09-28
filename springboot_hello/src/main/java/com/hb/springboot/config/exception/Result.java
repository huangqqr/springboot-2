package com.hb.springboot.config.exception;

public class Result {

    private boolean isok;
    private int code;   
    private String message;
    private Object data;

    private Result() {

    }

    //请求出现异常时的响应数据封装
    public static Result error(CustomException e) {

        Result resultBean = new Result();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：1375610xxxx进行处理!");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108xxx进行处理!");
        }
        return resultBean;
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