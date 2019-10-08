package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
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
    public List<jiudian> findAlljiudianFenYe(String jdname,int pageNo, int pageSize) {
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

    /**
     * 动态加载所有酒店名字
     * @return
     */
    @Override
    public List<jiudianxiangqing> jiudianxiangqingList() {
        return houTaijiudianMapper.jiudianxiangqingList();
    }

    /**
     * 动态加载所有国家ID
     * @return
     */
    @Override
    public List<guojialist> jiudianID() {
        return houTaijiudianMapper.jiudianID();
    }

    /**
     * 查询单条酒店信息
     * @param id
     * @return
     */
    @Override
    public List<jiudianxiangqing> jiudianxiangqingOne(Integer id) {
        return houTaijiudianMapper.jiudianxiangqingOne(id);
    }

    /**
     * 联动查询国家ID跟国家名字
     * @param id
     * @return
     */
    @Override
    public String findOneJiuDian(Integer id) {
        return houTaijiudianMapper.findOneJiuDian(id);
    }

    /**
     *根据酒店ID查询单条酒店信息
     * @param id
     * @return
     */
    @Override
    public jiudian findOneJiuDianInfo(Integer id) {
        return houTaijiudianMapper.findOneJiuDianInfo(id);
    }
}
