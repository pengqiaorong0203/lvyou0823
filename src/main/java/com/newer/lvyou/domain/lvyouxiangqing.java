package com.newer.lvyou.domain;

import java.io.Serializable;
//旅游国家的详情
public class lvyouxiangqing implements Serializable {
    private static final long serialVersionUID = 282438932271895277L;

    private int id;               //选择国家的行程id
    private int guoid;            //国家id
    private String guoname;       //国家名称
    private String guotpurl;      //国家图片
    private String info;          //旅游国家的简介
    private String liangdian;     //这个旅游项目的亮点
    private int feiyong;          //总共的费用
    private String feiyongmingxi; //费用明细
    private String gengduo;       //更多的信息  备注

    public lvyouxiangqing() {
    }

    public lvyouxiangqing(int id, int guoid, String guoname, String guotpurl, String info, String liangdian, int feiyong, String feiyongmingxi, String gengduo) {
        this.id = id;
        this.guoid = guoid;
        this.guoname = guoname;
        this.guotpurl = guotpurl;
        this.info = info;
        this.liangdian = liangdian;
        this.feiyong = feiyong;
        this.feiyongmingxi = feiyongmingxi;
        this.gengduo = gengduo;
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

    public String getGuotpurl() {
        return guotpurl;
    }

    public void setGuotpurl(String guotpurl) {
        this.guotpurl = guotpurl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLiangdian() {
        return liangdian;
    }

    public void setLiangdian(String liangdian) {
        this.liangdian = liangdian;
    }

    public int getFeiyong() {
        return feiyong;
    }

    public void setFeiyong(int feiyong) {
        this.feiyong = feiyong;
    }

    public String getFeiyongmingxi() {
        return feiyongmingxi;
    }

    public void setFeiyongmingxi(String feiyongmingxi) {
        this.feiyongmingxi = feiyongmingxi;
    }

    public String getGengduo() {
        return gengduo;
    }

    public void setGengduo(String gengduo) {
        this.gengduo = gengduo;
    }

    @Override
    public String toString() {
        return "lvyouxiangqing{" +
                "id=" + id +
                ", guoid=" + guoid +
                ", guoname='" + guoname + '\'' +
                ", guotpurl='" + guotpurl + '\'' +
                ", info='" + info + '\'' +
                ", liangdian='" + liangdian + '\'' +
                ", feiyong=" + feiyong +
                ", feiyongmingxi='" + feiyongmingxi + '\'' +
                ", gengduo='" + gengduo + '\'' +
                '}';
    }
}
