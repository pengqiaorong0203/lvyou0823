package com.newer.lvyou.service;

import com.newer.lvyou.domain.pingjia;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouTaipingjiaService {

    /**
     * 显示所有用户评价详细信息
     * @return
     */
    public List<pingjia> findAllpingjia();

    /**
     * 根据用户评价中的国家名字进行分页
     * @param guoname
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<pingjia> findAllpingjiaFenYe(@Param("guoname") String guoname,
                                             @Param("pageNo") int pageNo,
                                             @Param("pageSize") int pageSize);

    /**
     * 统计用户评价总数量
     * @return
     */
    public int pingjiaCount(@Param("guoname")String guoname);

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
}
