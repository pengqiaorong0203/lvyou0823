package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.guojialist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QianTaiMapper {

    @Select("select * from guojialist where zhouname = #{zhouname}")
    public List<guojialist> selectGJByZname(@Param("zhouname")String zhouname); //根据洲名字便利国家

}
