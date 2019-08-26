package com.newer.lvyou.service;

import com.newer.lvyou.domain.*;
import com.newer.lvyou.mapper.HoutaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaiServiceImpl implements HouTaiService {

    @Autowired
    private HoutaiMapper houtaiMapper;

    @Override
    public List<tuandui> selectTD() {
        return houtaiMapper.selectTD();
    }

    @Override
    public int addTD(tuandui td) {
        return houtaiMapper.addTD(td);
    }

    @Override
    public int updTD(tuandui td) {
        return houtaiMapper.updTD(td);
    }

    @Override
    public int delTD(int id) {
        return houtaiMapper.delTD(id);
    }

    @Override
    public List<jiudian> selectJD() {
        return houtaiMapper.selectJD();
    }

    @Override
    public int addJD(jiudian jd) {
        return houtaiMapper.addJD(jd);
    }

    @Override
    public int updJD(jiudian jd) {
        return houtaiMapper.updJD(jd);
    }

    @Override
    public int delJD(int id) {
        return houtaiMapper.delJD(id);
    }

    @Override
    public List<guojialist> queryGJList() {
        return houtaiMapper.queryGJList();
    }

    @Override
    public int addGJList(guojialist gjl) {
        return houtaiMapper.addGJList(gjl);
    }

    @Override
    public int updGJList(guojialist gjl) {
        return houtaiMapper.updGJList(gjl);
    }

    @Override
    public int delGJList(int id) {
        return houtaiMapper.delGJList(id);
    }

    @Override
    public lvyouxiangqing selectByGuoId(int guoid) {
        return houtaiMapper.selectByGuoId(guoid);
    }

    @Override
    public int addLYXQ(lvyouxiangqing lyxq) {
        return houtaiMapper.addLYXQ(lyxq);
    }

    @Override
    public int updLYXQ(lvyouxiangqing lyxq) {
        return houtaiMapper.updLYXQ(lyxq);
    }

    @Override
    public int delLYXQ(int guoid) {
        return houtaiMapper.delLYXQ(guoid);
    }

    @Override
    public List<jutixingcheng> selectJTXC(int guoid) {
        return houtaiMapper.selectJTXC(guoid);
    }

    @Override
    public int addJTXC(jutixingcheng jtxc) {
        return houtaiMapper.addJTXC(jtxc);
    }

    @Override
    public int updJTXC(jutixingcheng jtxc) {
        return houtaiMapper.updJTXC(jtxc);
    }

    @Override
    public int delJTXC(int guoid) {
        return houtaiMapper.delJTXC(guoid);
    }

    @Override
    public List<tupian> selectTP() {
        return houtaiMapper.selectTP();
    }

    @Override
    public tupian selectByTPId(int id) {
        return houtaiMapper.selectByTPId(id);
    }

    @Override
    public int addTP(tupian tp) {
        return houtaiMapper.addTP(tp);
    }

    @Override
    public int updTP(tupian tp) {
        return houtaiMapper.updTP(tp);
    }

    @Override
    public tuandui selectTDById(int id) {
        return houtaiMapper.selectTDById(id);
    }

    @Override
    public jiudian selectJDById(int id) {
        return houtaiMapper.selectJDById(id);
    }

    @Override
    public guojialist selectGJByid(int id) {
        return houtaiMapper.selectGJByid(id);
    }
}
