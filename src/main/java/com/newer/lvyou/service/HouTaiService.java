package com.newer.lvyou.service;

import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.tuandui;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaiService {

    public List<tuandui> selectTD();

    public int addTD(tuandui td);

    public int updTD(tuandui td);

    public int delTD(@Param("id")int id);

    public List<jiudian> selectJD();
}
