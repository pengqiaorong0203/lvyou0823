package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.admin;
import com.newer.lvyou.domain.user;
import com.newer.lvyou.service.HouTaiuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.TabableView;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaiUserController {

    @Autowired
    private HouTaiuserService houTaiuserService;

    /**
     * 显示所有用户以及信息
     * @return
     */
    @GetMapping("/findAllUser")
    public ResponseEntity<?> findAllUser() {
        List<user> userList = houTaiuserService.findAllUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    /**
     *
     * @param name
     * @param pageNO
     * @param pageSize
     * @return
     */
    @GetMapping("/queryUserList")
    public ResponseEntity<?> queryUserList(String name,@RequestParam("iDisplayStart") Integer pageNO,
                                           @RequestParam("iDisplayLength")Integer pageSize){
        String username = null;
        if (name!=null){
            username = name;
        }
        System.out.println(name);
        System.out.println(username);
        List<user> userList = houTaiuserService.findAllUserFenYe(username,pageNO,pageSize);
        for (user cards :userList){//循环遍历集合，将集合中的值重新赋值在页面上
            //用户密码传到前端页面做处理
            String pwd = cards.getPwd().substring(0,6);
            cards.setPwd(cards.getPwd().replaceAll(pwd,"*******"));
            //用户联系方式传到前端页面做处理
            String phone = cards.getPhone().substring(3,8);
            cards.setPhone(cards.getPhone().replaceAll(phone,"****"));
        }
        JSONObject jsonObject = new JSONObject();
        int total = houTaiuserService.userCount(username);
        jsonObject.put("data",userList);
        jsonObject.put("iTotalDisplayRecords",total);
        jsonObject.put("iTotalRecords",total);
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @PostMapping("/userAdd")
    public ResponseEntity<?> userAdd(user user) {
        int i = houTaiuserService.userAdd(user);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping("/userDelete")
    public ResponseEntity<?> userDelete(Integer id) {
        int i = houTaiuserService.userDelete(id);
        System.out.println("删除的对象是："+i);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    @GetMapping("/userUpdate")
    public ResponseEntity<?> userUpdate(user user) {
        int i = houTaiuserService.userUpdate(user);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 统计用户总数量
     * @return
     */
    @GetMapping("/userCount")
    public ResponseEntity<?> userCount(String username){
        int count = houTaiuserService.userCount(username);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 根据id查询单条用户信息
     * @param id
     * @return
     */
    @GetMapping("/findOneUser")
    public ResponseEntity<?> findOneUser(Integer id){
        user user = houTaiuserService.findOneUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
