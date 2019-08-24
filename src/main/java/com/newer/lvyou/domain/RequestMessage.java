package com.newer.lvyou.domain;

import java.io.Serializable;

/*实体类*/
public class RequestMessage implements Serializable {
    private static final long serialVersionUID = 1171841263708458548L;

    private String id;
    private String url;       //请求url
    private String methodName;//请求方法
    private String args;      //请求参数
    private String method;    //请求方式：get、post、delete.....

    public RequestMessage() {
    }

    public RequestMessage(String id, String url, String methodName, String args, String method) {
        this.id = id;
        this.url = url;
        this.methodName = methodName;
        this.args = args;
        this.method = method;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", methodName='" + methodName + '\'' +
                ", args='" + args + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
