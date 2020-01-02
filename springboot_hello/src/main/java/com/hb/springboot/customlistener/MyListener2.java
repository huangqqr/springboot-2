package com.hb.springboot.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    /**
     * 事件的消费方
     */
    public void onApplicationEvent(MyEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO 发送邮件代码
        log.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
    }

}