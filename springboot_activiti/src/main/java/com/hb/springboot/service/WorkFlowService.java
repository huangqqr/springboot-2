package com.hb.springboot.service;


import com.hb.springboot.model.Result;
import com.hb.springboot.model.WorkFlow;

/**
 * @author huangbo on 2019/9/5
 */
public interface WorkFlowService {
    /**流程列表*/
    Result deploymentList();

    /**流程部署*/
    Result ProcessDeployment();

    /**启动流程实例，让启动的流程实例关联业务*/
    Result startProcess(WorkFlow workFlow);
}
