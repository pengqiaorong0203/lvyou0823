package com.newer.lvyou.controller;

import com.newer.lvyou.domain.jiudian;
import com.newer.lvyou.domain.tuandui;
import com.newer.lvyou.service.HouTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class HoutaiContorller {

    @Autowired
    private HouTaiService houTaiService;

    @GetMapping("/queryTD")
    public ResponseEntity<?> queryTD(){
        List<tuandui> list = houTaiService.selectTD();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/addTD")
    public ResponseEntity<?> addTD(tuandui td){
        int count = houTaiService.addTD(td);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @PostMapping("/updTD")
    public ResponseEntity<?> updTd(tuandui td){
        int count = houTaiService.updTD(td);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/delTD")
    public ResponseEntity<?> delTD(int id){
        int count = houTaiService.delTD(id);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/queryJD")
    public ResponseEntity<?> queryJD(){
        List<jiudian> list = houTaiService.selectJD();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
