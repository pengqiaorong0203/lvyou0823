package com.newer.lvyou.domain;

import java.io.Serializable;
//旅游国家列表类
public class guojialist implements Serializable {
    private static final long serialVersionUID = -8476675581342247022L;

    private int id;          //表id
    private String zhouname; //大洲名
    private String guoname;  //国家名
    private String tpurl;    //国家图片
    private int shuxing;  //分类属性 1：推荐  2：热门
    private int shenhe;      //后台审核

    public guojialist() {
    }

    public guojialist(int id, String zhouname, String guoname, String tpurl, int shuxing,int shenhe) {
        this.id = id;
        this.zhouname = zhouname;
        this.guoname = guoname;
        this.tpurl = tpurl;
        this.shuxing = shuxing;
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

    public String getZhouname() {
        return zhouname;
    }

    public void setZhouname(String zhouname) {
        this.zhouname = zhouname;
    }

    public String getGuoname() {
        return guoname;
    }

    public void setGuoname(String guoname) {
        this.guoname = guoname;
    }

    public String getTpurl() {
        return tpurl;
    }

    public void setTpurl(String tpurl) {
        this.tpurl = tpurl;
    }

    public int getShuxing() {
        return shuxing;
    }

    public void setShuxing(int shuxing) {
        this.shuxing = shuxing;
    }

    public int getShenhe() {
        return shenhe;
    }

    public void setShenhe(int shenhe) {
        this.shenhe = shenhe;
    }

    @Override
    public String toString() {
        return "guojialist{" +
                "id=" + id +
                ", zhouname='" + zhouname + '\'' +
                ", guoname='" + guoname + '\'' +
                ", tpurl='" + tpurl + '\'' +
                ", shuxing='" + shuxing + '\'' +
                ", shenhe=" + shenhe +
                '}';
    }
}
