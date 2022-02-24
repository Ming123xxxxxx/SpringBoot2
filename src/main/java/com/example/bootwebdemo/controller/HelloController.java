package com.example.bootwebdemo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/9 10:47
 */
@RestController
public class HelloController {

    //@GetMapping("/user")==@RequestMapping(method = {RequestMethod.GET}
    @GetMapping("/user")
    public String getuser(){
        return "GET----";
    }

    //@PostMapping("/user")==@RequestMapping(method = {RequestMethod.POST}
    @PostMapping("/user")
    public String saveuser(){
        return "POST----";
    }

    //@DeleteMapping("/user")==@RequestMapping(method = {RequestMethod.DELETE}
    @DeleteMapping("/user")
    public String deleteuser(){
        return "DELETE----";
    }

    //@PutMapping("/user")==@RequestMapping(method = {RequestMethod.PUT}
    @PutMapping("/user")
    public String putuser(){
        return "PUT----";
    }
}
