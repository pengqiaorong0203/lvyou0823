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
    public int getToday(Integer guoid) {
        return houTaidrawTableMapper.getToday(guoid);
    }

    /**
     * 昨天，根据guoid获取
     * @return
     */
    @Override
    public int getYesterday(Integer guoid) {
        return houTaidrawTableMapper.getYesterday(guoid);
    }

    /**
     * 本月，根据guoid获取
     * @return
     */
    @Override
    public int getMonth(Integer guoid) {
        return houTaidrawTableMapper.getMonth(guoid);
    }

    /**
     * 本周，根据guoid获取
     * @param guoid
     * @return
     */
    @Override
    public int getWeek(Integer guoid) {
        return houTaidrawTableMapper.getWeek(guoid);
    }

    /**
     * 本季度，根据guoid获取
     * @return
     */
    @Override
    public int getQuarter(Integer guoid) {
        return houTaidrawTableMapper.getQuarter(guoid);
    }
}
