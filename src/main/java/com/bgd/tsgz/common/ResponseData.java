package com.bgd.tsgz.common;

import lombok.Data;

@Data
public class ResponseData<T> {
    private Integer code;
    private T result;
    private String message;

    public ResponseData() {
        this.code = 200;
        this.message = "查询成功！";
        this.result =  null;
    }

    public static ResponseData OK(Object data) {
        ResponseData rd = new ResponseData();
        rd.setResult(data);
        return rd;
    }

    public static ResponseData FAIL(String msg) {
        ResponseData rd = new ResponseData();
        rd.setMessage(msg);
        return rd;
    }

    public static ResponseData NOAUTH() {
        ResponseData rd = new ResponseData();
        rd.setCode(401);
        return rd;
    }

    public static ResponseData ERROR(Integer code,String msg) {
        ResponseData rd = new ResponseData();
        rd.setCode(code);
        rd.setMessage(msg);
        return rd;
    }
}
