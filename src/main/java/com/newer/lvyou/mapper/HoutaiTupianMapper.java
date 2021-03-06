package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.tupian;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoutaiTupianMapper {

    /**
     * 显示所有图片信息;
     * @return
     */
    @Select("select * from tupian")
    public List<tupian> findAlltupian();

    /**
     * 根据国家guoid进行分页
     * @param guoname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<tupian> findAllTuPianFenYe(@Param("guoname")String guoname,
                                             @Param("pageNo") Integer pageNo,
                                             @Param("pageSize") Integer pageSize);

    /**
     * 统计图片总数量
     * @return
     */
    public int tupianCount(@Param("guoname") String guoname);

    /**
     * 新增图片信息;
     * @param tupian
     * @return
     */
    @Insert("insert into tupian(guoid,tpurl) values(#{guoid},#{tpurl})")
    @SelectKey(statement="select max(id) from tupian", keyProperty="id", before=false, resultType=int.class)
    /*@Insert("insert into tupian(guoid,tpurl) values((select guojialist.id from guojialist where guoname=#{guoname}),#{tpurl})")*/
    public int tupianAdd(tupian tupian);

    /**
     *根据图片id删除图片信息
     * @param id
     * @return
     */
    @Delete("delete from tupian where id=#{id}")
    public int tupianDelete(@Param("id") Integer id);

    /**
     * 根据图片id修改图片信息
     * @param tupian
     * @return
     */
    @Update("update tupian set guoid=#{guoid},tpurl=#{tpurl} where id=#{id}")
    public int tupianUpdate(tupian tupian);

    /**
     * 根据图片id查询单条图片信息
     * @param id
     * @return
     */
    @Select("SELECT t.id,t.guoid,t.tpurl,g.guoname FROM tupian t,guojialist g WHERE t.guoid = g.id AND t.id = #{id}")
    /*@Select("select * from tupian where id=#{id}")*/
    public tupian tupianSelect(@Param("id") Integer id);

    /**
     * 动态查询所有国家名字
     * @return
     */
    @Select("select id,guoname from guojialist")
    public List<guojialist> queryGuoJiaList();

}
