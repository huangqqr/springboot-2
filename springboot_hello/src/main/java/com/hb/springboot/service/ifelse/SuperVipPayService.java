package com.hb.springboot.service.ifelse;

import java.math.BigDecimal;

/**
 * @author: Dr.HuangBo
 * @since: 2019-10-29 09:15
 **/
public class SuperVipPayService implements UserPayService {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        //return 8折价格;
        return null;
    }
}