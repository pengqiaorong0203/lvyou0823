package com.newer.lvyou.domain;

import java.util.List;

/**
 * 用户评论分页封装数据
 */
public class dingdanlistPage {

    public static int pageSize = 10;

    private int pageNo;
    private List<dingdan> result;
    private int totalPage;

    public dingdanlistPage() {
    }

    public dingdanlistPage(int pageNo, List<dingdan> result, int totalPage) {
        this.pageNo = pageNo;
        this.result = result;
        this.totalPage = totalPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        dingdanlistPage.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<dingdan> getResult() {
        return result;
    }

    public void setResult(List<dingdan> result) {
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
        return "dingdanlistPage{" +
                "pageNo=" + pageNo +
                ", result=" + result +
                ", totalPage=" + totalPage +
                '}';
    }
}
