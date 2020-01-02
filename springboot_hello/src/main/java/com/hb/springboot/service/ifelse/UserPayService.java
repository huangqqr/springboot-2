package com.hb.springboot.service.ifelse;

import java.math.BigDecimal;

/**
 * @author: Dr.HuangBo
 * @since: 2019-10-29 09:13
 **/
public interface UserPayService {
    /**
     * 计算应付价格
     */
    public BigDecimal quote(BigDecimal orderPrice);
}
