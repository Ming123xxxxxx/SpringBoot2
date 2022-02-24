package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/17 9:59
 */
//文件上传测试
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String from_layous(){

        return "form/form_layouts";
    }

    //MultipartFile:自动封装上传过来的文件
    @PostMapping("/upload")
    public String  upload(@RequestParam("email") String email,
                          @RequestParam("username") String username,
                          @RequestPart("headerImg") MultipartFile headerImg,
                          @RequestPart("photos") MultipartFile[] photos){

        try {
            if(!headerImg.isEmpty()){
                //保存到文件服务器,oss服务器
                String originalFilename = headerImg.getOriginalFilename();
                headerImg.transferTo(
                        new File("D:\\IntelliJ IDEA 2020.1\\boot-webdemo\\BackAdmin\\src\\main\\resources\\static\\header\\"+originalFilename)
                );
            }
            if(photos.length>0){
                for(MultipartFile photo:photos){
                    if(!photo.isEmpty()){
                        String originalFilename = photo.getOriginalFilename();
                        photo.transferTo(
                                new File("D:\\IntelliJ IDEA 2020.1\\boot-webdemo\\BackAdmin\\src\\main\\resources\\static\\photos\\"+originalFilename)
                        );
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "main";
    }
}
