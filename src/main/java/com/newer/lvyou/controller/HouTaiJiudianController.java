package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.jiudianxiangqing;
import com.newer.lvyou.service.HouTaijiudianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public ResponseEntity<?> queryJiuDianList(String name,
                                              @RequestParam("iDisplayStart")int pageNo,
                                              @RequestParam("iDisplayLength")int pageSize){
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
    public ResponseEntity<?> jiudianCount(String jdname,String guoname) {
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
    @DeleteMapping("/jiudianDelete")
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
     * 添加酒店信息
     * @param uplx
     * @param info
     * @param guoid
     * @param jiage
     * @return
     */
    @PostMapping("/jiudianAddList")
    public ResponseEntity<?> jiudianAddList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                            @RequestParam("info") String info,
                                            @RequestParam("guoname") String guoname,
                                            @RequestParam("jdname") String jdname,
                                            @RequestParam("guoid")Integer guoid,
                                            @RequestParam("jiage")Integer jiage
    ){
        String filePath = null;
        if (!uplx.isEmpty()){
            try {
                /*文件保存路径*/
                filePath = "D:/nginx-1.16.0/html/lvyou0823/img/"+guoid+".jpg";
                /*转存路径*/
                uplx.transferTo(new File(filePath));
                filePath = "img/"+guoid+".jpg";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        jiudian jiudian = new jiudian();
        jiudian.setGuoid(guoid);
        jiudian.setInfo(info);
        jiudian.setJiage(jiage);
        jiudian.setGuoname(guoname);
        jiudian.setJdname(jdname);
        jiudian.setTupian(filePath);
        System.out.println("打印保存路径3...："+jiudian);
        int count = houTaijiudianService.jiudianAdd(jiudian);
        System.out.println("打印保存路径1...："+filePath);
        System.out.println("打印保存路径2...："+filePath);
        System.out.println("打印保存路径3...："+jiudian);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 动态加载所有酒店名字
     * @return
     */
    @GetMapping("/jiudianxiangqingList")
    public ResponseEntity<?> jiudianxiangqingList(){
        List<jiudianxiangqing> jiudianxiangqingList = houTaijiudianService.jiudianxiangqingList();
        return new ResponseEntity<>(jiudianxiangqingList,HttpStatus.OK);
    }

    /**
     *动态加载所有国家ID
     * @return
     */
    @GetMapping("/jiudianID")
    public ResponseEntity<?> jiudianID(){
        List<jiudian> jiudianList = houTaijiudianService.jiudianID();
        return new ResponseEntity<>(jiudianList,HttpStatus.OK);
    }

    /**
     * 查询单条酒店信息
     * @param id
     * @return
     */
    @GetMapping("/jiudianxiangqingOne")
    public ResponseEntity<?> jiudianxiangqingOne(int id,@RequestParam("iDisplayStart")int pageNo,@RequestParam("iDisplayLength")int pageSize){
        List<jiudianxiangqing> jiudianxiangqing = houTaijiudianService.jiudianxiangqingOne(id);
        JSONObject jo = new JSONObject();
        jo.put("data",jiudianxiangqing);
        jo.put("iTotalDisplayRecords",10);
        jo.put("iTotalRecords",10);
        System.out.println("打印ID："+id);
        System.out.println("打印对象："+jiudianxiangqing);
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    /**
     *联动查询国家ID跟国家名字
     * @param id
     * @return
     */
    @GetMapping("/findOneJiuDian")
    public ResponseEntity<?> findOneJiuDian(Integer id){
        System.out.println("duxiang "+id);
        String guoname = houTaijiudianService.findOneJiuDian(id);
        System.out.println("duxiang "+guoname);
        return new ResponseEntity<>(guoname,HttpStatus.OK);
    }

    /**
     * 根据酒店ID查询单条酒店信息
     * @param id
     * @return
     */
    @GetMapping("/findOneJiuDianInfo")
    public ResponseEntity<?> findOneJiuDianInfo(Integer id){
        jiudian jiudian = houTaijiudianService.findOneJiuDianInfo(id);
        /*System.out.println("打印对象2："+jiudian);*/
        return new ResponseEntity<>(jiudian,HttpStatus.OK);
    }


    /**
     * 修改酒店信息
     * @param uplx
     * @param info
     * @param tp
     * @param jdname
     * @param jiage
     * @return
     */
    @PostMapping("/jiudianUpdateList")
    public ResponseEntity<?> jiudianUpdateList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                               @RequestParam("info") String info,
                                               @RequestParam("tp") String tp,
                                               @RequestParam("jdname") String jdname,
                                               @RequestParam("jiage")Integer jiage,
                                               @RequestParam("id")Integer id
    ){
        String filePath = null;
        if(uplx!=null){
        if (!uplx.isEmpty()){
            try {
                /*文件保存路径*/
                filePath = "D:/nginx-1.16.0/html/lvyou0823/img/"+jdname+".jpg";
                /*转存路径*/
                uplx.transferTo(new File(filePath));
                filePath = "img/"+jdname+".jpg";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        }else{
            filePath = tp;
        }
        jiudian jiudian = new jiudian();
        jiudian.setId(id);
        jiudian.setInfo(info);
        jiudian.setJiage(jiage);
        jiudian.setTupian(filePath);
        jiudian.setJdname(jdname);
        System.out.println("打印保存路径3...："+jiudian);
        int count = houTaijiudianService.jiudianUpdate(jiudian);
        System.out.println("打印保存路径1...："+filePath);
        System.out.println("打印保存路径2...："+filePath);
        System.out.println("打印保存路径3...："+count);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

}
