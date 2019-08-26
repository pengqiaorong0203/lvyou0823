package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.tuandui;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface HoutaiMapper {

    @Select("select * from tuandui")
    public List<tuandui> selectTD(); //查询所有团队

    @Insert("insert into tuandui(tname,info,toux) values(#{tname},#{info},#{toux})")
    public int addTD(tuandui td);//新增团队

    @Update("update tuandui set tname = #{tname},info = #{info},toux = #{toux} where id = #{id}")
    public int updTD(tuandui td);//修改团队

    @Delete("delete from tuandui where id = #{id}")
    public int delTD(@Param("id")int id);//删除团队

    @Select("select * from jiudian")
    public List<jiudian> selectJD();//查询所有酒店




}
