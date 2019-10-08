package com.newer.lvyou.service;

import com.newer.lvyou.domain.user;
import com.newer.lvyou.mapper.HouTaiUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouTaiuserServiceImpl implements HouTaiuserService{

    @Autowired
    private HouTaiUserMapper houTaiUserMapper;

    /**
     * 显示所有用户以及信息
     * @return
     */
    @Override
    public List<user> findAllUser() {
        return houTaiUserMapper.findAllUser();
    }

    /**
     * 根据用户姓名进行分页显示
     * @param username
     * @param pageNO
     * @param pageSize
     * @return
     */
    @Override
    public List<user> findAllUserFenYe(String username, Integer pageNO, Integer pageSize) {
        return houTaiUserMapper.findAllUserFenYe(username,pageNO,pageSize);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @Override
    public int userAdd(user user) {
        return houTaiUserMapper.userAdd(user);
    }

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    @Override
    public int userDelete(Integer id) {
        return houTaiUserMapper.userDelete(id);
    }

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    @Override
    public int userUpdate(user user) {
        return houTaiUserMapper.userUpdate(user);
    }

    /**
     * 统计用户总数量
     * @return
     */
    @Override
    public int userCount(String username) {
        return houTaiUserMapper.userCount(username);
    }

    /**
     * 根据id查询单条用户信息
     * @param id
     * @return
     */
    @Override
    public user findOneUser(Integer id) {
        return houTaiUserMapper.findOneUser(id);
    }

    @Override
    public user login(String userename, String pwd) {
        return houTaiUserMapper.Login(userename,pwd);
    }

    @Override
    public user getAdmin(String username) {
        return houTaiUserMapper.getAdmin(username);
    }

    @Override
    public int updAdminsPwd(String pwd, String username) {
        return houTaiUserMapper.updAdminsPwd(pwd,username);
    }
}
