package com.guangzhaohui.lrps.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李晨辉
 * @date 2019-09-29
 */
@RestController
public class CommonController {
    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
