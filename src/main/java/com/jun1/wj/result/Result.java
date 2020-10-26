package com.jun1.wj.result;

import lombok.Data;

@Data
public class Result {
    //响应码
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    /*public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }*/

}
