package com.newer.lvyou.service.impl;

import java.util.Date;
import java.util.List;

import com.newer.lvyou.mapper.IDestinationMapper;
import com.newer.lvyou.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


@Service("DestinationService")
public class DestinationServiceImpl implements IDestinationService {

	
	@Autowired
	private IDestinationMapper destinationMapper;
	
	@Override
	public List<lvyouxiangqing> query() {
		return destinationMapper.query();
	}

	@Override
	public lvyouxiangqing queryById(Integer id) {
		return destinationMapper.queryById(id);
	}

	@Override
	public List<jutixingcheng> queryByGuoId(Integer guoid) {
		return destinationMapper.queryByGuoId(guoid);
	}

	@Override
	public int add(dingdan dingdans) {
		return destinationMapper.insert(dingdans);
	}

	@Override
	public int update(dingdan dingdans) {
		return destinationMapper.update(dingdans);
	}

	@Override
	public int delete(Integer id) {
		return destinationMapper.delete(id);
	}

	@Override
	public dingdan queryByDingdanId(Integer id) {
		return destinationMapper.queryByDingdanId(id);
	}

	@Override
	public dingdan queryByDingdan(Integer uid, Date xiadantime) {
		return destinationMapper.queryByDingdan(uid, xiadantime);
	}

	@Override
	public guojialist queryBylistId(Integer id) {
		return destinationMapper.queryBylistId(id);
	}

	@Override
	public List<tupian> queryBytpId(Integer guoid) {
		return destinationMapper.queryBytpId(guoid);
	}

	@Override
	public List<tuandui> queryTuandui() {
		return destinationMapper.queryTuandui();
	}

	@Override
	public List<pingjia> queryPingjia() {
		return destinationMapper.queryPingjia();
	}

	@Override
	public List<jiudian> queryJiudian() {
		return destinationMapper.queryJiudian();
	}

	@Override
	public List<jiudianxiangqing> queryByjdId(Integer jiuid) {
		return destinationMapper.queryByjdId(jiuid);
	}

}
