package com.hb.springboot.customlistener;

import org.springframework.context.ApplicationEvent;

/** 
* @Description: 编写事件源
* @Param:  
* @return:  
* @Author: huangbo
* @Date: 2019/9/16 
*/
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    /**
    * 1.先创建一个消息实体类
     * MessageEntity{String message;String code;}
     * private MessageEntity messageEntity;
     *
     * public MyEvent(Object source, MessageEntity messageEntity) {
     *         super(source);
     *         this.messageEntity = messageEntity;
     *     }
     * public MessageEntity getMessageEntity(){
     *     return this.messageEntity;
     * }
    */
    /**事件*/
    public MyEvent(Object source) {
        super(source);
    }
}