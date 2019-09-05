package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.tuandui;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaiTeamMapper {

    /**
     * 显示所有团队以及信息
     * @return
     */
    @Select("select * from tuandui")
    public List<tuandui> findAllTuandui();

    /**
     * 根据团队姓名进行分页显示;
     * @param tname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<tuandui> findAllTuanDuiFenYe(@Param("tname") String tname,
                                          @Param("pageNo") Integer pageNo,
                                          @Param("pageSize") Integer pageSize);

    /**
     * 新增用户信息
     * @param tuandui
     * @return
     */
    @Insert("insert into tuandui(tname,info,toux) values(#{tname},#{info},#{toux})")
    public int tuanduiAdd(tuandui tuandui);

    /**
     * 根据团队id删除团队信息
     * @param id
     * @return
     */
    @Delete("delete from tuandui where id=#{id}")
    public int tuanduiDelete(Integer id);

    /**
     * 修改单个团队信息
     * @param tuandui
     * @return
     */
    @Update("update tuandui set tname=#{tname},info=#{info},toux=#{toux} where id=#{id}")
    public int tuanduiUpdate(tuandui tuandui);

    /**
     * 统计团队总数量
     * @return
     */
    public int tuanduiCount(@Param("tname") String tname);

    /**
     * 根据id查询单个团队信息
     * @param id
     * @return
     */
    @Select("select * from tuandui where id=#{id}")
    public tuandui findOneTuandui(Integer id);
}
