package com.newer.lvyou.domain;

import java.io.Serializable;
//用户类
public class user implements Serializable {
    private static final long serialVersionUID = 793779252034976355L;

    private int id;           //用户id
    private String username;  //用户名
    private String pwd;       //用户密码
    private String phone;     //用户联系方式
    private String sex;       //用户性别

    public user() {
    }

    public user(int id, String username, String pwd, String phone, String sex) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.phone = phone;
        this.sex = sex;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
