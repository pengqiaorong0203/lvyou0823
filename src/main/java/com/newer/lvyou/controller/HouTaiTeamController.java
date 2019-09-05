package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.service.HouTaiteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaiTeamController {

    @Autowired
    private HouTaiteamService houTaiteamService;

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
        int i = houTaiteamService.userUpdate(tuandui);
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
        return new ResponseEntity<>(tuandui,HttpStatus.OK);
    }
}
