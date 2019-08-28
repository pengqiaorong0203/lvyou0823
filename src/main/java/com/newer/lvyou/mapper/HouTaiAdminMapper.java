package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaiAdminMapper {

    /**
     * 查询管理员用户名跟密码是否存在
     * @return
     */
    @Select("select id,name,pwd from admin where name=#{name} and pwd=#{pwd}")
    public admin findBynamePassword(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 查询管理员用户所有详细信息
     * @return
     */
    @Select("select * from admin")
    public List<admin> findAlladmin();

    /**
     * 统计管理员数量
     * @return
     */
    @Select("select count(1) from admin")
    public int adminCount();

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
    @Insert("insert into admin(name,pwd,grade) values(#{name},#{pwd},#{grade})")
    public int adminAdd(admin admin);
}
