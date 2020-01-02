package com.hb.springboot.service.SMS;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-19 15:47
 **/

public class Test {

    public static void main(String[] args){
        Test test = new Test();
        try {
            test.send();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void send() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        int month = 6;
        int day = 13;
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("month", String.valueOf(month));
        //map.put("day", String.valueOf(day));
        map.put("title","测试"); //工单标题
        map.put("createTime",new Date()); //工单创建时间
        map.put("number","1000"); //工单编号

        String template = "Hi，亲爱的${name}，你的验证码${number}，请使用。。。";
        //String template = "申请于${month}月${day}日已审核通过，款项将于7个工作日返回支付宝账户。请注意查收。";
        String str = StringUtils.reString(template, map);


        System.out.println(str);
    }
}