package com.hb.springboot.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/** 
* @Description: 监听器
 * 监听器：可以在这里记录访问次数哦
 * customFilter 请求处理之前
 * customFilter2 请求处理之前
 * controller或servlet
 * customFilter2 请求处理之后
 * customFilter 请求处理之后
 * request监听器：销毁
* @Param:  
* @return:  
* @Author: huangbo
* @Date: 2019/9/15 
*/
@WebListener
@Slf4j
public class Customlister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info(" request监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info(" request监听器：可以在这里记录访问次数哦");
    }

}