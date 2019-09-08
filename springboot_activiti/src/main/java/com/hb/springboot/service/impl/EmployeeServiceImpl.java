package com.hb.springboot.service.impl;

import com.hb.springboot.mapper.EmployeeMapper;
import com.hb.springboot.model.Employee;
import com.hb.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 13:11
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<Employee> getEmployeeByDeptId(Long deptId) {
        List<Employee> employees = mapper.getEmployeeByDeptId(deptId);
        return employees;
    }
}