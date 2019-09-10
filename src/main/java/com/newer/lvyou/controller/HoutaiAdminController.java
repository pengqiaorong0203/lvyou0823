package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.admin;
import com.newer.lvyou.service.HouTaiAdminService;
import com.newer.lvyou.util.SecurityCode;
import com.newer.lvyou.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 登录
 */
@RestController
@RequestMapping("/api")
public class HoutaiAdminController {

    @Autowired
    private HouTaiAdminService houTaiAdminService;

    /**
     * 定义验证码字符串;
     */
    private String string;

    /**
     * 查询用户名跟密码是否存在并登录
     * @param name
     * @param pwd
     * @param yzm
     * @return
     */
    @PostMapping("/findBynamePassword")
    public ResponseEntity<?> findBynamePassword(@RequestParam("name") String name,
                                                @RequestParam("pwd") String pwd,
                                                @RequestParam("yzm") String yzm,
                                                HttpSession session){
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(yzm);
        admin ad = houTaiAdminService.findBynamePassword(name,pwd);
        int msg = 0;
        if (string.equals(yzm)){
            if (ad!=null){
                msg = 1;
                /*获取用户登录信息*/
                session.setAttribute("admin",ad);
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                msg = 2;
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }
        }else {
            msg = 3;
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     *管理员用户分页
     * @param name1
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/queryAdminList")
    public ResponseEntity<?> queryAdminList(String name1,
                                            @RequestParam("iDisplayStart") Integer pageNo,
                                            @RequestParam("iDisplayLength") Integer pageSize){
        String name = null;
        if (name1!=null){
            name = name1;
        }
        System.out.println("打印搜索admin："+name1);
        List<admin> adminList = houTaiAdminService.findAllAdminFenYe(name,pageNo,pageSize);
        for (admin cards :adminList){//循环遍历集合，将集合中的值重新赋值在页面上
            //用户密码传到前端页面做处理
            String str1=cards.getPwd().substring(0,6);
            cards.setPwd(cards.getPwd().replaceAll(str1,"******"));
        }
        JSONObject jsonObject = new JSONObject();
        int total = houTaiAdminService.adminCount(name);
        jsonObject.put("data",adminList);
        jsonObject.put("iTotalDisplayRecords",total);
        jsonObject.put("iTotalRecords",total);
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/img")
    public void createImg(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("************验证码*****************");
        string = SecurityCode.getSecurityCode();
        BufferedImage bufimg = SecurityImage.createImage(string);
        // 设置响应头部不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("cache-Control", "no-cache");
        // 设置内容响应格式
        response.setContentType("image/jpeg");
        // 设置过期时间
        response.setDateHeader("Expirs", 0);
        // 通过图片io流写出去
        ImageIO.write(bufimg, "JPEG", response.getOutputStream());
    }

    /**
     * 查询管理员用户所有详细信息
     * @return
     */
    @GetMapping("/findAlladmin")
    public ResponseEntity<?> findAlladmin(){
        List<admin> adminList = houTaiAdminService.findAlladmin();
        /*System.out.println("所有管理员登录信息："+adminList);*/
        return new ResponseEntity<>(adminList,HttpStatus.OK);
    }

    /**
     * 统计管理员数量
     * @return
     */
    @GetMapping("/adminCount")
    public ResponseEntity<?> adminCount(String name){
        int count = houTaiAdminService.adminCount(name);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 得到用户登录信息
     * @param session
     * @return
     */
    @GetMapping("/getAdmins")
    public ResponseEntity<?> getAdmins(HttpSession session){
        admin admins = (admin) session.getAttribute("admin");
        return  new ResponseEntity<>(admins,HttpStatus.OK);
    }

    /**
     *删除管理员人员信息
     * @param id
     * @return
     */
        @DeleteMapping("/adminDelete")
    public ResponseEntity<?> adminDelete(Integer id){
        int admindel = houTaiAdminService.adminDelete(id);
        System.out.println("删除一条信息："+admindel);
        return new ResponseEntity<>(admindel,HttpStatus.OK);
    }

    /**
     * 新增管理员人员信息
     * @param admin
     * @return
     */
    @PostMapping("/adminAdd")
    public ResponseEntity<?> adminAdd(admin admin){
        int adminadd = houTaiAdminService.adminAdd(admin);
        return new ResponseEntity<>(adminadd,HttpStatus.OK);
    }

    /**
     *退出登录刷新登录
     * @param session
     * @return
     */
    @GetMapping("/out")
    public ResponseEntity<?> out(HttpSession session){
        session.removeAttribute("admin");
        System.out.println("清除session");
        return new ResponseEntity<>(1,HttpStatus.OK);
    }

    /**
     * 根据用户名修改用户密码
     * @param
     * @return
     */
    @PostMapping("/loadAdmins")
    public ResponseEntity<?> loadAdmins(@RequestParam("name")String name,
                                        @RequestParam("pwd")String pwd,
                                        @RequestParam("password1")String password1) {
        /*拿到用户信息*/
        admin admins1 = houTaiAdminService.findBynamePassword(name,pwd);
        System.out.println("1输出用户姓名："+name);
        System.out.println("1输出用户密码："+pwd);
        System.out.println("1输出用户信息："+admins1);
        if (admins1!=null) {
            int admins2 = houTaiAdminService.adminUpdate(name,password1);
            System.out.println("修改之后的用户信息:"+admins2);
            return new ResponseEntity<>(admins2,HttpStatus.OK);
        }else {
            int msg = 0;
            System.out.println("打印："+msg);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
    }

    /**
     * 根据登录管理员id查询详细信息(查询个人登录用户名跟密码)
     * @param id
     * @return
     */
    @GetMapping("/adminSelectOne")
    public ResponseEntity<?> adminSelectOne(Integer id){
        admin admin = houTaiAdminService.adminSelectOne(id);
        System.out.println("单条个人信息："+admin);
        return new ResponseEntity<>(admin,HttpStatus.OK);
    }

    /**
     * 批量删除管理员数据
     * @param xzadmin
     * @return
     */
    @GetMapping("/chooseAll")
    public ResponseEntity<?> chooseAll(String xzadmin){
        JSONArray jsonArray = JSONArray.parseArray(xzadmin);
        System.out.println("打印这个数组："+xzadmin);
        int m = 0;
            for (Object jsonArrays:jsonArray){
                int k = (int)jsonArrays;
                m = houTaiAdminService.adminDelete(k);
            }
            return new ResponseEntity<>(m,HttpStatus.OK);
    }
}
