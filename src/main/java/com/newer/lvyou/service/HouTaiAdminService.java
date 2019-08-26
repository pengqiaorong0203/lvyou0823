package com.newer.lvyou.service;

import com.newer.lvyou.domain.admin;
import org.apache.ibatis.annotations.Param;


public interface HouTaiAdminService {

    /**
     * 查询用户名跟密码是否存在
     * @param name
     * @param pwd
     * @return
     */
    public admin findBynamePassword(@Param("name") String name, @Param("pwd") String pwd);
}
