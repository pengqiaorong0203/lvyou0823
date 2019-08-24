package com.newer.lvyou.domain;

import java.io.Serializable;
//后台管理员类
public class admin implements Serializable {
    private static final long serialVersionUID = 5413054006017530370L;

    private int id;      //管理员id
    private String name; //管理员名字
    private String pwd;  //管理员密码
    private int level;   //管理员等级

    public admin() {
    }

    public admin(int id, String name, String pwd,int level) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.level = level;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", level=" + level +
                '}';
    }
}
