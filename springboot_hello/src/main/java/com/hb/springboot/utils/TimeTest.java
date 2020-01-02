package com.hb.springboot.utils;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/12/12.
 */
public class TimeTest {
    public static void main(String[] args){
        String password = "12345678889";
        System.out.println(password.substring(0,1));
        System.out.println(password.substring(password.length()-1));
        //System.out.println("DateUtil获取离一天结束还有多少时间：");
        //getDateUtilsTime();
        //System.out.println("DateTime获取离一天结束还有多少时间：");
        //getDateTimeTime();
        //System.out.println("LocalDateTime获取离一天结束还有多少时间：");
        //getLocalDateTimeTime();
    }

    public static void getDateUtilsTime() {

        //方法一
        long milliSecondsLeftToday = 86400000 - DateUtils.getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE);
        long secondsLeftToday = 86400 - DateUtils.getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE);
        System.out.println("当天剩余毫秒1：" + milliSecondsLeftToday);
        System.out.println("当天剩余秒1：" + secondsLeftToday);
    }

    public static void getDateTimeTime() {
        //方法二
        DateTime dateTime = new DateTime().millisOfDay().withMaximumValue();
        long millSeconds2 = new Duration(new DateTime(), dateTime).getMillis();
        long count = new Duration(new DateTime(), dateTime).getStandardSeconds();
        System.out.println("当天剩余毫秒2：" + millSeconds2);
        System.out.println("当天剩余秒2：" + count);
    }

    public static void getLocalDateTimeTime() {
        //方法三:LocalDateTime和ChronoUnit为1.8新增
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long millSeconds = ChronoUnit.MILLIS.between(LocalDateTime.now(), midnight);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        System.out.println("当天剩余毫秒3：" + millSeconds);
        System.out.println("当天剩余秒3：" + seconds);

    }



}
