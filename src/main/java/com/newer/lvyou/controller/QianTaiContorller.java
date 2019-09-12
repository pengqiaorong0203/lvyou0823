package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.dingdan;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.domain.user;
import com.newer.lvyou.mapper.QianTaiMapper;
import com.newer.lvyou.service.QianTaiService;
import com.newer.lvyou.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class QianTaiContorller {

    @Autowired
    private QianTaiMapper qianTaiMapper;

    @Autowired
    private QianTaiService qianTaiService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${auth.header}") //application.yml 获取auth.header的值
    private String header;
    private String str;//程序输出的验证码
    private String mb;

    @GetMapping("/selectZname")
    public ResponseEntity<?> selectGJByZname(@RequestBody String zhouname){
        List<guojialist> list = qianTaiMapper.selectGJByZname(zhouname);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //根据国家id查找信息
    @GetMapping("/selectGJByid/{cid}")
    public ResponseEntity<?> selectGJByid(@PathVariable("id")int id){
        guojialist guojialist = qianTaiMapper.selectGJByid(id);
        return new ResponseEntity<>(guojialist,HttpStatus.OK);
    }

    @GetMapping("/selectAllGJ")
    public ResponseEntity<?> selectAllGJ(){
        List<guojialist> list = qianTaiMapper.selectAllGJ();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/selectGJ6")
    public ResponseEntity<?> selectGJ6(){
        List<guojialist> list = qianTaiMapper.selectGJ6();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/selectlvxiang6")
    public ResponseEntity<?> selectlvxiang6(){
        List<lvyouxiangqing> list = qianTaiMapper.selectlvxiang6();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/selectAllzn")
    public ResponseEntity<?> selectAllzn(){
        List<guojialist> list = qianTaiMapper.selectAllzn();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @PostMapping("/userAdds")
    public ResponseEntity<?> userAdds(user user) {
        System.err.println(user);
        int i = qianTaiService.userAdds(user);
        System.out.println(i);
        return new ResponseEntity<>(i,HttpStatus.OK);
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
        user user=qianTaiService.Login(username,pwd);
        System.out.println(user+"====>");
        if (user!=null){//用户名和密码在用户表中存
            token=jwtTokenUtil.createJwt(username);
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
            ad=qianTaiService.getAdmin(claims.getIssuer());
            //密码隐藏
            ad.setPwd("*****");
            System.err.println(ad);
        }
        return new ResponseEntity<>(ad,HttpStatus.OK);
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
        int count=qianTaiService.updAdminsPwd(pwd,username);
        System.out.println(count);
        return new ResponseEntity<>(count,HttpStatus.OK);

    }
    /*@GetMapping("/useradmins")
    public ResponseEntity<?> userSession(HttpSession session
    ){
        user ad=(user) session.getAttribute("admin");
        System.out.println(ad.getUsername());
        return  new ResponseEntity<>(ad,HttpStatus.OK);
    }

    *//**
     * 退出程序，清除session
     * @param session
     * @return
     *//*
    @GetMapping("logout")
    public  ResponseEntity<?> logOut(HttpSession session){
        session.removeAttribute("admin");
        System.out.println("清除session");
        return new ResponseEntity<>(1,HttpStatus.OK);
    }
*/
    /**
     * 会员添加用户信息
     * @param user
     * @return
     */
    @PostMapping("/userAdde")
    public ResponseEntity<?> userAdde(user user) {
        System.err.println(user);
        int i = qianTaiService.userAdde(user);
        System.out.println(i);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping("/selectDingdanByUid")
    public ResponseEntity<?> selectDingdanByUid(int uid,
                                                @RequestParam("iDisplayStart")Integer pageNo,
                                                @RequestParam("iDisplayLength")Integer pageSize   ){
        List<dingdan> list = qianTaiService.selectDingdanByUid(uid,pageNo,pageSize);
        JSONObject jsonObject = new JSONObject();
        int totol = qianTaiService.countDingdanByUid(uid);
        jsonObject.put("data",list);
        jsonObject.put("iTotalDisplayRecords",totol);
        jsonObject.put("iTotalRecords",totol);
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    @GetMapping("/countDingdanByUid")
    public ResponseEntity<?> countDingdanByUid(int uid){
        int i = qianTaiService.countDingdanByUid(uid);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }



}
