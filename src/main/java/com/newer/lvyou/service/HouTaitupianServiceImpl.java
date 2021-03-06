package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.tupian;
import com.newer.lvyou.mapper.HoutaiTupianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaitupianServiceImpl implements HouTaitupianService{

    @Autowired
    private HoutaiTupianMapper houtaiTupianMapper;

    /**
     * 显示所有图片信息
     * @return
     */
    @Override
    public List<tupian> findAlltupian() {
        return houtaiTupianMapper.findAlltupian();
    }

    /**
     * 根据国家guoid进行分页
     * @param guoname
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<tupian> findAllTuPianFenYe( String guoname, Integer pageNo, Integer pageSize) {
        return houtaiTupianMapper.findAllTuPianFenYe(guoname,pageNo,pageSize);
    }

    /**
     * 统计图片总数量
     * @param guoname
     * @return
     */
    @Override
    public int tupianCount(String guoname) {
        return houtaiTupianMapper.tupianCount(guoname);
    }

    /**
     * 新增图片信息
     * @param tupian
     * @return
     */
    @Override
    public int tupianAdd(tupian tupian) {
        return houtaiTupianMapper.tupianAdd(tupian);
    }

    /**
     * 根据图片id删除图片信息
     * @param id
     * @return
     */
    @Override
    public int tupianDelete(Integer id) {
        return houtaiTupianMapper.tupianDelete(id);
    }

    /**
     * 根据图片id修改图片信息
     * @param tupian
     * @return
     */
    @Override
    public int tupianUpdate(tupian tupian) {
        return houtaiTupianMapper.tupianUpdate(tupian);
    }

    /**
     * 根据图片id查询单条图片信息
     * @param id
     * @return
     */
    @Override
    public tupian tupianSelect(Integer id) {
        return houtaiTupianMapper.tupianSelect(id);
    }

    /**
     *动态查询所有国家名字
     * @return
     */
    @Override
    public List<guojialist> queryGuoJiaList() {
        return houtaiTupianMapper.queryGuoJiaList();
    }


}
