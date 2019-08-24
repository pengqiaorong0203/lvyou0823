package com.newer.lvyou.domain;

import java.io.Serializable;
//优秀团队类
public class tuandui implements Serializable {
    private static final long serialVersionUID = -8669337576492703239L;
    private int id;       //团队id
    private String tname; //团队名
    private String info;  //团队描述
    private String toux;  //头像

    public tuandui() {
    }

    public tuandui(int id, String tname, String info, String toux) {
        this.id = id;
        this.tname = tname;
        this.info = info;
        this.toux = toux;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getToux() {
        return toux;
    }

    public void setToux(String toux) {
        this.toux = toux;
    }

    @Override
    public String toString() {
        return "tuandui{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", info='" + info + '\'' +
                ", toux='" + toux + '\'' +
                '}';
    }
}
