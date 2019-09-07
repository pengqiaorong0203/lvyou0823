package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.service.HouTaijiudianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaiJiudianController {

    @Autowired
    private HouTaijiudianService houTaijiudianService;


    /**
     * 查询所有酒店信息并实现分页
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/queryJiuDianList")
    public ResponseEntity<?> queryJiuDianList(String name,@RequestParam("iDisplayStart")int pageNo,@RequestParam("iDisplayLength")int pageSize){
        String jdname = null;
        if(name!=null) {
            jdname = name;
        }
        System.out.println("1:"+jdname);
        System.out.println("2:"+name);
        List<jiudian> list = houTaijiudianService.findAlljiudianFenYe(jdname,pageNo,pageSize);
        JSONObject jo = new JSONObject();
        int total = houTaijiudianService.jiudianCount(jdname);
        jo.put("data",list);
        jo.put("iTotalDisplayRecords",total);
        jo.put("iTotalRecords",total);
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    /**
     * 统计酒店信息总数量
     * @return
     */
    @GetMapping("/jiudianCount")
    public ResponseEntity<?> jiudianCount(String jdname) {
        int count = houTaijiudianService.jiudianCount(jdname);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 新增酒店信息
     * @param jiudian
     * @return
     */
    @PostMapping("/jiudianAdd")
    public ResponseEntity<?> jiudianAdd(jiudian jiudian) {
        int i = houTaijiudianService.jiudianAdd(jiudian);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据酒店id删除酒店信息
     * @param id
     * @return
     */
    @DeleteMapping("/jiudianDelete/{id}")
    public ResponseEntity<?> jiudianDelete(Integer id) {
        int i = houTaijiudianService.jiudianDelete(id);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 修改酒店详细信息
     * @param jiudian
     * @return
     */
    @PostMapping("/jiudianUpdate")
    public ResponseEntity<?> jiudianUpdate(jiudian jiudian) {
        int i = houTaijiudianService.jiudianUpdate(jiudian);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 添加图片信息
     * @param uplx
     * @param guoname
     * @param
     * @return
     */
    /*@PostMapping("/jiudianAddList")
    public ResponseEntity<?> jiudianAddList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                           @RequestParam("guoname") String guoname,
                                           Integer guoid
    ){
        String filePath = null;
        if (!uplx.isEmpty()){
            try {
                文件保存路径
                filePath = "D:/nginx-1.16.0/html/lvyou0823/img"+guoname+".jpg";
                转存路径
                uplx.transferTo(new File(filePath));
                filePath = "img/"+guoname+".jpg";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        tupian tupian = new tupian();
        tupian.setGuoid(guoid);
        tupian.setTpurl(filePath);
        int count = houTaitupianService.tupianAdd(tupian);
        System.out.println("打印保存路径1...："+filePath);
        System.out.println("打印保存路径2...："+filePath);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }*/
}
