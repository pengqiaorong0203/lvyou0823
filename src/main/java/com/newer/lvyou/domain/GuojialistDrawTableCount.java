package com.newer.lvyou.domain;

import java.io.Serializable;
import java.util.List;

public class GuojialistDrawTableCount implements Serializable {

    private static final long serialVersionUID = 8123633998667644970L;
    private List<String> times;//存放表头,//今天/昨天/本周/本月/本季度
    private List<GuojialistDrawTable> guojialistDrawTableList;//存放表体数据

    public GuojialistDrawTableCount() {
    }

    public GuojialistDrawTableCount(List<String> times, List<GuojialistDrawTable> guojialistDrawTableList) {
        this.times = times;
        this.guojialistDrawTableList = guojialistDrawTableList;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<GuojialistDrawTable> getGuojialistDrawTableList() {
        return guojialistDrawTableList;
    }

    public void setGuojialistDrawTableList(List<GuojialistDrawTable> guojialistDrawTableList) {
        this.guojialistDrawTableList = guojialistDrawTableList;
    }
}
