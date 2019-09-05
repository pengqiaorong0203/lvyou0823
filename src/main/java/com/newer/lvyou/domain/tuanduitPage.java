package com.newer.lvyou.domain;

import java.util.List;

/**
 * 团队分页封装数据
 */
public class tuanduitPage {

    public static int pageSize = 10;

    private int pageNo;
    private List<tuandui> result;
    private int totalPage;

    public tuanduitPage() {
    }

    public tuanduitPage(int pageNo, List<tuandui> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        tuanduitPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<tuandui> getResult() {
        return result;
    }

    public void setResult(List<tuandui> result) {
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
        return "tuanduitPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
