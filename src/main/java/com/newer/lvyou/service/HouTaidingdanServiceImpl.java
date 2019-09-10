package com.newer.lvyou.service;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.mapper.HouTaidingdanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaidingdanServiceImpl implements HouTaidingdanService{

    @Autowired
    private HouTaidingdanMapper houTaidingdanMapper;

    /**
     * 显示所有订单详细信息
     * @return
     */
    @Override
    public List<dingdan> findAlldingdan() {
        return houTaidingdanMapper.findAlldingdan();
    }

    /**
     * 根据国家uname进行分页
     * @param uname
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<dingdan> findAlldingdanFenYe(String uname,Integer state,Integer pageNo, Integer pageSize, String beginDate, String endDate) {
        return houTaidingdanMapper.findAlldingdanFenYe(uname,state,pageNo,pageSize,beginDate,endDate);
    }

    /**
     * 新增订单信息
     * @param dingdan
     * @return
     */
    @Override
    public int dingdanAdd(dingdan dingdan) {
        return houTaidingdanMapper.dingdanAdd(dingdan);
    }

    /**
     * 根据订单id删除订单信息
     * @param id
     * @return
     */
    @Override
    public int dingdanDelete(Integer id) {
        return houTaidingdanMapper.dingdanDelete(id);
    }

    /**
     * 根据订单id修改订单信息
     * @param dingdan
     * @return
     */
    @Override
    public int dingdanUpdate(dingdan dingdan) {
        return houTaidingdanMapper.dingdanUpdate(dingdan);
    }

    /**
     * 根据订单id查询单条订单信息
     * @param id
     * @return
     */
    @Override
    public dingdan dingdanSelect(Integer id) {
        return houTaidingdanMapper.dingdanSelect(id);
    }

    /**
     * 根据订单状态state查询所有订单
     * @param state
     * @return
     */
    @Override
    public dingdan dingdanSelectState(Integer state) {
        return houTaidingdanMapper.dingdanSelectState(state);
    }

    /**
     * 统计订单总数量
     * @return
     */
    @Override
    public int dingdanCount(String uname,Integer state,String beginDate,String endDate) {
        return houTaidingdanMapper.dingdanCount(uname,state,beginDate,endDate);
    }

    /**
     * 根据订单状态进行分页
     * @param state
     * @param pageNo
     * @param pageSize
     * @param beginDate
     * @param endDate
     * @return
     *//*
    @Override
    public List<dingdan> findAlldingdanStateFenYe(Integer state,String uname, Integer pageNo, Integer pageSize, String beginDate, String endDate) {
        return houTaidingdanMapper.findAlldingdanStateFenYe(uname,state,pageNo,pageSize,beginDate,endDate);
    }

    *//**
     *根据state统计订单总数量
     * @param state
     * @param beginDate
     * @param endDate
     * @return
     *//*
    @Override
    public int dingdanStateCount(Integer state,String uname,String beginDate, String endDate) {
        return houTaidingdanMapper.dingdanStateCount(uname,state,beginDate,endDate);
    }*/
}
