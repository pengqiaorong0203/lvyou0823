package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.shenhelist;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.service.HouTaiService;
import com.newer.lvyou.service.HouTaiteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaiTeamController {

    @Autowired
    private HouTaiteamService houTaiteamService;

    @Autowired
    private HouTaiService houTaiService;

    /**
     * 显示所有团队以及信息
     * @return
     */
    @GetMapping("/findAllTuandui")
    public ResponseEntity<?> findAllTuandui() {
        List<tuandui> userList = houTaiteamService.findAllTuandui();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    /**
     *
     * @param name
     * @param pageNO
     * @param pageSize
     * @return
     */
    @GetMapping("/queryTuanduiList")
    public ResponseEntity<?> queryTuanduiList(String name,
                                              @RequestParam("iDisplayStart") Integer pageNO,
                                              @RequestParam("iDisplayLength")Integer pageSize){
        String tname = null;
        if (name!=null){
            tname = name;
        }
        System.out.println(name);
        System.out.println(tname);
        List<tuandui> tuanduiList = houTaiteamService.findAllTuanDuiFenYe(tname,pageNO,pageSize);
        JSONObject jsonObject = new JSONObject();
        int total = houTaiteamService.tuanduiCount(tname);
        jsonObject.put("data",tuanduiList);
        jsonObject.put("iTotalDisplayRecords",total);
        jsonObject.put("iTotalRecords",total);
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    /**
     * 新增团队信息
     * @param tuandui
     * @return
     */
    @PostMapping("/tuanduiAdd")
    public ResponseEntity<?> userAdd(tuandui tuandui) {
        int i = houTaiteamService.tuanduiAdd(tuandui);
        int id = tuandui.getId();
        shenhelist shl = new shenhelist();
        shl.setXiugaibiao("团队列表");
        shl.setBiaoid(id);
        shl.setShenhe(0);
        shl.setXiugaiadmin("Tonn");
        shl.setXiugaitime(new Date());
        houTaiService.addSHL(shl);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据团队id删除团队信息
     * @param id
     * @return
     */
    @DeleteMapping("/tuanduiDelete")
    public ResponseEntity<?> tuanduiDelete(Integer id) {
        int i = houTaiteamService.tuanduiDelete(id);
        System.out.println("删除的对象是："+i);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 修改单个团队信息
     * @param tuandui
     * @return
     */
    @GetMapping("/tuanduiUpdate")
    public ResponseEntity<?> tuanduiUpdate(tuandui tuandui) {
        int i = houTaiteamService.tuanduiUpdate(tuandui);
        shenhelist shl = new shenhelist();
        shl.setXiugaibiao("团队列表");
        shl.setBiaoid(tuandui.getId());
        shl.setShenhe(0);
        shl.setXiugaiadmin("Tonn");
        shl.setXiugaitime(new Date());
        houTaiService.addSHL(shl);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 统计团队总数量
     * @return
     */
    @GetMapping("/tuanduiCount")
    public ResponseEntity<?> tuanduiCount(String tname){
        int count = houTaiteamService.tuanduiCount(tname);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 根据id查询单个用团队信息
     * @param id
     * @return
     */
    @GetMapping("/findOneTuandui")
    public ResponseEntity<?> findOneTuandui(Integer id){
        tuandui tuandui = houTaiteamService.findOneTuandui(id);
        /*System.out.println("团队信息："+tuandui);*/
        return new ResponseEntity<>(tuandui,HttpStatus.OK);
    }

    /**
     * 添加图片信息
     * @param tname
     * @param info
     * @param
     * @return
     */
    @PostMapping("/tuanduiAddList")
    public ResponseEntity<?> tuanduiAddList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                            @RequestParam("tname") String tname,
                                            @RequestParam("info") String info
    ){
        String filePath = null;
        if (!uplx.isEmpty()){
            try {
                /*文件保存路径*/
                filePath = "D:/nginx-1.16.0/html/lvyou/img/"+tname+".jpg";
                /*转存路径*/
                uplx.transferTo(new File(filePath));
                filePath = "img/"+tname+".jpg";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        tuandui tuandui = new tuandui();
        tuandui.setTname(tname);
        tuandui.setInfo(info);
        tuandui.setToux(filePath);
        int count = houTaiteamService.tuanduiAdd(tuandui);
        shenhelist shl = new shenhelist();
        shl.setXiugaibiao("团队列表");
        shl.setBiaoid(tuandui.getId());
        shl.setShenhe(0);
        shl.setXiugaiadmin("Tonn");
        shl.setXiugaitime(new Date());
        houTaiService.addSHL(shl);
        System.out.println("打印保存路径1...："+filePath);
        System.out.println("打印保存路径2...："+filePath);
        System.out.println("打印保存路径3...："+tuandui);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 修改图片信息
     * @param tname
     * @param info
     * @param
     * @return
     */
    @PostMapping("/tuanduiUpdateList")
    public ResponseEntity<?> tuanduiUpdateList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                               @RequestParam("tname") String tname,
                                               @RequestParam("id") int id,
                                               @RequestParam("info") String info,
                                               @RequestParam("tp")String tp
    ){
        String filePath = null;
        if(uplx!=null){
        if (!uplx.isEmpty()) {
            try {
                /*文件保存路径*/
                filePath = "D:/nginx-1.16.0/html/lvyou/img/" + tname + ".jpg";
                /*转存路径*/
                uplx.transferTo(new File(filePath));
                filePath = "img/" + tname + ".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }else{
            filePath = tp;
        }
        tuandui tuandui = new tuandui();
        tuandui.setId(id);
        tuandui.setTname(tname);
        tuandui.setInfo(info);
        tuandui.setToux(filePath);
        int count = houTaiteamService.tuanduiUpdate(tuandui);
        shenhelist shl = new shenhelist();
        shl.setXiugaibiao("团队列表");
        shl.setBiaoid(tuandui.getId());
        shl.setShenhe(0);
        shl.setXiugaiadmin("Tonn");
        shl.setXiugaitime(new Date());
        houTaiService.addSHL(shl);
        System.out.println("打印保存路径1...："+filePath);
        System.out.println("打印保存路径2...："+filePath);
        System.out.println("打印保存路径3...："+tuandui);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
