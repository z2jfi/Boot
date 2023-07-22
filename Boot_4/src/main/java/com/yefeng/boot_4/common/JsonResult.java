package com.yefeng.boot_4.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

}
