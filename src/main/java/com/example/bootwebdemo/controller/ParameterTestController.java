package com.example.bootwebdemo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/10 11:13
 */
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable  Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> handler,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-9fc1cdf3") String idea,
                                     @CookieValue("Idea-9fc1cdf3") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("name",username);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("handers",handler);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("Idea-9fc1cdf3",idea);
        System.out.println(cookie.getName()+"----"+cookie.getValue());
        return map;
    }


    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map=new HashMap<>();
        map.put("content",content);
        return map;
    }

    //1.语法：/cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认是禁用了矩阵变量的功能
    //3.手动开启:原理:对于路径的处理，UrlPathHelper进行解析,removeSemicolonContent(移除分号内容)支持矩阵变量
    //4.矩阵变量必须有url变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carssell(@MatrixVariable Integer low,
                        @MatrixVariable List<String> brand,
                        @PathVariable("path") String pa){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",pa);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
                    ){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
