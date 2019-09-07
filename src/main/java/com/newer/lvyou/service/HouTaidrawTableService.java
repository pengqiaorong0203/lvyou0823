package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaidrawTableService {

    /**
     * 查询各个旅行国家名字
     * @return
     */
    public List<guojialist> findGuoJiaAll();

    /**
     * 今天，根据guoid获取
     * @return
     */
    public int getToday(Integer id);

    /**
     * 昨天，根据guoid获取
     * @return
     */
    public int getYesterday(Integer id);

    /**
     * 本月，根据guoid获取
     * @return
     */
    public int getMonth(Integer id);

    /**
     * 本周，根据guoid获取
     * @param id
     * @return
     */
    public int getWeek(Integer id);

    /**
     * 本季度，根据guoid获取
     * @return
     */
    public int getQuarter(Integer id);
}
