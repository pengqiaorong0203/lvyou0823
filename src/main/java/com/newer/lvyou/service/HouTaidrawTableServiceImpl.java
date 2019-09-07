package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.mapper.HouTaidrawTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaidrawTableServiceImpl implements HouTaidrawTableService{

    @Autowired
    private HouTaidrawTableMapper houTaidrawTableMapper;

    /**
     * 查询各个旅行国家名字
     * @return
     */
    @Override
    public List<guojialist> findGuoJiaAll() {
        return houTaidrawTableMapper.findGuoJiaAll();
    }

    /**
     * 今天，根据guoid获取
     * @return
     */
    @Override
    public int getToday(Integer id) {
        return houTaidrawTableMapper.getToday(id);
    }

    /**
     * 昨天，根据guoid获取
     * @return
     */
    @Override
    public int getYesterday(Integer id) {
        return houTaidrawTableMapper.getYesterday(id);
    }

    /**
     * 本月，根据guoid获取
     * @return
     */
    @Override
    public int getMonth(Integer id) {
        return houTaidrawTableMapper.getMonth(id);
    }

    /**
     * 本周，根据guoid获取
     * @param id
     * @return
     */
    @Override
    public int getWeek(Integer id) {
        return houTaidrawTableMapper.getWeek(id);
    }

    /**
     * 本季度，根据guoid获取
     * @return
     */
    @Override
    public int getQuarter(Integer id) {
        return houTaidrawTableMapper.getQuarter(id);
    }
}
