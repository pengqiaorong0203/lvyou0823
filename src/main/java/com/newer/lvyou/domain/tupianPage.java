package com.newer.lvyou.domain;

import java.util.List;

/**
 * 团队分页封装数据
 */
public class tupianPage {

    public static int pageSize = 10;

    private int pageNo;
    private List<tupian> result;
    private int totalPage;

    public tupianPage() {
    }

    public tupianPage(int pageNo, List<tupian> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        tupianPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<tupian> getResult() {
        return result;
    }

    public void setResult(List<tupian> result) {
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
        return "tupianPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
