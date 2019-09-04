package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.mapper.QianTaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QianTaiSServiceImpl implements QianTaiService{

    @Autowired
    private QianTaiMapper qianTaiMapper;

    @Override
    public List<guojialist> selectGJByZname(String zhouname) {
        return qianTaiMapper.selectGJByZname(zhouname);
    }

    @Override
    public guojialist selectGJByid(int id) {
        return qianTaiMapper.selectGJByid(id);
    }

    @Override
    public List<guojialist> selectAllGJ() {
        return qianTaiMapper.selectAllGJ();
    }

    @Override
    public List<guojialist> selectGJ6() {
        return qianTaiMapper.selectGJ6();
    }

    @Override
    public List<lvyouxiangqing> selectlvxiang6() {
        return qianTaiMapper.selectlvxiang6();
    }
}
