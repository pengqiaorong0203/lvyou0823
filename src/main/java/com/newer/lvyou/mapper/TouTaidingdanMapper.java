package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.dingdan;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouTaidingdanMapper {

    /**
     * 查询所有订单信息;
     * @return
     */
    @Select("select * from dingdan")
    public List<dingdan> findAlldingdan();
}
