package com.newer.lvyou.domain;

import java.io.Serializable;

public class ResponseData implements Serializable {
    private static final long serialVersionUID = -2572287403703140752L;

    private String code;
    private String msg;

    public ResponseData() {
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
