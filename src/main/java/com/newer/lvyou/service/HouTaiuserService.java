package com.newer.lvyou.service;

import com.newer.lvyou.domain.user;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface HouTaiuserService {

    /**
     * 显示所有用户以及信息
     * @return
     */
    public List<user> findAllUser();

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    public int userAdd(user user);

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    public int userDelete(@Param("id") Integer id);

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    public int userUpdate(user user);

    /**
     * 统计用户总数量
     * @return
     */
    public int userCount();
}
