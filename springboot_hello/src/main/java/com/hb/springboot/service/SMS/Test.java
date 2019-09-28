package com.hb.springboot.service.SMS;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-19 15:47
 **/

public class Test {

    public void send () throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        int month = 6;
        int day  = 13;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("month",String.valueOf(month));
        map.put("day",String.valueOf(day));

        String template = "申请于${month}月${day}日已审核通过，款项将于7个工作日返回支付宝账户。请注意查收。";
        String str = StringUtils.reString(template, map);

        System.out.println(str);
    }
}