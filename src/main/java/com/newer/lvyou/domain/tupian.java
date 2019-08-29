package com.newer.lvyou.domain;

import java.io.Serializable;
//展示图片
public class tupian implements Serializable {
    private static final long serialVersionUID = 5940258065928255164L;

    private int id;       //图片id
    private int guoid;    //国家id
    private String tpurl; //图片链接
    private int shenhe;   //后台审核

    public tupian() {
    }

    public tupian(int id, int guoid, String tpurl,int shenhe) {
        this.id = id;
        this.guoid = guoid;
        this.tpurl = tpurl;
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

    public String getTpurl() {
        return tpurl;
    }

    public void setTpurl(String tpurl) {
        this.tpurl = tpurl;
    }

    public int getShenhe() {
        return shenhe;
    }

    public void setShenhe(int shenhe) {
        this.shenhe = shenhe;
    }

    @Override
    public String toString() {
        return "tupian{" +
                "id=" + id +
                ", guoid=" + guoid +
                ", tpurl='" + tpurl + '\'' +
                ", shenhe=" + shenhe +
                '}';
    }
}
