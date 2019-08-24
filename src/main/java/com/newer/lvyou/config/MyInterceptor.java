package com.newer.lvyou.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newer.lvyou.domain.ResponseData;
import com.newer.lvyou.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//自定义的拦截器
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Value("${auth.header}") //去application.yml 获取auth.header的值
    private String header;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入了preHandle的方法。。。");
        try {
            String token = request.getHeader(header);
            if (token != null) {
                //token = token.substring(7);
                String username = jwtTokenUtil.getUsernameByToken(token);
                if (username != null) {
                    return true;
                } else {
                    responseMsg(response);
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            responseMsg(response);
        }
        responseMsg(response);
        return false;
    }

    //响应输出错误信息
    private void responseMsg(HttpServletResponse response){
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            ResponseData responseData = new ResponseData("403","forbidden");
            ObjectMapper objectMapper = new ObjectMapper();
            String strData = objectMapper.writeValueAsString(responseData);
            out.print(strData);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入了postHandle的方法。。。。。");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入了afterCompletion的方法。。。。");
    }
}
