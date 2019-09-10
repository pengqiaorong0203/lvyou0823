package com.newer.lvyou.domain;

import java.io.Serializable;
//酒店类
public class jiudian implements Serializable {
    private static final long serialVersionUID = 6971678451406021978L;

    private int id;       //酒店id
    private int guoid;    //对应的国家id
    private String jdname;//酒店名称
    private String info;  //酒店描述
    private String tupian;//酒店图片
    private int shenhe;   //后台审核
    private int jiage;    //酒店价格
    private String guoname; //国家名字

    public jiudian() {
    }

    public jiudian(int id, int guoid, String jdname, String info, String tupian, int shenhe, int jiage, String guoname) {
        this.id = id;
        this.guoid = guoid;
        this.jdname = jdname;
        this.info = info;
        this.tupian = tupian;
        this.shenhe = shenhe;
        this.jiage = jiage;
        this.guoname = guoname;
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

    public String getJdname() {
        return jdname;
    }

    public void setJdname(String jdname) {
        this.jdname = jdname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public int getShenhe() {
        return shenhe;
    }

    public void setShenhe(int shenhe) {
        this.shenhe = shenhe;
    }

    public int getJiage() {
        return jiage;
    }

    public void setJiage(int jiage) {
        this.jiage = jiage;
    }

    public String getGuoname() {
        return guoname;
    }

    public void setGuoname(String guoname) {
        this.guoname = guoname;
    }

    @Override
    public String toString() {
        return "jiudian{" +
                "id=" + id +
                ", guoid=" + guoid +
                ", jdname='" + jdname + '\'' +
                ", info='" + info + '\'' +
                ", tupian='" + tupian + '\'' +
                ", shenhe=" + shenhe +
                ", jiage=" + jiage +
                ", guoname='" + guoname + '\'' +
                '}';
    }
}
