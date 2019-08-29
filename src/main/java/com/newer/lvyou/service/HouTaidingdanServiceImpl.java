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
     * 统计订单总数量
     * @return
     */
    @Override
    public int dingdanCount() {
        return houTaidingdanMapper.dingdanCount();
    }
}
