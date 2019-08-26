package com.newer.lvyou.service;

import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.tuandui;
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
}
