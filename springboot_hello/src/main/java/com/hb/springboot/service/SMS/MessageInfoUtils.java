package com.hb.springboot.service.SMS;

public class MessageInfoUtils {
    /**
     * 新增会员
     */
    public static final String MESSAGE_TEMPLETE_ADD = "恭喜您开通%s会员，关注微信公众号将有更多惊喜哦。【%s】";
    /**
     * 会员储值消费
     */
    public static final String MESSAGE_TEMPLETE_CONSUME = "%s会员，您使用会员储值支付%s元，如非本人操作请联系【%s】%s。";
    /**
     * 更换手机号
     */
    public static final String MESSAGE_TEMPLETE_CHANGE = "验证码：%s，尊敬的会员，您正在使用手机号更换服务[验证码告知他人将导致账号被盗，请勿泄露]【%s】。";
    /**
     * 积分调整
     */
    public static final String MESSAGE_TEMPLETE_POINT_ADJUST = "您的积分%s%s积分，调整后积分为：%s分，如有疑问请致电%s【%s】";
    /**
     * 余额调整
     */
    public static final String MESSAGE_TEMPLETE_BALANCE_ADJUST = "您的余额%s%s元，调整后储值余额为：%s元，如有疑问请致电%s【%s】";
    /**
     * 充值
     */
    public static final String MESSAGE_TEMPLETE_RECHARGE = "您已充值%s元，充值后储值余额为：%s元，如有疑问请致电%s【%s】";

    /**
     * 新增会员
     */
    public static String getMessageForADD(String merchName) {
        return String.format(MESSAGE_TEMPLETE_ADD, merchName);
    }

    /**
     * 会员储值消费
     */
    public static String getMessageForCONSUME(String phone, String tranAmount, String storeName, String telephone) {
        return String.format(MESSAGE_TEMPLETE_CONSUME, phone, tranAmount, storeName, telephone);
    }

    /**
     * 更换手机号
     */
    public static String getMessageForCHANGE(String verCode, String merchName) {
        return String.format(MESSAGE_TEMPLETE_CHANGE, verCode, merchName);
    }

    /**
     * 积分调整
     */
    public static String getMessageForPOINTADJUST(String adjustType, String adjustNum, String afterPoint, String storeName, String telephone) {
        return String.format(MESSAGE_TEMPLETE_POINT_ADJUST, adjustType, adjustNum, afterPoint, storeName, telephone);
    }

    /**
     * 余额调整
     */
    public static String getMessageForBALANCEADJUST(String adjustType, String adjustNum, String afterAmount, String storeName, String telephone) {
        return String.format(MESSAGE_TEMPLETE_BALANCE_ADJUST, adjustType, adjustNum, afterAmount, storeName, telephone);
    }

    /**
     * 充值
     */
    public static String getMessageForRECHARGE(String rechargeAmount, String availableAmount, String storeName, String telephone) {
        return String.format(MESSAGE_TEMPLETE_RECHARGE, rechargeAmount, availableAmount, storeName, telephone);
    }
}

