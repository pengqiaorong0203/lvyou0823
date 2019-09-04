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
     * 管理员用户分页
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<admin> findAllAdminFenYe(String name, Integer pageNo, Integer pageSize) {
        return houTaiAdminMapper.findAllAdminFenYe(name,pageNo,pageSize);
    }

    /**
     * 统计管理员数量
     * @return
     */
    @Override
    public int adminCount(String name) {
        return houTaiAdminMapper.adminCount(name);
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

    /**
     * 根据用户名修改用户密码
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public int adminUpdate(String name, String pwd) {
        return houTaiAdminMapper.adminUpdate(name,pwd);
    }

    /**
     * 根据订单id查询单条订单信息
     * @param id
     * @return
     */
    @Override
    public admin adminSelectOne(Integer id) {
        return houTaiAdminMapper.adminSelectOne(id);
    }
}
