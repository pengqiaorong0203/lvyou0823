package com.newer.lvyou.service;

import com.newer.lvyou.domain.tuandui;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaiteamService {

    /**
     * 显示所有团队以及信息
     * @return
     */
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
    public int tuanduiAdd(tuandui tuandui);

    /**
     * 根据团队id删除团队信息
     * @param id
     * @return
     */
    public int tuanduiDelete(Integer id);

    /**
     * 修改单个团队信息
     * @param tuandui
     * @return
     */
    public int userUpdate(tuandui tuandui);

    /**
     * 统计团队总数量
     * @return
     */
    public int tuanduiCount(@Param("tname")  String tname);

    /**
     * 根据id查询单个团队信息
     * @param id
     * @return
     */
    public tuandui findOneTuandui(Integer id);
}
