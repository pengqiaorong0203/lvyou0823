package com.newer.lvyou.controller;

import com.newer.lvyou.domain.GuojialistDrawTable;
import com.newer.lvyou.domain.GuojialistDrawTableCount;
import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.service.HouTaidrawTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HouTaidrawTableController {

    /**
     * 实现列的注入
     * 实现每个洲的国家注入
     */
    @Autowired
    private HouTaidrawTableService houTaidrawTableService;

    @GetMapping("/drawTable")
    public ResponseEntity<?> drawTable(){
        /*封装，设置表头显示*/
        List<String> timeList = new ArrayList<>();
        timeList.add("今天");
        timeList.add("昨天");
        timeList.add("本周");
        timeList.add("本月");
        timeList.add("本季度");

        /*查询所有洲的国家集合*/
        List<guojialist> guojialistList = houTaidrawTableService.findGuoJiaAll();
        /*各大洲的国家对象集合*/
        List<GuojialistDrawTable> guojialistDrawTableList = new ArrayList<>();
        /*循环遍历所有洲的国家*/
        for (guojialist guojialists:guojialistList
                ) {
            /*获取各大洲的名称*/
            String zhouname = guojialists.getZhouname();
            /*获取gid旅行社今天的金额*/
            int today = houTaidrawTableService.getToday(guojialists.getId());
            /*获取gid旅行社昨天的金额*/
            int yesterday = houTaidrawTableService.getYesterday(guojialists.getId());
            /*获取gid旅行社本周的金额*/
            int week = houTaidrawTableService.getWeek(guojialists.getId());
            /*获取gid旅行社本月的金额*/
            int month = houTaidrawTableService.getMonth(guojialists.getId());
            /*获取gid旅行社本季度的金额*/
            int quarter = houTaidrawTableService.getQuarter(guojialists.getId());
            /*将金额封装到countList中*/
            List<Integer> countList = new ArrayList<>();
            countList.add(today);
            countList.add(yesterday);
            countList.add(week);
            countList.add(month);
            countList.add(quarter);
            guojialistDrawTableList.add(new GuojialistDrawTable(zhouname,countList));
        }
        return new ResponseEntity<>(new GuojialistDrawTableCount(timeList,guojialistDrawTableList),HttpStatus.OK);
    }

    /**
     * 绘制柱状图方法
     * @return
     */
    @GetMapping("/drawPic")
    public ResponseEntity<?> drawPic(){
        /*使用HashMap*/
        List<Map<String,Object>> list = new ArrayList<>();
        /*查询所有洲的国家*/
        List<guojialist> guojialistList = houTaidrawTableService.findGuoJiaAll();
        for (guojialist guojialists:guojialistList
                ) {
            Map<String,Object> map = new HashMap<>();
            map.put("name",guojialists.getZhouname());
            map.put("y",houTaidrawTableService.getQuarter(guojialists.getId())/10000);
            map.put("drilldown",guojialists.getZhouname());
            list.add(map);
        }
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * 查询各州所有国家名字
     * @return
     */
    @GetMapping("/findGuoJiaAll")
    public ResponseEntity<?> findGuoJiaAll(){
        List<guojialist> guojialistList = houTaidrawTableService.findGuoJiaAll();
        return new ResponseEntity<>(guojialistList,HttpStatus.OK);
    }
}
