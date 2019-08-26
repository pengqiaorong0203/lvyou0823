package com.newer.lvyou.controller;

import com.newer.lvyou.util.SecurityCode;
import com.newer.lvyou.util.SecurityImage;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录
 */
public class HoutaiController {

    private String string;

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

}
