package com.hb.springboot.service.impl;

import com.hb.springboot.model.LeaveBill;
import com.hb.springboot.model.Result;
import com.hb.springboot.model.WorkFlow;
import com.hb.springboot.service.LeaveBillService;
import com.hb.springboot.service.WorkFlowService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 15:39
 **/

@Service
public class WorkFlowServiceImpl implements WorkFlowService {
    @Autowired
    private LeaveBillService leaveBillService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private FormService formService;
    @Autowired
    private HistoryService historyService;

    @Override
    public Result deploymentList() {
        List<Deployment> list = repositoryService.createDeploymentQuery()
                .orderByDeploymenTime().desc()
                .list();
        Result result = new Result(true,list);
        return result;
    }

    /**流程部署*/
    @Override
    public Result ProcessDeployment() {
        Result result;
        Deployment deploy = repositoryService.createDeployment()
                .name("请假流程")
                .addClasspathResource("diagrams/leaveBill.bpmn")
                .addClasspathResource("diagrams/leaveBill.png")
                .deploy();
        if (deploy != null){
            result = new Result("部署成功",true);
        }else {
            result = new Result("部署失败",false);
        }
        return result;
    }

    /**启动流程实例，让启动的流程实例关联业务*/
    @Override
    public Result startProcess(WorkFlow workFlow) {
        Result result = new Result();
        /**
         * 1.获取业务表id，查询业务表对象实体对象
         * 2.更新业务实体对象状态
         * 3：使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
        */
        //1.获取业务表id，查询业务表对象实体对象
        Long leaveId = workFlow.getLeaveId();
        LeaveBill leaveBill = leaveBillService.selectByPrimaryKey(leaveId);
        //更新业务实体对象状态
        leaveBill.setState(1);
        leaveBillService.updateByPrimaryKeySelective(leaveBill);
        //3：使用当前对象获取到流程定义的key（对象的名称就是流程定义的key  要保持一致）
        String key = LeaveBill.class.getSimpleName();
        String objId = key + "." + leaveBill;
        Map<String, Object> variables = new HashMap<String,Object>();
        variables.put("objId",objId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, objId, variables);
        if (processInstance != null){
            result = new Result("启动成功",true);
        }else {
            result = new Result("启动失败",false);
        }
        return result;
    }
}