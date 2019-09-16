package com.hb.springboot.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * 因为没有@Component注解所以要在启动类上添加下面代码   用来注册到上下文
 * context.addApplicationListener(new MyListener1());
*/
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
    }
}