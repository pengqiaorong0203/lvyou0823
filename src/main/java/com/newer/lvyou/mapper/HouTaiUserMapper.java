package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaiUserMapper {

    /**
     * 显示所有用户以及信息
     * @return
     */
    @Select("select * from user")
    public List<user> findAllUser();

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @Insert("insert into user(username,pwd,phone,sex) values(#{username},#{pwd},#{phone},#{sex})")
    public int userAdd(user user);

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    public int userDelete(@Param("id") Integer id);

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    @Update("updata user set username=#{username},pwd=#{pwd},phone=#{phone},sex=#{sex} where id=#{id}")
    public int userUpdate(user user);

    /**
     * 统计用户总数量
     * @return
     */
    @Select("select count(*) from user")
    public int userCount();
}
