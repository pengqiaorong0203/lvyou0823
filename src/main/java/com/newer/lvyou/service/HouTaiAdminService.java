package com.newer.lvyou.service;

import com.newer.lvyou.domain.admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HouTaiAdminService {

    /**
     * 查询用户名跟密码是否存在
     * @param name
     * @param pwd
     * @return
     */
    public admin findBynamePassword(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 查询管理员用户所有详细信息
     * @return
     */
    public List<admin> findAlladmin();

    /**
     * 统计管理员数量
     * @return
     */
    public int adminCount();

    /**
     * 删除管理员人员信息
     * @param id
     * @return
     */
    public int adminDelete(@Param("id") Integer id);

    /**
     * 新增管理员人员信息
     * @param admin
     * @return
     */
    public int adminAdd(admin admin);
}
