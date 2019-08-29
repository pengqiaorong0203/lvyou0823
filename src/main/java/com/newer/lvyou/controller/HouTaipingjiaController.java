package com.newer.lvyou.controller;

import com.newer.lvyou.domain.pingjia;
import com.newer.lvyou.service.HouTaipingjiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouTaipingjiaController {

    @Autowired
    private HouTaipingjiaService houTaipingjiaService;

    /**
     * 显示所有用户评价详细信息
     * @return
     */
    @GetMapping("/findAllpingjia")
    public ResponseEntity<?> findAllpingjia() {
        List<pingjia> pingjiaList = houTaipingjiaService.findAllpingjia();
        return new ResponseEntity<>(pingjiaList,HttpStatus.OK);
    }

    /**
     * 新增用户评价信息
     * @param pingjia
     * @return
     */
    @PostMapping("/pingjiaAdd")
    public ResponseEntity<?> pingjiaAdd(pingjia pingjia) {
        int i = houTaipingjiaService.pingjiaAdd(pingjia);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据用户id删除用户评价信息
     * @param id
     * @return
     */
    @DeleteMapping("/pingjiaDelete/{id}")
    public ResponseEntity<?> pingjiaDelete(Integer id) {
        int i = houTaipingjiaService.pingjiaDelete(id);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 修改用户评价详细信息
     * @param pingjia
     * @return
     */
    @PostMapping("/pinjiaUpdate")
    public ResponseEntity<?> pinjiaUpdate(pingjia pingjia) {
        int i = houTaipingjiaService.pinjiaUpdate(pingjia);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 统计用户评价总数量
     * @return
     */
    @GetMapping("/pingjiaCount")
    public ResponseEntity<?> pingjiaCount() {
        int count = houTaipingjiaService.pingjiaCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
