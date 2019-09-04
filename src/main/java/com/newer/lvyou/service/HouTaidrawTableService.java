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
    public int getToday(@Param("guoid") Integer guoid);

    /**
     * 昨天，根据guoid获取
     * @return
     */
    public int getYesterday(@Param("guoid") Integer guoid);

    /**
     * 本月，根据guoid获取
     * @return
     */
    public int getMonth(@Param("guoid") Integer guoid);

    /**
     * 本周，根据guoid获取
     * @param guoid
     * @return
     */
    public int getWeek(@Param("guoid") Integer guoid);

    /**
     * 本季度，根据guoid获取
     * @return
     */
    public int getQuarter(@Param("guoid") Integer guoid);
}
