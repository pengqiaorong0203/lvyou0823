package com.newer.lvyou.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
import com.newer.lvyou.domain.jutixingcheng;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.pingjia;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.domain.tupian;

@Repository("DestinationMapper")
@CacheNamespace(implementation = com.newer.lvyou.config.RedisCache.class)
public interface IDestinationMapper {
	
	/**
	 * 查询所有国家信息
	 * @return
	 */
	@Select("select * from lvyouxiangqing")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "guoid",column = "GUOID"),
		@Result(property = "guoname",column = "GUONAME"),
		@Result(property = "guotpurl",column = "GUOTPURL"),
		@Result(property = "info",column = "INFO"),
		@Result(property = "liangdian",column = "LIANGDIAN"),
		@Result(property = "feiyong",column = "FEIYONG"),
		/*@Result(property = "feiyongmingxi",column = "FEIYONGMINGXI"),*/
		/*@Result(property = "gengduo",column = "GENGDUO"),
		@Result(property = "zstpurl",column = "ZSTPURL"),
		@Result(property = "tpurl",column = "TPURL")*/
	})
	public List<lvyouxiangqing> query();
	
	/**
	 * 查询单条国家信息
	 * @param cid
	 * @return
	 */
	@Select("select id,guoid,guoname,guotpurl,info,liangdian,feiyong,feiyongmingxi,gengduo,zstpurl,tpurl from lvyouxiangqing where id=#{id}")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "guoid",column = "GUOID"),
		@Result(property = "guoname",column = "GUONAME"),
		@Result(property = "guotpurl",column = "GUOTPURL"),
		@Result(property = "info",column = "INFO"),
		@Result(property = "liangdian",column = "LIANGDIAN"),
		@Result(property = "feiyong",column = "FEIYONG"),
		@Result(property = "feiyongmingxi",column = "FEIYONGMINGXI"),
		@Result(property = "gengduo",column = "GENGDUO"),
		@Result(property = "zstpurl",column = "ZSTPURL"),
		@Result(property = "tpurl",column = "TPURL")
	})
	public lvyouxiangqing queryById(Integer id);
	
	
	/**
	 * 查询指定国家下所有信息
	 * @param guoid
	 * @return
	 */
	@Select("select id,guoid,xingcheng,xingchengmiaoshu from jutixingcheng where guoid=#{guoid}")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "guoid",column = "GUOID"),
		@Result(property = "xingcheng",column = "XINGCHENG"),
		@Result(property = "xingchengmiaoshu",column = "XINGCHENGMIAOSHU")
	})
	public  List<jutixingcheng> queryByGuoId(Integer guoid);
	
	/**
	 * 查询单条订单信息
	 * @param id
	 * @return
	 */
	@Select("select id,uid,uname,phone,email,time,chengren,ertong,info,state,jiuid,xiadantime,feiyong,guoid from dingdan where id=#{id}")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "uid",column = "UID"),
		@Result(property = "uname",column = "UNAME"),
		@Result(property = "phone",column = "PHONE"),
		@Result(property = "email",column = "EMAIL"),
		@Result(property = "time",column = "TIME"),
		@Result(property = "chengren",column = "CHENGREN"),
		@Result(property = "ertong",column = "ERTONG"),
		@Result(property = "info",column = "INFO"),
		@Result(property = "state",column = "STATE"),
		@Result(property = "jiuid",column = "JIUID"),
		@Result(property = "xiadantime",column = "XIADANTIME"),
		@Result(property = "feiyong",column = "FEIYONG"),
		@Result(property = "guoid",column = "GUOID")
	})
	public dingdan queryByDingdanId(Integer id);
	
	/**
	 * 插入订单信息
	 * @return
	 */
	@Insert("insert into dingdan(uid,uname,phone,email,time,chengren,ertong,info,state,jiuid,xiadantime,feiyong,guoid) values(#{uid},#{uname},#{phone},#{email},#{time},#{chengren},#{ertong},#{info},#{state},#{jiuid},#{xiadantime},#{feiyong},#{guoid})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",keyColumn = "id",before = false,resultType = Integer.class)
	public int insert(dingdan dingdans);

	/**
	 * 修改订单支付状态
	 * @param dingdans
	 * @return
	 */
	@Update("update dingdan set state=1 where id=#{id}")
	public int update(dingdan dingdans);
	

	/**
	 *删除订单信息
	 * @param id
	 * @return
	 */
	@Delete("delete from dingdan where id=#{id}")
	public int delete(Integer id);

	/**
	 * 查询单条国家列表信息
	 * @param id
	 * @return
	 */
	@Select("select id,zhouname,guoname,tpurl,shenhe from guojialist where id=#{id} and shenhe=1")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "zhouname",column = "ZHOUNAME"),
		@Result(property = "guoname",column = "GUONAME"),
		@Result(property = "tpurl",column = "TPURL"),
		@Result(property = "shenhe",column = "SHENHE")
	})
	public guojialist queryBylistId(Integer id);
	
	/**
	 * 查询单条国家图片信息
	 * @param guoid
	 * @return
	 */
	@Select("select tpurl from tupian where guoid=#{guoid} and shenhe=1")
	@Results({
		@Result(property = "tpurl",column = "TPURL")
	})
	public List<tupian> queryBytpId(Integer guoid);
	
	/**
	 * 查询团队信息
	 * @param 
	 * @return
	 */
	@Select("select * from tuandui where shenhe=1")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "tname",column = "TNAME"),
		@Result(property = "info",column = "INFO"),
		@Result(property = "toux",column = "TOUX"),
		@Result(property = "shenhe",column = "SHENHE")
	})
	public List<tuandui> queryTuandui();
	
	/**
	 * 查询评价信息
	 * @param 
	 * @return
	 */
	@Select("select * from pingjia where shenhe=1")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "guoid",column = "GUOID"),
		@Result(property = "guoname",column = "GUONAME"),
		@Result(property = "xiangqing",column = "XIANGQING"),
		@Result(property = "tupian",column = "TUPIAN"),
		@Result(property = "username",column = "USERNAME"),
		@Result(property = "shenhe",column = "SHENHE"),
	})
	public List<pingjia> queryPingjia();
	
	/**
	 * 查询酒店所有信息
	 * @param 
	 * @return
	 */
	@Select("select * from jiudian where shenhe=1")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "guoid",column = "GUOID"),
		@Result(property = "jdname",column = "JDNAME"),
		@Result(property = "info",column = "XIANGQING"),
		@Result(property = "tupian",column = "TUPIAN"),
		@Result(property = "shenhe",column = "SHENHE"),
		@Result(property = "jiage",column = "JIAGE"),
	})
	public List<jiudian> queryJiudian();
	
	
	/**
	 * 查询单条酒店信息
	 * @param jiuid
	 * @return
	 */
	@Select("select * from jiudianxiangqing where jiuid=#{jiuid}")
	@Results({
		@Result(property = "id",column = "ID"),
		@Result(property = "jiuid",column = "JIUID"),
		@Result(property = "jdtupian",column = "JDTUPIAN"),
		@Result(property = "jdname",column = "JDNAME"),
		@Result(property = "info",column = "INFO"),
		@Result(property = "tpurl",column = "TPURL")
	})
	public List<jiudianxiangqing> queryByjdId(Integer jiuid);
}
