package com.newer.lvyou.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//订单项类
public class dingdan implements Serializable {
    private static final long serialVersionUID = -7668881162490840974L;

    private int id;        //订单id
    private int uid;       //用户id
    private String uname;  //用户真实姓名
    private String phone;  //去旅游人的联系方式   因为下单的人不一定是去旅游的人
    private String email;  //用户邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date time;     //去旅游的日期
    private int chengren;  //去旅游的成人人数
    private int ertong;    //去旅游的儿童人数
    private String info;   //备注信息
    private int state;     //订单状态   生成的时候为0：未付款   点击支付后为1：已付款   已经去旅游了为2：已旅游
    private int jiuid;     //行程绑定的酒店id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date xiadantime;//订单下单时间
    private int feiyong;    //订单费用
    private int guoid;      //绑定旅游国家id

    public dingdan() {
    }

    public dingdan(int id, int uid, String uname, String phone, String email, Date time, int chengren, int ertong, String info, int state, int jiuid,Date xiadantime,int feiyong,int guoid) {
        this.id = id;
        this.uid = uid;
        this.uname = uname;
        this.phone = phone;
        this.email = email;
        this.time = time;
        this.chengren = chengren;
        this.ertong = ertong;
        this.info = info;
        this.state = state;
        this.jiuid = jiuid;
        this.xiadantime = xiadantime;
        this.feiyong = feiyong;
        this.guoid = guoid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getChengren() {
        return chengren;
    }

    public void setChengren(int chengren) {
        this.chengren = chengren;
    }

    public int getErtong() {
        return ertong;
    }

    public void setErtong(int ertong) {
        this.ertong = ertong;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getJiuid() {
        return jiuid;
    }

    public void setJiuid(int jiuid) {
        this.jiuid = jiuid;
    }

    public Date getXiadantime() {
        return xiadantime;
    }

    public void setXiadantime(Date xiadantime) {
        this.xiadantime = xiadantime;
    }

    public int getFeiyong() {
        return feiyong;
    }

    public void setFeiyong(int feiyong) {
        this.feiyong = feiyong;
    }

    public int getGuoid() {
        return guoid;
    }

    public void setGuoid(int guoid) {
        this.guoid = guoid;
    }

    @Override
    public String toString() {
        return "dingdan{" +
                "id=" + id +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", time=" + time +
                ", chengren=" + chengren +
                ", ertong=" + ertong +
                ", info='" + info + '\'' +
                ", state=" + state +
                ", jiuid=" + jiuid +
                ", xiadantime=" + xiadantime +
                ", feiyong=" + feiyong +
                ", guoid=" + guoid +
                '}';
    }
}
