package com.newer.lvyou.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//2级管理员的审核列表
public class shenhelist implements Serializable {
    private static final long serialVersionUID = -8090985299278300222L;

    private int id;             //审核列表ID
    private String xiugaibiao;  //需要审核信息所在的表
    private int biaoid;         //需要审核信息在它所在的表里的ID
    private String xiugaiadmin; //是谁修改的信息
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date xiugaitime;    //修改的时间

    public shenhelist() {
    }

    public shenhelist(int id, String xiugaibiao, int biaoid, String xiugaiadmin, Date xiugaitime) {
        this.id = id;
        this.xiugaibiao = xiugaibiao;
        this.biaoid = biaoid;
        this.xiugaiadmin = xiugaiadmin;
        this.xiugaitime = xiugaitime;
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

    public String getXiugaibiao() {
        return xiugaibiao;
    }

    public void setXiugaibiao(String xiugaibiao) {
        this.xiugaibiao = xiugaibiao;
    }

    public int getBiaoid() {
        return biaoid;
    }

    public void setBiaoid(int biaoid) {
        this.biaoid = biaoid;
    }

    public String getXiugaiadmin() {
        return xiugaiadmin;
    }

    public void setXiugaiadmin(String xiugaiadmin) {
        this.xiugaiadmin = xiugaiadmin;
    }

    public Date getXiugaitime() {
        return xiugaitime;
    }

    public void setXiugaitime(Date xiugaitime) {
        this.xiugaitime = xiugaitime;
    }

    @Override
    public String toString() {
        return "shenhelist{" +
                "id=" + id +
                ", xiugaibiao='" + xiugaibiao + '\'' +
                ", biaoid=" + biaoid +
                ", xiugaiadmin='" + xiugaiadmin + '\'' +
                ", xiugaitime=" + xiugaitime +
                '}';
    }
}
