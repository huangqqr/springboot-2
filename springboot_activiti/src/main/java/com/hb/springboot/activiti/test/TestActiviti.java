package com.hb.springboot.activiti.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hb.springboot.util.CommUtil;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-11 14:09
 **/

@JsonIgnoreProperties(value = { "handler" })
@RestController
@RequestMapping("/work")
public class TestActiviti {
    @Autowired
    ProcessEngine processEngine;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired
    IdentityService identityService;
    @Autowired
    ManagementService managementService;

    @RequestMapping("/hello")
    public List<String> hello() {
        List<String> list = new ArrayList<>();
        list.add("hahah");
        list.add("heheh");
        list.add("nnnn");
        return list;
    }

    /**
     * 部署流程定义
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void deploymentProcessDefinition() {
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("helloworld入门程序")//添加部署的名称
                .addClasspathResource("processes/xxx.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("processes/xxx.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID：" + deployment.getId());//1
        System.out.println("部署名称：" + deployment.getName());//helloworld入门程序
    }

    /**启动流程实例*/
    @RequestMapping(value = "/star", method = RequestMethod.GET)
    public void startProcessInstance(){
        //流程定义的key
        String processDefinitionKey = "xx";
        ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
        System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4
    }

    /**
     * 查询组任务
     */
    @ResponseBody
    @RequestMapping("/taskList")
    public List<Map<String, Object>> findCandidateUserTask() {

        //String candidateUser = user.getUserName();
        String candidateUser = "张三";
        //List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee(candidateUser).list();
        List<Task> list = taskService.createTaskQuery().taskCandidateUser(candidateUser).list();
        List<Map<String, Object>> listMap = new ArrayList<>();
        // 循环
        String[] ps = { "name", "id", "processInstanceId","executionId" };
        for (Task task : list) {
            Map<String, Object> map = CommUtil.obj2map(task, ps);
            listMap.add(map);
        }
        return listMap;
    //}
    //    return list;
    }


    public List<Map<String, Object>> ProcessDefinationList() {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<Map<String, Object>> listMap = new ArrayList<>();
        // 目标类
        List<ProcessDefinition> list = processDefinitionQuery.list();
        // 循环
        String[] ps = { "id", "name", "version", "key", "diagramResourceName", "resourceName", "deploymentId",
                "suspensionState" };
        for (ProcessDefinition pd : list) {
            Map<String, Object> map = CommUtil.obj2map(pd, ps);
            listMap.add(map);
        }
        return listMap;
    }
}