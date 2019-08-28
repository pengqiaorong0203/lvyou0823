package com.newer.lvyou.controller;

import com.newer.lvyou.domain.user;
import com.newer.lvyou.service.HouTaiuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/userDelete/{id}")
    public ResponseEntity<?> userDelete(Integer id) {
        int i = houTaiuserService.userDelete(id);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    @PutMapping("/userUpdate")
    public ResponseEntity<?> userUpdate(user user) {
        int i = houTaiuserService.userUpdate(user);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 统计用户总数量
     * @return
     */
    @GetMapping("/userCount")
    public ResponseEntity<?> userCount(){
        int count = houTaiuserService.userCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
