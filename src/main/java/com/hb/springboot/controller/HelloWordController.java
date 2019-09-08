package com.hb.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试HelloWord
 * @author: huangbo
 * @create: 2019-09-08 20:40
 **/

@RestController
@RequestMapping(value = "test")
public class HelloWordController {

    @RequestMapping(value = "hello")
    public String hello () {
        return "Hello 阿博";
    }
}