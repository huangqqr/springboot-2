package com.hb.springboot.service.SMS;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-19 15:13
 **/

public class Stance {
    /**
     * 更换/绑定手机号
     */
    public static final Integer AUTHCODETYPE_MOD = 1;
    /**
     * 付款
     */
    public static final Integer AUTHCODETYPE_PAY = 2;
    /**
     * 新增会员
     */
    public static final Integer AUTHCODETYPE_ADD = 3;
    /**
     * 会员储值消费
     */
    public static final Integer AUTHCODETYPE_CONSUME = 4;
    /**
     * 更换手机号
     */
    public static final Integer AUTHCODETYPE_CHANGE = 5;
    /**
     * 积分调整
     */
    public static final Integer AUTHCODETYPE_POINT_ADJUST = 6;
    /**
     * 余额调整
     */
    public static final Integer AUTHCODETYPE_BALANCE_ADJUST = 7;
    /**
     * 充值
     */
    public static final Integer AUTHCODETYPE_RECHARGE = 8;

}