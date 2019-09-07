package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.jiudian;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaijiudianMapper {

    /**
     * 根据酒店名字进行分页
     * @param jdname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<jiudian> findAlljiudianFenYe(@Param("jdname") String jdname,
                                             @Param("pageNo") int pageNo,
                                             @Param("pageSize") int pageSize);

    /**
     *新增酒店信息
     * @param jiudian
     * @return
     */
    @Insert("insert into jiudian(guoid,jdname,info,tupian,shenhe,jiage) " +
            "values(#{guoid},#{jdname},#{info},#{tupian},#{0},#{jiage})")
    public int jiudianAdd(jiudian jiudian);

    /**
     * 根据酒店id删除酒店信息
     * @param id
     * @return
     */
    @Delete("delete from jiudian where id=#{id}")
    public int jiudianDelete(Integer id);

    /**
     * 修改酒店id详细信息
     * @param jiudian
     * @return
     */
    @Update("update jiudian set guoid=#{guoid},jdname=#{jdname},info=#{info}," +
            "shenhe=#{shenhe},jiage=#{jiage} where id=#{id}")
    public int jiudianUpdate(jiudian jiudian);

    /**
     * 统计酒店信息总数量
     * @return
     */
    public int jiudianCount(@Param("jdname") String jdname);
}
