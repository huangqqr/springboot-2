package com.hb.springboot.mapper;


import com.hb.springboot.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByDeptId(Long deptId);
}