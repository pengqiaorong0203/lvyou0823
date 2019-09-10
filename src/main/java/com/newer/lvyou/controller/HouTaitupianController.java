package com.newer.lvyou.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.tupian;
import com.newer.lvyou.service.HouTaitupianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaitupianController {

    @Autowired
    private HouTaitupianService houTaitupianService;



    /**
     * 查询所有旅游国家列表并实现分页
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/queryTupianList")
    public ResponseEntity<?> queryTupianList(String name,@RequestParam("iDisplayStart")int pageNo, @RequestParam("iDisplayLength")int pageSize){
        String guoname = null;
        System.out.println("...............................................................");
        if(name!=null) {
            guoname = name;
        }
        System.out.println("1:"+guoname);
        System.out.println("2:"+name);
        List<tupian> list = houTaitupianService.findAllTuPianFenYe(guoname,pageNo,pageSize);
        JSONObject jo = new JSONObject();
        int total = houTaitupianService.tupianCount(guoname);
        jo.put("data",list);
        jo.put("iTotalDisplayRecords",total);
        jo.put("iTotalRecords",total);
        return new ResponseEntity<>(jo,HttpStatus.OK);
    }

    /**
     * 统计图片总数量
     * @param guoname
     * @return
     */
    @GetMapping("/tupianCount")
    public ResponseEntity<?> tupianCount(String guoname){
        int count = houTaitupianService.tupianCount(guoname);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /**
     * 添加图片信息
     * @param uplx
     * @param guoname
     * @param
     * @return
     */
    @PostMapping("/tupianAddList")
    public ResponseEntity<?> tupianAddList(@RequestParam(value = "file",required = false)MultipartFile uplx,
                                           @RequestParam("guoname") String guoname,
                                           @RequestParam("guoid") int guoid
                                       ){
        String filePath = null;
        if (!uplx.isEmpty()){
            try {
                /*文件保存路径*/
                filePath = "D:/nginx-1.16.0/html/lvyou0823/img/"+guoname+".jpg";
                /*转存路径*/
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
    }

    /**
     *动态查询所有国家名字
     * @return
     */
    @GetMapping("/queryGuoJiaList")
    public ResponseEntity<?> queryGuoJiaList(){
        List<guojialist> guojialistList = houTaitupianService.queryGuoJiaList();
        return new ResponseEntity<>(guojialistList,HttpStatus.OK);
    }

    /**
     *根据图片id删除图片信息
     * @param id
     * @return
     */
    @DeleteMapping("/tupianDelete")
    public ResponseEntity<?> tupianDelete(Integer id){
        int i = houTaitupianService.tupianDelete(id);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 查询单条信息
     * @param id
     * @return
     */
    @GetMapping("/tupianSelect")
    public ResponseEntity<?> tupianSelect(Integer id){
        tupian tupian = houTaitupianService.tupianSelect(id);
        return new ResponseEntity<>(tupian,HttpStatus.OK);
    }

    /**
     *修改图片信息
     * @param file
     * @param guoname
     * @param id
     * @param tp
     * @return
     */
    @PostMapping("/updtupianList")
    public ResponseEntity<?> updtupianList(@RequestParam(value = "file",required = false)MultipartFile file,
                                           @RequestParam("guoname")String guoname,
                                           @RequestParam("id")int id,
                                           @RequestParam("guoid")int guoid,
                                           @RequestParam("tp")String tp){
        String filePath = null;
        if(file!=null) {
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
                    filePath = "D:/nginx-1.16.0/html/lvyou0823/img/"+guoname+".jpg";
                    System.out.println(filePath);
                    // 转存文件
                    file.transferTo(new File(filePath));
                    filePath = "img/" + guoname + ".jpg";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            filePath = tp;
        }
        tupian tupian = new tupian();
        tupian.setId(id);
        tupian.setGuoname(guoname);
        tupian.setTpurl(filePath);
        tupian.setGuoid(guoid);
        System.out.println(tupian);
        int count = houTaitupianService.tupianUpdate(tupian);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
