package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.guojialist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouTaidrawTableMapper {

    /**
     * 查询各个旅行国家名字
     * @return
     */
    @Select("select distinct(zhouname) from guojialist ")
    public List<guojialist> findGuoJiaAll();

    /**
     * 今天，根据guoid获取
     * @return
     */
    @Select("select sum(feiyong) from dingdan where guoid in " +
            "(select id from guojialist where zhouname=#{zhouname} and " +
            "date_format(xiadantime,'%Y%m') = date_format(curdate(),'%Y%m'))")
    public int getToday(@Param("guoid") Integer guoid);

    /**
     * 昨天，根据guoid获取
     * @return
     */
    @Select("select sum(feiyong) from dingdan where guoid in " +
            "(select id from guojialist where zhouname=#{zhouname} and " +
            "and to_days(now()) - to_days(xiadantime) = 1")
    public int getYesterday(@Param("guoid") Integer guoid);

    /**
     * 本月，根据guoid获取
     * @return
     */
    @Select("select sum(feiyong) from dingdan where guoid in " +
            "(select id from guojialist where zhouname=#{zhouname} and " +
            "and YEARWEEK(date_format(xiadantime,'%Y-%m-%d')) = YEARWEEK(now())")
    public int getMonth(@Param("guoid") Integer guoid);

    /**
     * 本周，根据guoid获取
     * @param guoid
     * @return
     */
    @Select("select sum(feiyong) from dingdan where guoid in " +
            "(select id from guojialist where zhouname=#{zhouname} and " +
            "and date_format(xiadantime,'%Y%m') = date_format(curdate(),'%Y%m')")
    public int getWeek(@Param("guoid") Integer guoid);

    /**
     * 本季度，根据guoid获取
     * @return
     */
    @Select("select sum(feiyong) from dingdan where guoid in " +
            "(select id from guojialist where zhouname=#{zhouname} and " +
            "and QUARTER(xiadantime)=QUARTER(now())")
    public int getQuarter(@Param("guoid") Integer guoid);

}
