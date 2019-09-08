package com.hb.springboot.service;


import com.hb.springboot.model.LeaveBill;

/**
 * @author huangbo on 2019/9/5
 */
public interface LeaveBillService {

    boolean saveLeave(LeaveBill leaveBill);
    LeaveBill selectByPrimaryKey(Long id);
    void updateByPrimaryKeySelective(LeaveBill leaveBill);


}
