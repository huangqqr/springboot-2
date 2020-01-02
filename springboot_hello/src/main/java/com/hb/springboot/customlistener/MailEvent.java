package com.hb.springboot.customlistener;

import com.hb.springboot.model.MailEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-16 16:50
 **/

public class MailEvent extends ApplicationEvent {
    private MailEntity mailEntity;

    /**
     * 事件
     */
    public MailEvent(Object source, MailEntity mailEntity) {
        super(source);
        this.mailEntity = mailEntity;
    }

    public MailEntity getMailEntity() {
        return this.mailEntity;
    }
}