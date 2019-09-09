package com.newer.lvyou.controller;

import com.newer.lvyou.domain.guojialist;
import com.newer.lvyou.domain.lvyouxiangqing;
import com.newer.lvyou.mapper.QianTaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class QianTaiContorller {

    @Autowired
    private QianTaiMapper qianTaiMapper;

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
}
