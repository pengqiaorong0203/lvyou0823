package com.newer.lvyou.domain;

import java.util.List;

public class GjlistPage {

    public static int pageSize = 10;

    private int pageNo;
    private List<guojialist> result;
    private int totalPage;

    public GjlistPage() {
    }

    public GjlistPage(int pageNo, List<guojialist> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        GjlistPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<guojialist> getResult() {
        return result;
    }

    public void setResult(List<guojialist> result) {
        this.result = result;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "GjlistPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
