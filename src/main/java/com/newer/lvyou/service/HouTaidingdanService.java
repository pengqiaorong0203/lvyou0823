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
     * 统计订单总数量
     * @return
     */
    public int dingdanCount();
}
