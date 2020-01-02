package com.hb.springboot.controller;

import com.hb.springboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-16 16:40
 **/

@RestController
public class MailController {
    @Autowired
    private MailService mailService;


    /**
     * 事件的产生方
     */
    @RequestMapping("/mail")
    public String hello() {
        mailService.sendMail();
        //TODO 业务处理

        return "发送成功";
    }

}