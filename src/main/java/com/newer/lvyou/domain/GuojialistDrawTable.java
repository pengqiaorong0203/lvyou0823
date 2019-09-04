package com.newer.lvyou.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 科室挂号人数对象
 */
public class GuojialistDrawTable implements Serializable {

    private static final long serialVersionUID = 6421642483517598885L;
    private String zhouname;//各洲名称
    private List<Integer> countList;//今天/昨天/本周/本月/本季

    public GuojialistDrawTable(String zhouname, List<Integer> countList) {
        this.zhouname = zhouname;
        this.countList = countList;
    }

    public GuojialistDrawTable() {
    }

    public String getZhouname() {
        return zhouname;
    }

    public void setzhouname(String zhouname) {
        this.zhouname = zhouname;
    }

    public List<Integer> getCountList() {
        return countList;
    }

    public void setCountList(List<Integer> countList) {
        this.countList = countList;
    }
}
