package com.newer.lvyou.service;

import com.newer.lvyou.domain.dingdan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaidingdanService {

    /**
     *显示所有订单详细信息
     * @return
     */
    public List<dingdan> findAlldingdan();

    /**
     * 根据国家uname进行分页
     * @param uname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<dingdan> findAlldingdanFenYe(@Param("uname") String uname,
                                             @Param("state")String state,
                                             @Param("pageNo")Integer pageNo,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("beginDate")String beginDate,
                                             @Param("endDate")String endDate);

    /**
     * 统计订单总数
     * @return
     */
    public int dingdanCount(@Param("uname")String uname,
                            @Param("state")String state,
                            @Param("beginDate")String beginDate,
                            @Param("endDate")String endDate);

    /**
     * 根据订单状态进行分页
     * @param state
     * @param pageNo
     * @param pageSize
     * @param beginDate
     * @param endDate
     * @return
     *//*
    public List<dingdan> findAlldingdanStateFenYe(
            @Param("state")Integer state,
            @Param("uname") String uname,
            @Param("pageNo")Integer pageNo,
            @Param("pageSize")Integer pageSize,
            @Param("beginDate")String beginDate,
            @Param("endDate")String endDate);

    *//**
     * 统计订单总数量
     * @return
     *//*
    public int dingdanStateCount(
            @Param("state")Integer state,
            @Param("uname") String uname,
            @Param("beginDate")String beginDate,
            @Param("endDate")String endDate);*/


    /**
     *新增订单信息
     * @return
     */
    public int dingdanAdd(dingdan dingdan);

    /**
     * 根据订单id删除订单信息
     * @param id
     * @return
     */
    public int dingdanDelete(@Param("id") Integer id);

    /**
     * 根据订单id修改订单信息
     * @param dingdan
     * @return
     */
    public int dingdanUpdate(dingdan dingdan);

    /**
     * 根据订单id查询单条订单信息
     * @param id
     * @return
     */
    public dingdan dingdanSelect(@Param("id") Integer id);

    /**
     * 根据订单状态state查询所有订单
     * @param state
     * @return
     */
    public dingdan dingdanSelectState(@Param("state") Integer state);
}
