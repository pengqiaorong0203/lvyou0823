package com.newer.lvyou.service;

import com.newer.lvyou.domain.pingjia;
import com.newer.lvyou.mapper.HouTaipingjiaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaipingjiaServiceImpl implements HouTaipingjiaService{

    @Autowired
    private HouTaipingjiaMapper houTaipingjiaMapper;

    /**
     * 显示所有用户评价详细信息
     * @return
     */
    @Override
    public List<pingjia> findAllpingjia() {
        return houTaipingjiaMapper.findAllpingjia();
    }

    /**
     * 根据用户评价中的国家名字进行分页
     * @param guoname
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<pingjia> findAllpingjiaFenYe(String guoname, int pageNo, int pageSize) {
        return houTaipingjiaMapper.findAllpingjiaFenYe(guoname,pageNo,pageSize);
    }

    /**
     * 统计用户评价总数量
     * @return
     */
    @Override
    public int pingjiaCount(String guoname) {
        return houTaipingjiaMapper.pingjiaCount(guoname);
    }

    /**
     * 新增用户评价信息
     * @param pingjia
     * @return
     */
    @Override
    public int pingjiaAdd(pingjia pingjia) {
        return houTaipingjiaMapper.pingjiaAdd(pingjia);
    }

    /**
     * 根据用户id删除用户评价信息
     * @param id
     * @return
     */
    @Override
    public int pingjiaDelete(Integer id) {
        return houTaipingjiaMapper.pingjiaDelete(id);
    }

    /**
     * 修改用户评价详细信息
     * @param pingjia
     * @return
     */
    @Override
    public int pinjiaUpdate(pingjia pingjia) {
        return houTaipingjiaMapper.pinjiaUpdate(pingjia);
    }

}
