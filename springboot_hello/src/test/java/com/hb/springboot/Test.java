package com.hb.springboot;

import com.hb.springboot.service.SMS.StringUtils;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void send () {
        int month = 6;
        String aa = "diheh";
        int day  = 13;
        int cc = 19;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("month",String.valueOf(month));
        map.put("aa",aa);
        map.put("day",String.valueOf(day));
        map.put("cc",String.valueOf(cc));

        String template = "申请于${month}月${day}日已审核通过，款项将于7个工作日返回支付宝账户。请注意查收。";
        String str = null;
        try {
            str = StringUtils.reString(template, map);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(str);
    }
}