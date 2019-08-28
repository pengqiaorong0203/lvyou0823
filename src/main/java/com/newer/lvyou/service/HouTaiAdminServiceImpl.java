package com.newer.lvyou.service;

import com.newer.lvyou.domain.admin;
import com.newer.lvyou.mapper.HouTaiAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询管理员用户所有详细信息
     * @return
     */
    @Override
    public List<admin> findAlladmin() {
        return houTaiAdminMapper.findAlladmin();
    }

    /**
     * 统计管理员数量
     * @return
     */
    @Override
    public int adminCount() {
        return houTaiAdminMapper.adminCount();
    }

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    @Override
    public int adminDelete(Integer id) {
        return houTaiAdminMapper.adminDelete(id);
    }

    /**
     * 新增管理员人员信息
     * @param admin
     * @return
     */
    @Override
    public int adminAdd(admin admin) {
        return houTaiAdminMapper.adminAdd(admin);
    }
}
