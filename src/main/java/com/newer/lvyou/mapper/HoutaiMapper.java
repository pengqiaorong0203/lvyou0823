package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoutaiMapper {

    @Select("select * from tuandui")
    public List<tuandui> selectTD(); //查询所有团队

    @Select("select * from tuandui where id = #{id}")
    public tuandui selectTDById(@Param("id")int id);//根据团队id查询单个团队

    @Insert("insert into tuandui(tname,info,toux) values(#{tname},#{info},#{toux})")
    public int addTD(tuandui td);//新增团队

    @Update("update tuandui set tname = #{tname},info = #{info},toux = #{toux} where id = #{id}")
    public int updTD(tuandui td);//修改团队

    @Delete("delete from tuandui where id = #{id}")
    public int delTD(@Param("id")int id);//删除团队

    @Select("select * from jiudian")
    public List<jiudian> selectJD();//查询所有酒店

    @Select("select * from jiudian where id = #{id}")
    public jiudian selectJDById(@Param("id")int id);//根据酒店id查询单个酒店

    @Insert("insert into jiudian(guoid,jdname,info,tupian) values(#{guoid},#{jdname},#{info},#{tupian})")
    public int addJD(jiudian jd);//新增酒店

    @Update("update jiudian set guoid = #{guoid},jdname = #{jdname},info = #{info},tupian = #{tupian}")
    public int updJD(jiudian jd);//修改酒店

    @Delete("delete from jiudian where id = #{id}")
    public int delJD(@Param("id")int id);//删除酒店

    public List<guojialist> queryGJList(@Param("guoname")String guoname,@Param("pageNo")int pageNo,@Param("pageSize")int pageSize);//查询所有国家列表

    @Select("select * from guojialist where id = #{id}")
    public guojialist selectGJByid(@Param("id")int id);//根据国家id查询单个国家


    public int selectGJZS(@Param("guoname")String guoname);//查询旅游国家总数

    @Insert("insert into guojialist(zhouname,guoname,tpurl,shuxing) values(#{zhouname},#{guoname},#{tpurl},#{shuxing})")
    public int addGJList(guojialist gjl);//添加新国家

    @Update("update guojialist set zhouname = #{zhouname},guoname = #{guoname},tpurl = #{tpurl},shuxing = #{shuxing} where id = #{id}")
    public int updGJList(guojialist gjl);//修改国家

    @Delete("delete from guojialist where id = #{id}")
    public int delGJList(@Param("id")int id);//删除国家

    @Select("select * from lvyouxiangqing where guoid = #{guoid}")
    public lvyouxiangqing selectByGuoId(@Param("guoid")int guoid);//通过旅游国家id搜索旅游详情

    @Insert("insert into lvyouxiangqing(guoid,guoname,guotpurl,info,liangdian,feiyong,feiyongmingxi,gengduo) values(#{guoid},#{guoname},#{guotpurl},#{info},#{liangdian},#{feiyong},#{feiyongmingxi},#{gengduo})")
    public int addLYXQ(lvyouxiangqing lyxq);//添加旅游详情

    @Update("update lvyouxiangqing set guoid = #{guoid},guoname = #{guoname},guotpurl = #{guotpurl},info = #{info},liangdian = #{liangdian},feiyong = #{feiyong},feiyongmingxi = #{feiyongmingxi},gengduo = #{gengduo}")
    public int updLYXQ(lvyouxiangqing lyxq);//修改旅游详情

    @Delete("delete from lvyouxiangqing where guoid = #{guoid}")
    public int delLYXQ(@Param("guoid")int guoid);//根据旅游国家id删除旅游详情

    @Select("select * from jutixingcheng where guoid = #{guoid}")
    public List<jutixingcheng> selectJTXC(@Param("guoid")int guoid);//通过旅游国家id搜索具体行程

    @Insert("insert into jutixingcheng(guoid,xingcheng,xingchengurl,xingchengmiaoshu) values(#{guoid},#{xingcheng},#{xingchengurl},#{xinghengmiaoshu})")
    public int addJTXC(jutixingcheng jtxc);//添加具体行程

    @Update("update jutixingcheng set guoid = #{guoid},xingcheng = #{xingcheng},xingchengurl = #{xingchengurl},xingchengmiaoshu = #{xingchengmiaoshu}")
    public int updJTXC(jutixingcheng jtxc);//修改具体行程

    @Delete("delete from jutixingcheng where guoid = #{guoid}")
    public int delJTXC(@Param("guoid")int guoid);//通过旅游国家id删除行程

    @Select("select * from tupian")
    public List<tupian> selectTP();//搜索所有图片信息

    @Select("select * from tupian where id = #{id}")
    public tupian selectByTPId(@Param("id")int id);//根据id查询单个图片

    @Insert("insert into tupian(guoid,tpurl) values(#{guoid},#{tpurl})")
    public int addTP(tupian tp);//添加图片

    @Update("update tupian set guoid = #{guoid},tpurl = #{tpurl} where id = #{id}")
    public int updTP(tupian tp);//修改图片


}
