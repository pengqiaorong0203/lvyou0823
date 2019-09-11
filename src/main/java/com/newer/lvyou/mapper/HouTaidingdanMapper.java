package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.dingdan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaidingdanMapper {

    /**
     * 显示所有订单信息;
     * @return
     */
    @Select("select * from dingdan")
    public List<dingdan> findAlldingdan();

    /**
     * 根据国家uname进行分页
     * @param uname
     * @param pageNo
     * @param pageSize
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<dingdan> findAlldingdanFenYe(@Param("uname") String uname,
                                             @Param("state")String state,
                                             @Param("pageNo")Integer pageNo,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("beginDate")String beginDate,
                                             @Param("endDate")String endDate);

    /**
     * 统计订单总数量
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
    public List<dingdan> findAlldingdanStateFenYe(@Param("uname") String uname,
                                             @Param("state")Integer state,
                                             @Param("pageNo")Integer pageNo,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("beginDate")String beginDate,
                                             @Param("endDate")String endDate);

    *//**
     * 根据state统计订单总数量
     * @return
     *//*
    public int dingdanStateCount(@Param("uname") String uname,
                            @Param("state")Integer state,
                            @Param("beginDate")String beginDate,
                            @Param("endDate")String endDate);*/


    /**
     * 新增订单信息;
     * @param dingdan
     * @return
     */
    @Insert("insert into dingdan(uid,uname,phone,email,time,chengren,ertong,info,state,jiuid,feiyong,xiadantime" +
            "values(#{uid},#{uname},#{phone},#{email},#{time},#{chengren}," +
            "#{ertong},#{info},#{state},#{jiuid},#{feiyong},#{xiadantime})")
    public int dingdanAdd(dingdan dingdan);

    /**
     *根据订单id删除订单信息
     * @param id
     * @return
     */
    @Delete("delete from dingdan where id=#{id}")
    public int dingdanDelete(Integer id);

    /**
     * 根据订单id修改订单信息
     * @param dingdan
     * @return
     */
    @Update("update dingdan set uname=#{uname},info=#{info},state=#{state} where id=#{id}")
    public int dingdanUpdate(dingdan dingdan);

    /**
     * 根据订单id查询单条订单信息
     * @param id
     * @return
     */
    @Select("select * from dingdan where id=#{id}")
    public dingdan dingdanSelect(@Param("id") Integer id);

    /**
     * 根据订单状态state查询所有订单
     * @param state
     * @return
     */
    @Select("select * from dingdan where state=#{state}")
    public dingdan dingdanSelectState(@Param("state") Integer state);
}
