package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.tupian;
import com.newer.lvyou.service.HouTaitupianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaitupianController {

    @Autowired
    private HouTaitupianService houTaitupianService;

    /**
     * 查询所有旅游国家列表并实现分页
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/queryTupianList")
    public ResponseEntity<?> queryTupianList(String name,@RequestParam("iDisplayStart")int pageNo, @RequestParam("iDisplayLength")int pageSize){
        String guoname = null;
        System.out.println("...............................................................");
        if(name!=null) {
            guoname = name;
        }
        System.out.println("1:"+guoname);
        System.out.println("2:"+name);
        List<tupian> list = houTaitupianService.findAllTuPianFenYe(guoname,pageNo,pageSize);
        JSONObject jo = new JSONObject();
        int total = houTaitupianService.tupianCount(guoname);
        jo.put("data",list);
        jo.put("iTotalDisplayRecords",total);
        jo.put("iTotalRecords",total);
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    /**
     * 统计图片总数量
     * @param guoname
     * @return
     */
    @GetMapping("/tupianCount")
    public ResponseEntity<?> tupianCount(String guoname){
        int count = houTaitupianService.tupianCount(guoname);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
