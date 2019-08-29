package com.newer.lvyou.service;

import com.newer.lvyou.domain.guojialist;
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
}
