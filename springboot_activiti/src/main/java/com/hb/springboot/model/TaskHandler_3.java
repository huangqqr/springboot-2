package com.hb.springboot.model;

import com.hb.springboot.service.EmployeeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 15:06
 **/

public class TaskHandler_3 implements TaskListener {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeService employeeService;
    @Override
    public void notify(DelegateTask delegateTask) {
        Long deptId = 3l;
        List<Employee> list = service.getEmployeeByDeptId(deptId);
        //delegateTask.setAssignee();
        if (list != null && list.size() > 0) {
            for (Employee emp : list) {
                delegateTask.addCandidateUser(emp.getName());
            }
        }
    }
}