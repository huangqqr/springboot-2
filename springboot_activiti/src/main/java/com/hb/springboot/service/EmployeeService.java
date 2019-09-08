package com.hb.springboot.service;


import com.hb.springboot.model.Employee;

import java.util.List;

/**
 * @author huangbo on 2019/9/5
 */
public interface EmployeeService {
    List<Employee> getEmployeeByDeptId(Long deptId);
}
