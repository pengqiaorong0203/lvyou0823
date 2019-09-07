package com.newer.lvyou.service;

import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.mapper.HouTaijiudianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaijiudianServiceImpl implements HouTaijiudianService {

    @Autowired
    private HouTaijiudianMapper houTaijiudianMapper;

    /**
     * 根据酒店名字进行分页
     * @param jdname
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<jiudian> findAlljiudianFenYe(String jdname, int pageNo, int pageSize) {
        return houTaijiudianMapper.findAlljiudianFenYe(jdname,pageNo,pageSize);
    }

    /**
     *新增酒店信息
     * @param jiudian
     * @return
     */
    @Override
    public int jiudianAdd(jiudian jiudian) {
        return houTaijiudianMapper.jiudianAdd(jiudian);
    }

    /**
     *根据酒店id删除酒店信息
     * @param id
     * @return
     */
    @Override
    public int jiudianDelete(Integer id) {
        return houTaijiudianMapper.jiudianDelete(id);
    }

    /**
     *修改酒店id详细信息
     * @param jiudian
     * @return
     */
    @Override
    public int jiudianUpdate(jiudian jiudian) {
        return houTaijiudianMapper.jiudianUpdate(jiudian);
    }

    /**
     *统计酒店信息总数量
     * @param jdname
     * @return
     */
    @Override
    public int jiudianCount(String jdname) {
        return houTaijiudianMapper.jiudianCount(jdname);
    }
}
