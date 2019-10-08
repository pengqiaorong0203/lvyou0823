package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QianTaiMapper {

    @Select("select * from guojialist where zhouname = #{zhouname}")
    public List<guojialist> selectGJByZname(@Param("zhouname")String zhouname); //根据洲名字便利国家

    @Select("select * from guojialist where  id= #{id}")
    public guojialist selectGJByid(@Param("id")int id); //根据id拿值

    @Select("select * from guojialist ")
    public List<guojialist> selectAllGJ();

    @Select("SELECT * FROM guojialist WHERE shenhe='1' LIMIT 8 ")
    public List<guojialist> selectGJ6(); //取前8条数据

    @Select("SELECT * FROM lvyouxiangqing  LIMIT 6 ")
    public List<lvyouxiangqing> selectlvxiang6(); //取前6条数据

    @Select("SELECT DISTINCT zhouname FROM guojialist  ")
    public List<guojialist> selectAllzn(); //根据洲名字分类便利洲名

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @Insert("insert into user(username,pwd,phone,sex) values(#{username},#{pwd},#{phone},#{sex})")
    public int userAdds(user user);
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


    /**
     * 会员用户添加
     * @param user
     * @return
     */
    @Insert("insert into user(username,pwd,phone,sex) values(#{username},#{pwd},#{phone},#{sex})")
    public int userAdde(user user);

    @Select("select * from dingdan where uid = #{uid} limit #{pageNo},#{pageSize}")
    public List<dingdan> selectDingdanByUid(@Param("uid")int uid,
                                            @Param("pageNo")Integer pageNo,
                                            @Param("pageSize")Integer pageSize);

    @Select("select count(*) from dingdan where uid = #{uid}")
    public int countDingdanByUid(@Param("uid")int uid);
}
