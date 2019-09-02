package com.hb.springboot.controller;

import com.hb.springboot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloWord
 * @author: huangbo
 * @create: 2019-09-02 15:15
 **/

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Article hello(){
        Article article1 = Article.builder().id(3L).author("莫言211122").build();
        log.info("测试一下" + article1);
        return article1;
    }
}