package com.luoys.flag.service;

import lombok.Data;

@Data
public class Result {
    private int code;
    private boolean success;
    private String message;
    private Object data;

    public String success (Object data) {
        this.code=0;
        this.success=true;
        this.data=data;
        this.message="成功";
        return null;
    }
}
