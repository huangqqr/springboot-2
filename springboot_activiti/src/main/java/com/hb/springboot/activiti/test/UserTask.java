package com.hb.springboot.activiti.test;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-11 15:04
 **/

public class UserTask  implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {

        delegateTask.addCandidateUser("张三");
        delegateTask.addCandidateUser("李四");
        delegateTask.addCandidateUser("王五");
    }
}