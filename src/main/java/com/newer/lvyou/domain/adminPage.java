package com.newer.lvyou.domain;

import java.util.List;

/**
 * 管理员分页封装数据
 */
public class adminPage {

    public static int pageSize = 5;
    private int pageNo;
    private List<admin> result;
    private int totalPage;

    public adminPage() {
    }

    public adminPage(int pageNo, List<admin> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        adminPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<admin> getResult() {
        return result;
    }

    public void setResult(List<admin> result) {
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
        return "adminPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
