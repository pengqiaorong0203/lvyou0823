package com.newer.lvyou.domain;

import java.io.Serializable;
//旅游国家列表类
public class guojialist implements Serializable {
    private static final long serialVersionUID = -8476675581342247022L;

    private int id;          //表id
    private String zhouname; //大洲名
    private String guoname;  //国家名
    private String tpurl;    //国家图片
    private String shuxing;  //分类属性 1：推荐  2：热门

    public guojialist() {
    }

    public guojialist(int id, String zhouname, String guoname, String tpurl, String shuxing) {
        this.id = id;
        this.zhouname = zhouname;
        this.guoname = guoname;
        this.tpurl = tpurl;
        this.shuxing = shuxing;
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

    public String getShuxing() {
        return shuxing;
    }

    public void setShuxing(String shuxing) {
        this.shuxing = shuxing;
    }

    @Override
    public String toString() {
        return "guojialist{" +
                "id=" + id +
                ", zhouname='" + zhouname + '\'' +
                ", guoname='" + guoname + '\'' +
                ", tpurl='" + tpurl + '\'' +
                ", shuxing='" + shuxing + '\'' +
                '}';
    }
}
