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
     * 根据用户姓名进行分页显示;
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<user> findAllUserFenYe(@Param("username") String username,
                                       @Param("pageNo")Integer pageNo,
                                       @Param("pageSize")Integer pageSize);

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
    public int userDelete(Integer id);

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    @Update("update user set username=#{username},phone=#{phone} where id=#{id}")
    public int userUpdate(user user);

    /**
     * 统计用户总数量
     * @return
     */
    public int userCount(@Param("username")String username);

    /**
     * 根据id查询单条用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public user findOneUser(Integer id);



    /**
     * 根据用户名以及密码查询用户
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from user where username=#{username} and pwd=#{pwd}")
    public user Login(@Param("username") String username,
                      @Param("pwd") String pwd);

    /**
     * 根据用户名查询用户
     * @param username
     * @param
     * @return
     */

    @Select("select * from user where username=#{username} ")
    public user getAdmin(@Param("username") String username);

    /**
     * 根据用户名修改用户密码
     * @param pwd
     * @param username
     * @return
     */
    @Update("update user set pwd=#{pwd} where username=#{username}")
    public  int updAdminsPwd(@Param("pwd")String pwd,
                             @Param("username") String username);
}
