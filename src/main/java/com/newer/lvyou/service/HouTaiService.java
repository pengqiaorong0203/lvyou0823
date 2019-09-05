package com.newer.lvyou.service;

import com.newer.lvyou.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaiService {

    public List<tuandui> selectTD();

    public int addTD(tuandui td);

    public int updTD(tuandui td);

    public int delTD(@Param("id")int id);

    public List<jiudian> selectJD();

    public int addJD(jiudian jd);

    public int updJD(jiudian jd);

    public int delJD(@Param("id")int id);

    public List<guojialist> queryGJList(@Param("guoname")String guoname,@Param("pageNo")int pageNo,@Param("pageSize")int pageSize);

    public int selectGJZS(@Param("guoname")String guoname);

    public int addGJList(guojialist gjl);

    public int updGJList(guojialist gjl);

    public int delGJList(int id);

    public lvyouxiangqing selectByGuoId(@Param("guoid")int guoid);

    public int addLYXQ(lvyouxiangqing lyxq);

    public int updLYXQ(lvyouxiangqing lyxq);

    public int delLYXQ(@Param("guoid")int guoid);

    public List<jutixingcheng> selectJTXC(@Param("guoid")int guoid);

    public jutixingcheng selectOneJTXC(@Param("id")int id);

    public int addJTXC(jutixingcheng jtxc);

    public int updJTXC(jutixingcheng jtxc);

    public int delJTXC(@Param("guoid")int guoid);

    public int delOneJTXC(@Param("id")int id);

    public List<tupian> selectTP();

    public tupian selectByTPId(@Param("id")int id);

    public int addTP(tupian tp);

    public int updTP(tupian tp);

    public tuandui selectTDById(@Param("id")int id);

    public jiudian selectJDById(@Param("id")int id);

    public guojialist selectGJByid(@Param("id")int id);
}
