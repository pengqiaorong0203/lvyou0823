package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
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

    /**
     * 动态加载所有酒店名字
     * @return
     */
    public List<jiudianxiangqing> jiudianxiangqingList();

    /**
     * 动态加载所有国家ID
     * @return
     */
    public List<guojialist> jiudianID();

    /**
     * 查询单条酒店信息
     * @param id
     * @return
     */
    public List<jiudianxiangqing> jiudianxiangqingOne(Integer id);

    /**
     * 联动查询国家ID跟国家名字
     * @param id
     * @return
     */
    public String findOneJiuDian(Integer id);

    /**
     *根据酒店ID查询单条酒店信息
     * @param id
     * @return
     */
    public jiudian findOneJiuDianInfo(Integer id);
}
