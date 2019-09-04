package com.newer.lvyou.domain;

import java.io.Serializable;
import java.util.List;

public class GuojialistDrawTableCount implements Serializable {

    private static final long serialVersionUID = 8123633998667644970L;
    private List<String> times;//存放表头,//今天/昨天/本周/本月/本季度
    private List<guojialist> guojialistList;//存放表体数据

    public GuojialistDrawTableCount() {
    }

    public GuojialistDrawTableCount(List<String> times, List<guojialist> guojialistList) {
        this.times = times;
        this.guojialistList = guojialistList;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<guojialist> getGuojialistList() {
        return guojialistList;
    }

    public void setGuojialistList(List<guojialist> guojialistList) {
        this.guojialistList = guojialistList;
    }
}
