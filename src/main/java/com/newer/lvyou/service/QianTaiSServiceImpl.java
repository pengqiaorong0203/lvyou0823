package com.newer.lvyou.service;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.user;
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

    @Override
    public List<guojialist> selectAllzn() {
        return qianTaiMapper.selectAllzn();
    }

    @Override
    public int userAdds(user user) {
        return qianTaiMapper.userAdds(user);
    }

    @Override
    public user Login(String username, String pwd) {
        return qianTaiMapper.Login(username,pwd);
    }

    @Override
    public user getAdmin(String username) {
        return qianTaiMapper.getAdmin(username);
    }

    @Override
    public int updAdminsPwd(String pwd, String username) {
        return qianTaiMapper.updAdminsPwd(pwd,username);
    }

    @Override
    public int userAdde(user user) {
        return qianTaiMapper.userAdde(user);
    }

    @Override
    public List<dingdan> selectDingdanByUid(int uid, Integer pageNo, Integer pageSize) {
        return qianTaiMapper.selectDingdanByUid(uid,pageNo,pageSize);
    }

    @Override
    public int countDingdanByUid(int uid) {
        return qianTaiMapper.countDingdanByUid(uid);
    }

}
