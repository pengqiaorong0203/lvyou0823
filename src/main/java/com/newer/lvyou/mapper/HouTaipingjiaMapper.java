package com.newer.lvyou.mapper;

import com.newer.lvyou.domain.pingjia;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouTaipingjiaMapper {

    /**
     * 显示所有用户评价详细信息
     * @return
     */
    @Select("select * from pingjia")
    public List<pingjia> findAllpingjia();

    /**
     *新增用户评价信息
     * @param pingjia
     * @return
     */
    @Insert("insert into pingjia(guoid,guoname,xiangqing,tupian,username) " +
            "values(#{guoid},#{guoname},#{xiangqing},#{tupian},#{username})")
    public int pingjiaAdd(pingjia pingjia);

    /**
     * 根据用户id删除用户评价信息
     * @param id
     * @return
     */
    @Delete("delete from pingjia where id=#{id}")
    public int pingjiaDelete(Integer id);

    /**
     * 修改用户评价详细信息
     * @param pingjia
     * @return
     */
    @Update("updata pingjia set guoid=#{guoid},guoname=#{guoname},xiangqing=#{xiangqing}," +
            "tupian=#{tupian},username=#{username} where id=#{id}")
    public int pinjiaUpdate(pingjia pingjia);

    /**
     * 统计用户评价总数量
     * @return
     */
    @Select("select count(*) from pingjia")
    public int pingjiaCount();
}
