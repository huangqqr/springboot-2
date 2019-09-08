package com.hb.springboot.mapper;


import com.hb.springboot.model.LeaveBill;

public interface LeaveBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveBill record);

    int insertSelective(LeaveBill record);

    LeaveBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaveBill record);

    int updateByPrimaryKey(LeaveBill record);
}