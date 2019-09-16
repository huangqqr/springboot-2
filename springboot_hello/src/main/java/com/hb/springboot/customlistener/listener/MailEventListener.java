package com.hb.springboot.customlistener.listener;

import com.hb.springboot.customlistener.MailEvent;
import com.hb.springboot.model.MailEntity;
import com.hb.springboot.service.SendMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-16 16:52
 **/

@Component
@Slf4j
public class MailEventListener implements ApplicationListener<MailEvent> {

    @Autowired
    private SendMail sendMail;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.receptionMail.addr}")
    private String receptionMailAddr;

    @Override
    public void onApplicationEvent(MailEvent mailEvent) {
        MailEntity entity = mailEvent.getMailEntity();
        Context context = new Context();
        context.setVariable("username",receptionMailAddr);
        context.setVariable("name",entity.getClass().getName());
        context.setVariable("code",entity.getCode());
        String send = String.valueOf(context);
        //格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        context.setVariable("occurredTime",sdf.format(new Date()));
        sendMail.sendTextMail(receptionMailAddr,"Hello Word",send);

        log.info("名称：" + entity.getName() + " 状态：" + entity.getCode());
    }
}