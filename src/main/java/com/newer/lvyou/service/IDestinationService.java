package com.newer.lvyou.service;

import java.util.Date;
import java.util.List;
import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
import com.newer.lvyou.domain.jutixingcheng;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.pingjia;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.domain.tupian;

public interface IDestinationService {
	
	/**
	 * 查询所有国家信息信息
	 * 
	 * @return
	 */
	public List<lvyouxiangqing> query();

	/**
	 * 查询单条国家信息
	 * 
	 * @param id
	 * @return
	 */
	public lvyouxiangqing queryById(Integer id);
	
	/**
	 * 查询单天旅程信息
	 * 
	 * @param guoid
	 * @return
	 */
	public List<jutixingcheng> queryByGuoId(Integer guoid);
	

	/**
	 * 插入订单信息
	 * 
	 * @param dingdan
	 * @return
	 */
	public int add(dingdan dingdans);
	
	
	/**
	 * 修改订单信息
	 * @param dingdans
	 * @return
	 */
	public int update(dingdan dingdans);

	/**
	 * 删除订单信息
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 查询单条订单信息
	 * 
	 * @param id
	 * @return
	 */
	public dingdan queryByDingdanId(Integer id);
	
	/**
	 * 根据uid,下单时间查询单条订单信息
	 * 
	 * @param uid,xiadantime
	 * @return
	 */
	public dingdan queryByDingdan(Integer uid, Date xiadantime);
	
	/**
	 * 查询单条国家列表信息
	 * @param id
	 * @return
	 */
	public guojialist queryBylistId(Integer id);

	/**
	 * 查询单条国家图片信息
	 * @param guoid
	 * @return
	 */
	public List<tupian> queryBytpId(Integer guoid);
	
	/**
	 * 查询团队信息
	 * @return
	 */
	public List<tuandui> queryTuandui();
	
	/**
	 * 查询评价信息
	 * @return
	 */
	public List<pingjia> queryPingjia();
	
	/**
	 * 查询酒店所有信息
	 * @return
	 */
	public List<jiudian> queryJiudian();
	
	/**
	 * 查询单条酒店信息
	 * @param jiuid
	 * @return
	 */
	public List<jiudianxiangqing> queryByjdId(Integer jiuid);
}
