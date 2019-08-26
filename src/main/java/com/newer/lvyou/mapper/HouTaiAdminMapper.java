package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface HouTaiAdminMapper {

    /**
     * 查询用户名跟密码是否存在
     * @return
     */
    @Select("select id,name,pwd from admin where name=#{name} and pwd=#{pwd}")
    public admin findBynamePassword(@Param("name") String name, @Param("pwd") String pwd);


}
