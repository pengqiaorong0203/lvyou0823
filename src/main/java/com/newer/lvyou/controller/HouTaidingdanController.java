package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.service.HouTaidingdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaidingdanController {

    @Autowired
    private HouTaidingdanService houTaidingdanService;

    /**
     * 查询所有订单信息
     * @return
     */
    @GetMapping("/findAlldingdan")
    public ResponseEntity<?> findAlldingdan(){
        List<dingdan> dingdanList = houTaidingdanService.findAlldingdan();
        return new ResponseEntity<>(dingdanList,HttpStatus.OK);
    }

    /**
     * 根据国家uname进行分页
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/queryDingdanList")
    public ResponseEntity<?> queryDingdanList(String name,
                                              String beginDate,
                                              String endDate,
                                              @RequestParam("iDisplayStart")Integer pageNo,
                                              @RequestParam("iDisplayLength")Integer pageSize){
        String uname = null;
        if (name!=null){
            uname = name;
        }
        System.out.println("用户姓名:"+uname);
        System.out.println("下单开始时间:"+beginDate);
        System.out.println("下单结束时间:"+endDate);
        List<dingdan> dingdanList = houTaidingdanService.findAlldingdanFenYe(uname,pageNo,pageSize,beginDate,endDate);
        for (dingdan cards :dingdanList){//循环遍历集合，将集合中的值重新赋值在页面上
            //用户邮箱传到前端页面做处理
            String mailbox = cards.getEmail().substring(0,8);
            cards.setEmail(cards.getEmail().replaceAll(mailbox,"*********"));
            //用户手机号码传到前端页面做处理
            String phone = cards.getPhone().substring(3,8);
            cards.setPhone(cards.getPhone().replaceAll(phone,"****"));
        }
        JSONObject jsonObject = new JSONObject();
        int totol = houTaidingdanService.dingdanCount(uname,beginDate,endDate);
        jsonObject.put("data",dingdanList);
        jsonObject.put("iTotalDisplayRecords",totol);
        jsonObject.put("iTotalRecords",totol);
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    /**
     * 统计订单总数量
     * @return
     */
    @GetMapping("/dingdanCount")
    public ResponseEntity<?> dingdanCount(String uname, String beginDate,String endDate){
        int count = houTaidingdanService.dingdanCount(uname,beginDate,endDate);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }



    /**
     * 新增订单信息
     * @param dingdan
     * @return
     */
    @PostMapping("/dingdanAdd")
    public ResponseEntity<?> dingdanAdd(dingdan dingdan){
        int i = houTaidingdanService.dingdanAdd(dingdan);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据订单id删除订单信息
     * @param id
     * @return
     */
    @DeleteMapping("/dingdanDelete")
    public ResponseEntity<?> dingdanDelete(Integer id){
        int i = houTaidingdanService.dingdanDelete(id);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据订单id修改订单信息
     * @param dingdan
     * @return
     */
    @PostMapping("/dingdanUpdate")
    public ResponseEntity<?> dingdanUpdate(dingdan dingdan){
        int i = houTaidingdanService.dingdanUpdate(dingdan);
        System.out.println("当前修改数据的id"+i);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据订单id查询单条订单信息
     * @param id
     * @return
     */
    @GetMapping("/dingdanSelect")
    public ResponseEntity<?> dingdanSelect(Integer id){
        dingdan dingdan = houTaidingdanService.dingdanSelect(id);
        /*System.out.println("查询到当前对象为："+dingdan);*/
        return new ResponseEntity<>(dingdan,HttpStatus.OK);
    }
}