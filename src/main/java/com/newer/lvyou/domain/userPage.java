package com.newer.lvyou.domain;

import java.util.List;

/**
 * 用户评论分页封装数据
 */
public class userPage {

    public static int pageSize = 5;
    private int pageNo;
    private List<user> result;
    private int totalPage;

    public userPage() {
    }

    public userPage(int pageNo, List<user> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        userPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<user> getResult() {
        return result;
    }

    public void setResult(List<user> result) {
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
        return "userPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
