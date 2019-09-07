package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.*;
import com.newer.lvyou.service.HouTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class HoutaiContorller {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HouTaiService houTaiService;

    //查询所有团队
    @GetMapping("/queryTD")
    public ResponseEntity<?> queryTD(){
        List<tuandui> list = houTaiService.selectTD();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //根据团队id查找单个团队
    @GetMapping("/queryTDById")
    public ResponseEntity<?> queryTDById(int id){
        tuandui td = houTaiService.selectTDById(id);
        return new ResponseEntity<>(td,HttpStatus.OK);
    }

    //新增团队
    @PostMapping("/addTD")
    public ResponseEntity<?> addTD(tuandui td){
        int count = houTaiService.addTD(td);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //修改团队
    @PostMapping("/updTD")
    public ResponseEntity<?> updTd(tuandui td){
        int count = houTaiService.updTD(td);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //删除团队
    @GetMapping("/delTD")
    public ResponseEntity<?> delTD(int id){
        int count = houTaiService.delTD(id);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //查询所有酒店
    @GetMapping("/queryJD")
    public ResponseEntity<?> queryJD(){
        List<jiudian> list = houTaiService.selectJD();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //根据酒店id查询单个酒店
    @GetMapping("/queryJDById")
    public ResponseEntity<?> queryJDById(int id){
        jiudian jd = houTaiService.selectJDById(id);
        return new ResponseEntity<>(jd,HttpStatus.OK);
    }

    //新增酒店
    @PostMapping("/addJD")
    public ResponseEntity<?> addJD(jiudian jd){
        int count = houTaiService.addJD(jd);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //修改酒店
    @PostMapping("/updJD")
    public ResponseEntity<?> updJd(jiudian jd){
        int count = houTaiService.updJD(jd);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //删除酒店
    @GetMapping("/delJD")
    public ResponseEntity<?> delJD(int id){
        int count = houTaiService.delJD(id);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //查询所有旅游国家列表
    @PostMapping("/queryGJList")
    public ResponseEntity<?> queryGJList(String name,@RequestParam("iDisplayStart")int pageNo,@RequestParam("iDisplayLength")int pageSize){
        String guoname = null;
        if(name!=null) {
            guoname = name;
        }
        List<guojialist> list = houTaiService.queryGJList(guoname,pageNo,pageSize);
        JSONObject jo = new JSONObject();
        int total = houTaiService.selectGJZS(guoname);
        jo.put("data",list);
        jo.put("iTotalDisplayRecords",total);
        jo.put("iTotalRecords",total);
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    //查询旅游国家列表数量
    @GetMapping("/queryGJZS")
    public ResponseEntity<?> queryGJZS(String guoname){
        int gjzs = houTaiService.selectGJZS(guoname);
        return new ResponseEntity<>(gjzs,HttpStatus.OK);
    }

    //根据国家id查找单个国家
    @GetMapping("/selectGJById")
    public ResponseEntity<?> selectGJById(int id){
        guojialist gj = houTaiService.selectGJByid(id);
        return new ResponseEntity<>(gj,HttpStatus.OK);
    }

    //新增旅游国家
    @PostMapping("/addGJList")
    public ResponseEntity<?> addGJList(@RequestParam(value = "file",required = false)MultipartFile file,
                                       @RequestParam("guoname")String guoname,
                                       @RequestParam("zhouname")String zhouname,
                                       @RequestParam("shuxing")int shuxing){
        String filePath = null;
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                filePath = "D:/nginx-1.16.0/html/lvyou/img/"+zhouname+"/"+guoname+".jpg";
                System.out.println(filePath);
                // 转存文件
                file.transferTo(new File(filePath));
                filePath = "img/"+zhouname+"/"+guoname+".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        guojialist gjl = new guojialist();
        gjl.setGuoname(guoname);
        gjl.setZhouname(zhouname);
        gjl.setShuxing(shuxing);
        gjl.setTpurl(filePath);
        gjl.setShenhe(0);
        int count = houTaiService.addGJList(gjl);
        System.out.println(gjl.getId());
        int id = gjl.getId();
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    //修改旅游国家
    @PostMapping("/updGJList")
    public ResponseEntity<?> updGJList(@RequestParam(value = "file",required = false)MultipartFile file,
                                       @RequestParam("guoname")String guoname,
                                       @RequestParam("zhouname")String zhouname,
                                       @RequestParam("shuxing")int shuxing,
                                       @RequestParam("id")int id,
                                       @RequestParam("tp")String tp){
        String filePath = null;
        if(file!=null) {
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
                    filePath = "D:/nginx-1.16.0/html/lvyou/img/" + zhouname + "/" + guoname + ".jpg";
                    System.out.println(filePath);
                    // 转存文件
                    file.transferTo(new File(filePath));
                    filePath = "img/" + zhouname + "/" + guoname + ".jpg";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            filePath = tp;
        }
        guojialist gjl = new guojialist();
        gjl.setId(id);
        gjl.setGuoname(guoname);
        gjl.setZhouname(zhouname);
        gjl.setShuxing(shuxing);
        gjl.setTpurl(filePath);
        gjl.setShenhe(0);
        System.out.println(gjl);
        int count = houTaiService.updGJList(gjl);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }


    //删除旅游国家
    @GetMapping("/delGJList")
    public ResponseEntity<?> delGJList(int id){
        int count = houTaiService.delGJList(id);
        houTaiService.delLYXQ(id);   //删除旅游国家时一起删除旅游详情
        houTaiService.delJTXC(id);   //删除旅游国家时一起删除具体行程
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //批量删除旅游国家
    @GetMapping("/pldeleteGJList")
    public ResponseEntity<?> pldeleteGJList(@RequestParam("xzadmin")String tp){
        JSONArray ja = JSONArray.parseArray(tp);
        int count = 0;
        for(Object obj : ja){
            int id = (int)obj;
            count =  houTaiService.delGJList(id);
            houTaiService.delLYXQ(id);   //删除旅游国家时一起删除旅游详情
            houTaiService.delJTXC(id);   //删除旅游国家时一起删除具体行程
        }
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //通过旅游国家id搜索旅游详情
    @GetMapping("/queryByGuoId")
    public ResponseEntity<?> queryByGuoId(int guoid){
        lvyouxiangqing lyxq = houTaiService.selectByGuoId(guoid);
        if(lyxq==null){
            return new ResponseEntity<>(1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(lyxq, HttpStatus.OK);
        }
    }

    //添加旅游详情
    @PostMapping("/addLYXQ")
    public ResponseEntity<?> addLYXQ(@RequestParam(value = "file",required = false)MultipartFile file,
                                     @RequestParam("guoname")String guoname,
                                     @RequestParam("info")String info,
                                     @RequestParam("feiyong")int feiyong,
                                     @RequestParam("guoid")int guoid,
                                     @RequestParam("zhouname")String zhouname,
                                     @RequestParam("liangdian")String liangdian){
        String filePath = null;
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                filePath = "D:/nginx-1.16.0/html/lvyou/img/"+zhouname+"/xq"+guoname+".jpg";
                System.out.println(filePath);
                // 转存文件
                file.transferTo(new File(filePath));
                filePath = "img/"+zhouname+"/XQ"+guoname+".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        lvyouxiangqing lyxq = new lvyouxiangqing();
        lyxq.setGuoid(guoid);
        lyxq.setGuoname(guoname);
        lyxq.setGuotpurl(filePath);
        lyxq.setInfo(info);
        lyxq.setLiangdian(liangdian);
        lyxq.setFeiyong(feiyong);
        int count = houTaiService.addLYXQ(lyxq);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //修改旅游详情
    @PostMapping("/updLYXQ")
    public ResponseEntity<?> updLYXQ(@RequestParam(value = "file",required = false)MultipartFile file,
                                     @RequestParam("guoname")String guoname,
                                     @RequestParam("info")String info,
                                     @RequestParam("feiyong")int feiyong,
                                     @RequestParam("guoid")int guoid,
                                     @RequestParam("zhouname")String zhouname,
                                     @RequestParam("tp")String tp,
                                     @RequestParam("liangdian")String liangdian){
        String filePath = null;
        if(file!=null) {
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
                    filePath = "D:/nginx-1.16.0/html/lvyou/img/" + zhouname + "/xq" + guoname + ".jpg";
                    System.out.println(filePath);
                    // 转存文件
                    file.transferTo(new File(filePath));
                    filePath = "img/" + zhouname + "/XQ" + guoname + ".jpg";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            filePath = tp;
        }
        lvyouxiangqing lyxq = new lvyouxiangqing();
        lyxq.setGuoid(guoid);
        lyxq.setGuoname(guoname);
        lyxq.setGuotpurl(filePath);
        lyxq.setInfo(info);
        lyxq.setLiangdian(liangdian);
        lyxq.setFeiyong(feiyong);
        int count = houTaiService.updLYXQ(lyxq);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //通过旅游国家id删除旅游详情 在删除国家的时候一起调用所以注释了 要用的话再放开
    /*@GetMapping("/delLVXQ")
    public ResponseEntity<?> delLVXQ(int guoid){
        int count = houTaiService.delLYXQ(guoid);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }*/

    //根据旅游国家id搜索所有行程列表
    @GetMapping("/queryJTXC")
    public ResponseEntity<?> queryJTXC(int guoid){
        List<jutixingcheng> list = houTaiService.selectJTXC(guoid);
        JSONObject jo = new JSONObject();
        jo.put("data",list);
        jo.put("iTotalDisplayRecords",10);
        jo.put("iTotalRecords",10);
        if(list.size()==0){
            return new ResponseEntity<>(0,HttpStatus.OK);
        }
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    //根据具体行程id搜索单条具体行程
    @GetMapping("/queryOneJTXC")
    public ResponseEntity<?> queryOneJTXC(int id){
        jutixingcheng jtxc = houTaiService.selectOneJTXC(id);
        return new ResponseEntity<>(jtxc,HttpStatus.OK);
    }

    //添加新行程
    @PostMapping("/addJTXC")
    public ResponseEntity<?> addJTXC(jutixingcheng jtxc){
        int count = houTaiService.addJTXC(jtxc);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //修改具体行程
    @PostMapping("/updJTXC")
    public ResponseEntity<?> updJTXC(jutixingcheng jtxc){
        int count = houTaiService.updJTXC(jtxc);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //通过旅游国家id删除具体行程 在删除旅游国家的时候一起调用所以注释了 要用的话再放开
    /*@GetMapping("/delJTXC")
    public ResponseEntity<?> delJTXC(int guoid){
        int count = houTaiService.delJTXC(guoid);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }*/

    //通过具体行程id删除单条具体行程
    @GetMapping("/delOneJTXC")
    public ResponseEntity<?> delOneJTXC(int id) {
        int count = houTaiService.delOneJTXC(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //搜索所有图片
    @GetMapping("/queryTP")
    public ResponseEntity<?> queryTP(){
        List<tupian> list = houTaiService.selectTP();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //根据图片id查找图片
    @GetMapping("/queryTPById")
    public ResponseEntity<?> queryTPById(int id){
        tupian tp = houTaiService.selectByTPId(id);
        return new ResponseEntity<>(tp,HttpStatus.OK);
    }

    //添加一张图片
    @PostMapping("/addTP")
    public ResponseEntity<?> addTP(tupian tp){
        int count = houTaiService.addTP(tp);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    //修改图片
    @PostMapping("/updTP")
    public ResponseEntity<?> updTP(tupian tp){
        int count = houTaiService.updTP(tp);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

}
