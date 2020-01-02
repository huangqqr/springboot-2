package com.hb.springboot.service.ifelse;

public class Test {
    public static void main(String[] args) {
        UserPayService strategy = new VipPayService();
        ////BigDecimal quote = strategy.quote(300);
        //System.out.println("普通会员商品的最终价格为：" + quote.doubleValue());
        //strategy = new SuperVipPayService();
        //quote = strategy.quote(300);
        //System.out.println("超级会员商品的最终价格为：" + quote.doubleValue());
    }
}