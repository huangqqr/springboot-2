package com.hb.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @Description: 实现拦截器
 * * request监听器：可以在这里记录访问次数哦
 *  * customFilter 请求处理之前
 *  * customFilter2 请求处理之前
 *  * preHandle:请求前调用
 *  * Hello 阿博
 *  * postHandle:请求后调用
 *  * customFilter2 请求处理之后
 *  * customFilter 请求处理之后
 *  * request监听器：销毁
 *
 *
 *  * request监听器：可以在这里记录访问次数哦
 *  * customFilter 请求处理之前
 *  * customFilter2 请求处理之前
 *  * customFilter2 请求处理之后
 *  * customFilter 请求处理之后
 *  * request监听器：销毁
* @Param:  
* @return:  
* @Author: huangbo
* @Date: 2019/9/15 
*/
@Slf4j
public class CustomHandlerInterceptor implements HandlerInterceptor {

 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
   throws Exception {
  log.info("preHandle:请求前调用");
  //返回 false 则请求中断
  return true;
 }

 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                        ModelAndView modelAndView) throws Exception {
  log.info("postHandle:请求后调用");

 }

 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  log.info("afterCompletion:请求调用完成后回调方法，即在视图渲染完成后回调");

 }

}