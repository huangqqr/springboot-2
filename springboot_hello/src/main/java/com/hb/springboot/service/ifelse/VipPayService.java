package com.hb.springboot.service.ifelse;

import java.math.BigDecimal;

/**
 * @author: Dr.HuangBo
 * @since: 2019-10-29 09:15
 **/
public class VipPayService implements UserPayService {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        //该用户超级会员刚过期并且尚未使用过临时折扣
        if(true){
            //临时折扣使用次数更新();
           // returen 8折价格;
        }
        //return 9折价格;
        return null;
    }
}