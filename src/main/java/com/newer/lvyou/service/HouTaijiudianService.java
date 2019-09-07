package com.newer.lvyou.service;

import com.newer.lvyou.domain.jiudian;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaijiudianService {

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
    public int jiudianAdd(jiudian jiudian);

    /**
     * 根据酒店id删除酒店信息
     * @param id
     * @return
     */
    public int jiudianDelete(Integer id);

    /**
     * 修改酒店id详细信息
     * @param jiudian
     * @return
     */
    public int jiudianUpdate(jiudian jiudian);

    /**
     * 统计酒店信息总数量
     * @return
     */
    public int jiudianCount(@Param("jdname") String jdname);
}
