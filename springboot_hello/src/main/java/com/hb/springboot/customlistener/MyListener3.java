package com.hb.springboot.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * 要在application.yml中添加如下的配置信息
 * context:
 * listener:
 * classes: com.hb.springboot.customlistener.MyListener3
 */
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
    }
}