package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QianTaiService {

    public List<guojialist> selectGJByZname(@Param("zhouname")String zhouname); //根据洲名字便利国家
}
