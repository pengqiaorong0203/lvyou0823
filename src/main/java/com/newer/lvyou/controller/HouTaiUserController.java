package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.user;
import com.newer.lvyou.service.HouTaiuserService;
import com.newer.lvyou.util.JwtTokenUtil;
import com.newer.lvyou.util.SecurityCode;
import com.newer.lvyou.util.SecurityImage;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaiUserController {

    @Autowired
    private HouTaiuserService houTaiuserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${auth.header}") //application.yml 获取auth.header的值
    private String header;
    private String str;//程序输出的验证码
    private String mb;

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
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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
        System.err.println(user);
        int i = houTaiuserService.userAdd(user);
        System.out.println(i);
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
     * 登陆
     * @param username
     * @param pwd
     * @param
     * @return
     */
    @PostMapping("/getAdmin")
    public ResponseEntity<?> checkName(@RequestParam("username") String username,
                                       @RequestParam("pwd")String pwd

    ){
        String token;
        user user=houTaiuserService.login(username,pwd);
        System.out.println(user+"====>");
        if (user!=null){//用户名和密码在用户表中存
             token=jwtTokenUtil.createJwt(username);
          System.out.println("生成token成功:{}"+token);

          return new ResponseEntity<>(token,HttpStatus.OK);
        }else {
            token= "用户名或密码错误";
        }
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @RequestMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest request){
        String token= request.getHeader(header);
        user ad=null;
        System.out.println(token);
        if (token!=null){
            Claims claims=jwtTokenUtil.parseJWT(token);
            System.out.println(claims.getIssuer());
            //调用根据用户名查询用户数据方法
            ad=houTaiuserService.getAdmin(claims.getIssuer());
            //密码隐藏
            ad.setPwd("*****");
            System.err.println(ad);
        }
        return new ResponseEntity<>(ad,HttpStatus.OK);
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
    /**
     * 修改密码
     * @param pwd
     * @param username
     * @return
     */
    @PutMapping("updPwd")
    public ResponseEntity<?> updatePwd(@RequestParam("password2")String pwd,
                                       @RequestParam("username") String username
    ){
        int count=houTaiuserService.updAdminsPwd(pwd,username);
        System.out.println(count);
        return new ResponseEntity<>(count,HttpStatus.OK);

    }

    /**
     * 批量删除管理员数据
     * @param xzadmin
     * @return
     */
    @GetMapping("/chooseAllUser")
    public ResponseEntity<?> chooseAllUser(String xzadmin){
        JSONArray jsonArray = JSONArray.parseArray(xzadmin);
        System.out.println("打印这个数组："+xzadmin);
        int m = 0;
        for (Object jsonArrays:jsonArray){
            int k = (int)jsonArrays;
            m = houTaiuserService.userDelete(k);
        }
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
}
