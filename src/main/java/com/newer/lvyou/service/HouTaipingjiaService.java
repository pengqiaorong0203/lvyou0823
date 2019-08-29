package com.newer.lvyou.service;

import com.newer.lvyou.domain.pingjia;

import java.util.List;

public interface HouTaipingjiaService {

    /**
     * 显示所有用户评价详细信息
     * @return
     */
    public List<pingjia> findAllpingjia();

    /**
     *新增用户评价信息
     * @param pingjia
     * @return
     */
    public int pingjiaAdd(pingjia pingjia);

    /**
     * 根据用户id删除用户评价信息
     * @param id
     * @return
     */
    public int pingjiaDelete(Integer id);

    /**
     * 修改用户评价详细信息
     * @param pingjia
     * @return
     */
    public int pinjiaUpdate(pingjia pingjia);

    /**
     * 统计用户评价总数量
     * @return
     */
    public int pingjiaCount();
}
