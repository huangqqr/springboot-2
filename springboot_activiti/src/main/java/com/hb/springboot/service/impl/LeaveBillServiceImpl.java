package com.hb.springboot.service.impl;

import com.hb.springboot.mapper.LeaveBillMapper;
import com.hb.springboot.model.LeaveBill;
import com.hb.springboot.service.LeaveBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 11:26
 **/

@Service
public class LeaveBillServiceImpl implements LeaveBillService {

    @Autowired
    private LeaveBillMapper mapper;


    @Override
    public boolean saveLeave(LeaveBill leaveBill) {
        boolean flag = false;
        int insert = mapper.insert(leaveBill);
        if (insert > 0) flag = true;
        return flag;
    }

    @Override
    public LeaveBill selectByPrimaryKey(Long id) {
        LeaveBill leaveBill = mapper.selectByPrimaryKey(id);
        return leaveBill;
    }

    @Override
    public void updateByPrimaryKeySelective(LeaveBill leaveBill) {
        mapper.updateByPrimaryKeySelective(leaveBill);
    }
}