package com.hb.springboot.service.ifelse;

import java.math.BigDecimal;

/**
 * @author: Dr.HuangBo
 * @since: 2019-10-29 09:14
 **/
public class ParticularlyVipPayService implements UserPayService {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        //"消费金额大于30元"
        if (true) {
            //return 7折价格;
            return null;
        }
        return null;
    }
}