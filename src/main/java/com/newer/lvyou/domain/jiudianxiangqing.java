package com.newer.lvyou.domain;

import java.io.Serializable;
//酒店详情类
public class jiudianxiangqing implements Serializable {
    private static final long serialVersionUID = 18935146101864529L;

    private int id;          //酒店详情id
    private int jiuid;       //酒店id
    private String jdtupian; //酒店图片
    private String jdname;   //酒店名称
    private String info;     //酒店详情描述
    private String tpurl;       //酒店价格

    public jiudianxiangqing() {
    }

    public jiudianxiangqing(int id, int jiuid, String jdtupian, String jdname, String info, String tpurl) {
        this.id = id;
        this.jiuid = jiuid;
        this.jdtupian = jdtupian;
        this.jdname = jdname;
        this.info = info;
        this.tpurl = tpurl;
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

    public int getJiuid() {
        return jiuid;
    }

    public void setJiuid(int jiuid) {
        this.jiuid = jiuid;
    }

    public String getJdtupian() {
        return jdtupian;
    }

    public void setJdtupian(String jdtupian) {
        this.jdtupian = jdtupian;
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

    public String getTpurl() {
        return tpurl;
    }

    public void setTpurl(String tpurl) {
        this.tpurl = tpurl;
    }

    @Override
    public String toString() {
        return "jiudianxiangqing{" +
                "id=" + id +
                ", jiuid=" + jiuid +
                ", jdtupian='" + jdtupian + '\'' +
                ", jdname='" + jdname + '\'' +
                ", info='" + info + '\'' +
                ", tpurl=" + tpurl +
                '}';
    }
}
