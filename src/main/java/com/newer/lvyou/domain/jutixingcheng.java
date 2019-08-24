package com.newer.lvyou.domain;

import java.io.Serializable;
//旅游具体行程类
public class jutixingcheng implements Serializable {
    private static final long serialVersionUID = -4580218765283840865L;

    private int id;                  //行程id
    private int guoid;               //国家id
    private String xingcheng;        //行程第几天
    private String xingchengurl;     //行程图片
    private String xingchengmiaoshu; //行程具体描述
    private int jiuid;               //酒店id

    public jutixingcheng() {
    }

    public jutixingcheng(int id, int guoid, String xingcheng, String xingchengurl, String xingchengmiaoshu, int jiuid) {
        this.id = id;
        this.guoid = guoid;
        this.xingcheng = xingcheng;
        this.xingchengurl = xingchengurl;
        this.xingchengmiaoshu = xingchengmiaoshu;
        this.jiuid = jiuid;
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

    public String getXingcheng() {
        return xingcheng;
    }

    public void setXingcheng(String xingcheng) {
        this.xingcheng = xingcheng;
    }

    public String getXingchengurl() {
        return xingchengurl;
    }

    public void setXingchengurl(String xingchengurl) {
        this.xingchengurl = xingchengurl;
    }

    public String getXingchengmiaoshu() {
        return xingchengmiaoshu;
    }

    public void setXingchengmiaoshu(String xingchengmiaoshu) {
        this.xingchengmiaoshu = xingchengmiaoshu;
    }

    public int getJiuid() {
        return jiuid;
    }

    public void setJiuid(int jiuid) {
        this.jiuid = jiuid;
    }

    @Override
    public String toString() {
        return "jutixingcheng{" +
                "id=" + id +
                ", guoid=" + guoid +
                ", xingcheng='" + xingcheng + '\'' +
                ", xingchengurl='" + xingchengurl + '\'' +
                ", xingchengmiaoshu='" + xingchengmiaoshu + '\'' +
                ", jiuid=" + jiuid +
                '}';
    }
}
