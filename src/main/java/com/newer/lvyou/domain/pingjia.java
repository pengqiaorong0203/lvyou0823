package com.newer.lvyou.domain;

import java.io.Serializable;
//评价类
public class pingjia implements Serializable {
    private static final long serialVersionUID = 8332528430629579456L;

    private int id;          //评价id
    private int guoid;       //国家id
    private String guoname;  //国家名称
    private String xiangqing;//评价内容
    private String tupian;   //图片
    private String username; //评价用户
    private int shenhe;
    public pingjia() {
    }

    public pingjia(int id, int guoid, String guoname, String xiangqing, String tupian, String username, int shenhe) {
        this.id = id;
        this.guoid = guoid;
        this.guoname = guoname;
        this.xiangqing = xiangqing;
        this.tupian = tupian;
        this.username = username;
        this.shenhe = shenhe;
    }

    public int getShenhe() {
        return shenhe;
    }

    public void setShenhe(int shenhe) {
        this.shenhe = shenhe;
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

    public int getGuoid() {
        return guoid;
    }

    public void setGuoid(int guoid) {
        this.guoid = guoid;
    }

    public String getGuoname() {
        return guoname;
    }

    public void setGuoname(String guoname) {
        this.guoname = guoname;
    }

    public String getXiangqing() {
        return xiangqing;
    }

    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "pingjia{" +
                "id=" + id +
                ", guoid=" + guoid +
                ", guoname='" + guoname + '\'' +
                ", xiangqing='" + xiangqing + '\'' +
                ", tupian='" + tupian + '\'' +
                ", username='" + username + '\'' +
                ", shenhe=" + shenhe +
                '}';
    }
}
