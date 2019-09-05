package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QianTaiService {

    public List<guojialist> selectGJByZname(@Param("zhouname")String zhouname); //根据洲名字便利国家

    public guojialist selectGJByid(@Param("id")int id); //根据id拿值

    public List<guojialist> selectAllGJ();

    public List<guojialist> selectGJ6();

    public List<lvyouxiangqing> selectlvxiang6();
}
