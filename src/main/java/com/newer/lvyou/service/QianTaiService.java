package com.newer.lvyou.service;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QianTaiService {

    public List<guojialist> selectGJByZname(@Param("zhouname")String zhouname); //根据洲名字便利国家

    public guojialist selectGJByid(@Param("id")int id); //根据id拿值

    public List<guojialist> selectAllGJ();

    public List<guojialist> selectGJ6();

    public List<lvyouxiangqing> selectlvxiang6();

    public List<guojialist> selectAllzn();

    public int userAdds(user user);
    /**
     * 根据用户名以及密码查询用户
     * @param username
     * @param pwd
     * @return
     */
    public user Login(@Param("username") String username,
                      @Param("pwd") String pwd);

    /**
     * 根据用户名查询用户
     * @param username
     * @param
     * @return
     */

    public user getAdmin(@Param("username") String username);

    /**
     * 根据用户名修改用户密码
     * @param pwd
     * @param username
     * @return
     */
    public  int updAdminsPwd(@Param("pwd")String pwd,
                             @Param("username") String username);


    /**
     * 会员用户添加
     * @param user
     * @return
     */
    public int userAdde(user user);

    public List<dingdan> selectDingdanByUid(@Param("uid")int uid,
                                            @Param("pageNo")Integer pageNo,
                                            @Param("pageSize")Integer pageSize);

    public int countDingdanByUid(@Param("uid")int uid);
}
