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
                                              @RequestParam("iDisplayStart")Integer pageNo,
                                              @RequestParam("iDisplayLength")Integer pageSize){
        String uname = null;
        if (name!=null){
            uname = name;
        }
        List<dingdan> dingdanList = houTaidingdanService.findAlldingdanFenYe(uname,pageNo,pageSize);
        JSONObject jsonObject = new JSONObject();
        int totol = houTaidingdanService.dingdanCount(uname);
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
    public ResponseEntity<?> dingdanCount(String uname){
        int count = houTaidingdanService.dingdanCount(uname);
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
    @DeleteMapping("/dingdanDelete/{id}")
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