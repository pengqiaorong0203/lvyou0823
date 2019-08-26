package com.newer.lvyou.service;

import com.newer.lvyou.domain.admin;
import com.newer.lvyou.mapper.HouTaiAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouTaiAdminServiceImpl implements HouTaiAdminService{


    @Autowired
    private HouTaiAdminMapper houTaiAdminMapper;

    /**
     * 查询用户名跟密码是否存在
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public admin findBynamePassword(String name, String pwd) {
        return houTaiAdminMapper.findBynamePassword(name,pwd);
    }
}
