package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.dingdan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaidingdanMapper {

    /**
     * 显示所有订单信息;
     * @return
     */
    @Select("select * from dingdan")
    public List<dingdan> findAlldingdan();

    /**
     * 新增订单信息;
     * @param dingdan
     * @return
     */
    @Insert("insert into dingdan(uid,uname,phone,email,time,chengren,ertong,info,state,jiuid,feiyong,xiadantime" +
            "values(#{uid},#{uname},#{phone},#{email},#{time},#{chengren}," +
            "#{ertong},#{info},#{state},#{jiuid},#{feiyong},#{xiadantime})")
    public int dingdanAdd(dingdan dingdan);

    /**
     *根据订单id删除订单信息
     * @param id
     * @return
     */
    @Delete("delete from dingdan where id=#{id}")
    public int dingdanDelete(Integer id);

    /**
     * 根据订单id修改订单信息
     * @param dingdan
     * @return
     */
    @Update("update dingdan set uid=#{uid},uname=#{uname},phone=#{phone},email=#{email}," +
            "time=#{time},chengren=#{chengren},ertong=#{ertong},info=#{info},state=#{state}," +
            "jiuid=#{jiuid},feiyong=#{feiyong},xiadantime=#{xiadantime} where id=#{id}")
    public int dingdanUpdate(dingdan dingdan);

    /**
     * 统计订单总数量
     * @return
     */
    @Select("select count(1) from dingdan")
    public int dingdanCount();
}
