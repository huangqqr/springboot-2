package com.hb.springboot.service.impl;

import com.hb.springboot.customlistener.MailEvent;
import com.hb.springboot.model.MailEntity;
import com.hb.springboot.service.MailService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-16 16:42
 **/

@Service
public class MailServiceImpl implements MailService {
    @Resource
    ConfigurableApplicationContext applicationContext;

    @Override
    public void sendMail() {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setCode("200");
        mailEntity.setName("冤大头，大嘴巴");
        applicationContext.publishEvent(new MailEvent("邮件内容", mailEntity));
    }
}