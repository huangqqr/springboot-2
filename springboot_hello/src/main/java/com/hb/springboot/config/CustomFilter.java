package com.hb.springboot.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Description: 过滤器  缺点：没有办法明确去指定执行的顺序
 * @WebFilter(filterName="customFilter",urlPatterns={"/*"}) 加注解不要使用FilterRegistration与CustomFilter2
 * @Param:
 * @return:
 * @Author: huangbo
 * @Date: 2019/9/15
 */
//注册器名称为customFilter,拦截的url为所有
//@WebFilter(filterName="customFilter",urlPatterns={"/*"})
@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("customFilter 请求处理之前");
        //对request、response进行一些预处理
        // 比如设置请求编码
        // request.setCharacterEncoding("UTF-8");
        // response.setCharacterEncoding("UTF-8");

        //链路 直接传给下一个过滤器
        chain.doFilter(request, response);

        log.info("customFilter 请求处理之后");
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}