package com.newer.lvyou.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.newer.lvyou.service.IDestinationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
import com.newer.lvyou.domain.jutixingcheng;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.pingjia;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.domain.tupian;

/**
 * 控制器
 * 
 * @author
 *
 */
@RestController
@RequestMapping("/api")
public class DestinationController {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@Resource(name = "DestinationService")
	private IDestinationService DestinationService;

	/**
	 * 得到所有国家信息
	 * 
	 * @return
	 */
	@GetMapping("/destination")
	public ResponseEntity<?> query() {
		log.info("开始检索所有国家信息......");

		List<lvyouxiangqing> lvyouxiangqings = DestinationService.query();

		log.info("检索完成");
		ResponseEntity<List<lvyouxiangqing>> res = new ResponseEntity<List<lvyouxiangqing>>(lvyouxiangqings,
				HttpStatus.OK);
		return res;

	}

	/**
	 * 查询单条国家信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/destination/{id}")
	public ResponseEntity<?> query(@PathVariable("id") Integer id) {
		log.info("开始检索指定国家信息.......");
		
		// 首先检查该国家是否存在
		lvyouxiangqing lvyouxiangqingx = DestinationService.queryById(id);
		if (lvyouxiangqingx == null) {
			return new ResponseEntity<>("没找着国家:" + id + "的国家信息", HttpStatus.NOT_FOUND);
		}
		
		log.info("检索完成");
		return new ResponseEntity<lvyouxiangqing>(lvyouxiangqingx, HttpStatus.OK);
	}

	/**
	 * 查询指定国家下所有旅程信息
	 * 
	 * @param guoid
	 * @return
	 */
	@GetMapping("/destinations/{guoid}")
	public ResponseEntity<?> queryGuoid(@PathVariable("guoid") Integer guoid) {
		log.info("开始检索指定国家下所有旅程信息.......");
		List<jutixingcheng> jutixingchengs = DestinationService.queryByGuoId(guoid);
		if (jutixingchengs == null) {
			return new ResponseEntity<>("查询的指定国家下不存在,国家号:" + guoid, HttpStatus.NOT_FOUND);
		}
		log.info("检索完成");
		ResponseEntity<List<jutixingcheng>> res = new ResponseEntity<List<jutixingcheng>>(jutixingchengs,
				HttpStatus.OK);
		return res;
	}

	/**
	 * 查询单条订单信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		log.info("开始检索指定订单信息.......");
		
		// 首先检查该订单是否存在
		dingdan dingdanx = DestinationService.queryByDingdanId(id);
		if (dingdanx == null) {
			return new ResponseEntity<>("查询的订单不存在,订单号:" + id, HttpStatus.NOT_FOUND);
		}
		log.info("检索完成");
		return new ResponseEntity<dingdan>(dingdanx, HttpStatus.OK);
	}

	/**
	 * 新增订单
	 *
	 * @param dingdan
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody dingdan dingdan) {
		log.info("开始创建订单信息.....");

		Integer i = DestinationService.add(dingdan);
		System.out.println(dingdan);
		String str = "预定失败";
		if (i > 0) {
			return new ResponseEntity<>(dingdan, HttpStatus.CREATED);
		}
		log.info("创建完成");
		return new ResponseEntity<>(str, HttpStatus.CREATED);

	}

	/**
	 * 修改订单支付状态
	 * 
	 * @param dingdans
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody dingdan dingdans) {
		log.info("开始修改订单支付状态......");

		Integer i = DestinationService.update(dingdans);

		String str = "支付失败";
		if (i > 0) {
			str = "支付成功";
		}
		return new ResponseEntity<>(str, HttpStatus.OK);

	}

	/**
	 * 取消订单
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		log.info("开始取消订单......");

		// 首先检查该订单是否存在
		dingdan dingdanx = DestinationService.queryByDingdanId(id);
		if (dingdanx == null) {
			return new ResponseEntity<>("要取消的订单不存在,订单号:" + id, HttpStatus.NOT_FOUND);
		}

		Integer i = DestinationService.delete(id);
		String str = "取消失败";
		if (i > 0) {
			str = "取消成功";
		}
		log.info("取消结果:", i);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	/**
	 * 查询单条国家列表信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/list/{id}")
	public ResponseEntity<?> querylist(@PathVariable("id") Integer id) {
		log.info("开始检索指定国家列表信息.......");
		
		// 首先检查该国家是否存在
		guojialist guojialistx = DestinationService.queryBylistId(id);
		if (guojialistx == null) {
			return new ResponseEntity<>("没找着国家列表中:" + id + "的国家信息", HttpStatus.NOT_FOUND);
		}
		
		log.info("检索完成");
		return new ResponseEntity<guojialist>(guojialistx, HttpStatus.OK);
	}
	
	/**
	 * 查询单条国家图片信息
	 * 
	 * @param guoid
	 * @return
	 */
	@GetMapping("/tp/{guoid}")
	public ResponseEntity<?> querytp(@PathVariable("guoid") Integer guoid) {
		log.info("开始检索指定国家图片信息.......");
		
		// 首先检查该国家是否存在
		List<tupian> tupianx = DestinationService.queryBytpId(guoid);
		if (tupianx == null) {
			return new ResponseEntity<>("没找着图片中:" + guoid + "的国家图片信息", HttpStatus.NOT_FOUND);
		}
		
		log.info("检索完成");
		return new ResponseEntity<List<tupian>>(tupianx, HttpStatus.OK);
	}

	
	/**
	 * 得到团队信息
	 * 
	 * @return
	 */
	@GetMapping("/tuandui")
	public ResponseEntity<?> queryTuandui() {
		log.info("开始检索团队信息......");

		List<tuandui> tuanduis =  DestinationService.queryTuandui();

		log.info("检索完成");
		return new ResponseEntity<List<tuandui>>(tuanduis,HttpStatus.OK);
		 

	}
	
	/**
	 * 查询评价信息
	 * 
	 * @return
	 */
	@GetMapping("/pingjia")
	public ResponseEntity<?> queryPingjia() {
		log.info("开始检索评价信息......");

		List<pingjia> pingjiax =  DestinationService.queryPingjia();

		log.info("检索完成"); 
		return new ResponseEntity<List<pingjia>>(pingjiax,HttpStatus.OK);
	}
	
	
	/**
	 * 查询所有酒店信息
	 * 
	 * @return
	 */
	@GetMapping("/jiudian")
	public ResponseEntity<?> queryJiudian() {
		log.info("开始检索酒店信息......");

		List<jiudian> jiudianx =  DestinationService.queryJiudian();
		log.info("检索完成"); 
		return new ResponseEntity<List<jiudian>>(jiudianx,HttpStatus.OK);
	}
	
	/**
	 * 查询单条酒店信息
	 * 
	 * @param jiuid
	 * @return
	 */
	@GetMapping("/jd/{jiuid}")
	public ResponseEntity<?> queryjd(@PathVariable("jiuid") Integer jiuid) {
		log.info("开始检索指定酒店信息.......");
		
		// 首先检查该国家是否存在
		List<jiudianxiangqing> jiudianxiangqingx = DestinationService.queryByjdId(jiuid);
		if (jiudianxiangqingx == null) {
			return new ResponseEntity<>("没找着图片中:" + jiuid + "的国家图片信息", HttpStatus.NOT_FOUND);
		}
		
		log.info("检索完成");
		return new ResponseEntity<List<jiudianxiangqing>>(jiudianxiangqingx, HttpStatus.OK);
	}
}
