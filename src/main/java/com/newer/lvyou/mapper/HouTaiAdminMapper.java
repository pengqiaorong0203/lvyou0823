package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaiAdminMapper {

    /**
     * 查询管理员用户名跟密码是否存在
     * @return
     */
    @Select("select id,name,pwd,level from admin where name=#{name} and pwd=#{pwd}")
    public admin findBynamePassword(@Param("name") String name, @Param("pwd")String pwd);

    /**
     * 查询管理员用户所有详细信息
     * @return
     */
    @Select("select * from admin")
    public List<admin> findAlladmin();

    /**
     * 管理员用户分页
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<admin> findAllAdminFenYe(@Param("name") String name,
                                         @Param("pageNo")Integer pageNo,
                                         @Param("pageSize")Integer pageSize);

    /**
     * 统计管理员数量
     * @return
     */
    /*@Select("select count(1) from admin")*/
    public int adminCount(@Param("name") String name);

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    @Delete("delete from admin where id=#{id}")
    public int adminDelete(@Param("id") Integer id);

    /**
     * 新增管理员人员信息
     * @param admin
     * @return
     */
    @Insert("insert into admin(name,pwd,level) values(#{name},#{pwd},#{level})")
    public int adminAdd(admin admin);

    /**
     * 根据用户名修改用户密码
     * @param name
     * @param pwd
     * @return
     */
    @Update("update admin set pwd=#{pwd} where name=#{name}")
    public int adminUpdate(@Param("name")String name,@Param("pwd")String pwd);

    /**
     *根据登录管理员id查询详细信息
     * @param id
     * @return
     */
    @Select("select * from admin where id=#{id}")
    public admin adminSelectOne(@Param("id")Integer id);

    @Select("select * from admin where name = #{name}")
    public admin selectAdminByUsername(@Param("name")String name);
}
