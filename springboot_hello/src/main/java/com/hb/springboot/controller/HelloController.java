package com.hb.springboot.controller;

import com.hb.springboot.config.exception.Result;
import com.hb.springboot.model.Article;
import com.hb.springboot.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: HelloWord
 * @author: huangbo
 * @create: 2019-09-02 15:15
 **/

@Slf4j
@RestController
public class HelloController {

    @Resource
    ExceptionService exceptionService;

    @RequestMapping("/hello")
    public String hello() {
        log.info("Hello 阿博");
        return "Hello 阿博....";
    }

    @RequestMapping("/article")
    public Article article() {
        Article article = Article.builder().id(3L).author("莫言211122").build();
        log.info("测试一下" + article);
        return article;
    }

    @RequestMapping("/ex/system")
    public Result system() {

        exceptionService.systemBizError();

        return Result.success();
    }


    @RequestMapping("/ex/user")
    public Result user(Integer input) {

        return Result.success(exceptionService.userBizError(input));
    }
}