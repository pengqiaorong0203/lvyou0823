package com.newer.lvyou.service;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.tupian;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HouTaitupianService {

    /**
     * 显示所有图片信息;
     * @return
     */
    public List<tupian> findAlltupian();

    /**
     * 根据国家guoid进行分页
     * @param guoname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<tupian> findAllTuPianFenYe(@Param("guoname") String guoname,
                                           @Param("pageNo") Integer pageNo,
                                           @Param("pageSize") Integer pageSize);

    /**
     * 统计图片总数量
     * @return
     */
    public int tupianCount(@Param("guoname") String guoname);

    /**
     * 新增图片信息;
     * @param dingdan
     * @return
     */
    public int dingdanAdd(dingdan dingdan);

    /**
     *根据图片id删除图片信息
     * @param id
     * @return
     */
    public int tupianDelete(@Param("id") Integer id);

    /**
     * 根据图片id修改图片信息
     * @param dingdan
     * @return
     */
    public int dingdanUpdate(dingdan dingdan);

    /**
     * 根据图片id查询单条图片信息
     * @param id
     * @return
     */
    public dingdan tupianSelect(@Param("id") Integer id);
}
