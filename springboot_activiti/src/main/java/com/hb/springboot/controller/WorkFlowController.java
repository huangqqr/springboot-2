package com.hb.springboot.controller;

import com.hb.springboot.model.Result;
import com.hb.springboot.model.WorkFlow;
import com.hb.springboot.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 15:38
 **/

@Controller
@RequestMapping("/workFlow")
public class WorkFlowController {

    @Autowired
    private WorkFlowService workFlowService;

    /** 
    * @Description: 流程列表
    * @Param: [] 
    * @return: com.hb.ssm.sys.model.Result 
    * @Author: huangbo
    * @Date: 2019/9/5 
    */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result deploymentList(){
        Result result = workFlowService.deploymentList();
        return result;
    }


    /** 
    * @Description: 流程部署
    * @Param: [] 
    * @return: com.hb.ssm.sys.model.Result 
    * @Author: huangbo
    * @Date: 2019/9/5 
    */
    @ResponseBody
    @RequestMapping(value = "/deploy", method = RequestMethod.GET)
    public Result ProcessDeployment(){
        Result result = workFlowService.ProcessDeployment();
        return result;
    }

    /** 
    * @Description: 启动流程实例，让启动的流程实例关联业务
    * @Param: [] 
    * @return: com.hb.ssm.sys.model.Result 
    * @Author: huangbo
    * @Date: 2019/9/5 
    */
    @ResponseBody
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public Result startProcess(WorkFlow workFlow){
        Result result = workFlowService.startProcess(workFlow);
        return result;
    }

}