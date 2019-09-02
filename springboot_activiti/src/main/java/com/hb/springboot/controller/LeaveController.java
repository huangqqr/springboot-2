package com.hb.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @description: 请假流程
 * @author: huangbo
 * @create: 2019-09-02 18:37
 **/

@Controller
@Slf4j
@RequestMapping("/leave")
public class LeaveController {

    //@Autowired
   // LeaveMapper leaveMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private HistoryService historyService;
   // @Autowired
    //private LeaveService leaveService;

    //部署流程资源【第一种方式：classpath】
    @RequestMapping("/deploy1")
    public void deploy1( ){
        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .name("请假申请审核流程")//声明流程的名称
                .addClasspathResource("processes/leave.bpmn")//加载资源文件，一次只能加载一个文件
                .addClasspathResource("processes/leave.png")//
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());

    }

    //部署流程资源【第二种方式：InputStream】
    @RequestMapping("/deploy2")
    public void deploy2( ) throws FileNotFoundException{
        //获取资源相对路径
        String bpmnPath = "processes/leave.bpmn";
        String pngPath = "processes/leave.png";
        //读取资源作为一个输入流
        FileInputStream bpmnfileInputStream = new FileInputStream(bpmnPath);
        FileInputStream pngfileInputStream = new FileInputStream(pngPath);

        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .addInputStream("leave.bpmn",bpmnfileInputStream)
                .addInputStream("leave.png", pngfileInputStream)
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());
    }

    //部署流程资源【第三种方式：InputStream】
    @RequestMapping("/deploy3")
    public void deploy3( ) throws FileNotFoundException{
        //字符串
        String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><definitions>...</definitions>";

        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .addString("leave.bpmn",text)
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());

    }

    //部署流程资源【第四种方式：zip/bar格式压缩包方式】
    @RequestMapping("/deploy4")
    public void deploy4( ) throws FileNotFoundException {
        //从classpath路径下读取资源文件
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("processes/leave.zip");
        ZipInputStream zipInputStream = new ZipInputStream(in);
        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .addZipInputStream(zipInputStream)//使用zip方式部署，将leave.bpmn和leave.png压缩成zip格式的文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());

    }

    //2、创建Activiti用户
    @RequestMapping("/addUser")
    public void addUser( ){
        //项目中每创建一个新用户，对应的要创建一个Activiti用户,两者的userId和userName一致

        //添加用户
        User user1 = identityService.newUser("user1");
        user1.setFirstName("张三");
        user1.setLastName("张");
        user1.setPassword("123456");
        user1.setEmail("zhangsan@qq.com");
        identityService.saveUser(user1);

        User user2 = identityService.newUser("user2");
        user2.setFirstName("李四");
        user2.setLastName("李");
        user2.setPassword("123456");
        user2.setEmail("lisi@qq.com");
        identityService.saveUser(user2);

        User user3 = identityService.newUser("user3");
        user3.setFirstName("王五");
        user3.setLastName("王");
        user3.setPassword("123456");
        user3.setEmail("wangwu@qq.com");
        identityService.saveUser(user3);

        User user4 = identityService.newUser("user4");
        user4.setFirstName("吴六");
        user4.setLastName("吴");
        user4.setPassword("123456");
        user4.setEmail("wuliu@qq.com");
        identityService.saveUser(user4);

    }

    //3、根据id查询Activiti用户
    @RequestMapping("/queryUser")
    public void queryUser( ){

        User user = identityService.createUserQuery().userId("user1").singleResult();
        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());

    }
    //4、创建Activiti用户组
    @RequestMapping("/addGroup")
    public void addGroup( ){

        Group group1 = identityService.newGroup("group1");
        group1.setName("员工组");
        group1.setType("员工组");
        identityService.saveGroup(group1);

        Group group2 = identityService.newGroup("group2");
        group2.setName("总监组");
        group2.setType("总监阻");
        identityService.saveGroup(group2);

        Group group3 = identityService.newGroup("group3");
        group3.setName("经理组");
        group3.setType("经理组");
        identityService.saveGroup(group3);

        Group group4 = identityService.newGroup("group4");
        group4.setName("人力资源组");
        group4.setType("人力资源组");
        identityService.saveGroup(group4);

    }
    //5、通过用户组id查询Activiti用户组
    @RequestMapping("/queryGroup")
    public void queryGroup( ){

        Group group = identityService.createGroupQuery().groupId("group1").singleResult();
        System.out.println(group.getId());
        System.out.println(group.getName());
        System.out.println(group.getType());

    }
    //6、创建Activiti（用户-用户组）关系
    @RequestMapping("/addMembership")
    public void addMembership( ){

        identityService.createMembership("user1", "group1");//user1 在员工阻
        identityService.createMembership("user2", "group2");//user2在总监组
        identityService.createMembership("user3", "group3");//user3在经理组
        identityService.createMembership("user4", "group4");//user4在人力资源组

    }
    //7、查询属于组group1的用户
    @RequestMapping("/queryUserListByGroup")
    public void queryUserListByGroup( ){

        //查询属于组group1的用户
        List<User> usersInGroup = identityService.createUserQuery().memberOfGroup("group1").list();
        for (User user : usersInGroup) {
            System.out.println(user.getFirstName());
        }

    }
    //8、查询user1所属于的组
    @RequestMapping("/queryGroupListByUser")
    public void queryGroupListByUser( ){

        //查询user1所属于的组
        List<Group> groupsForUser = identityService.createGroupQuery().groupMember("user1").list();
        for (Group group : groupsForUser) {
            System.out.println(group.getName());
        }

    }

    //9、启动流程实例
    @RequestMapping("/startProcessInstance")
    public void startProcessInstance() {
        // 流程定义的Key
        String processDefinitionKey = "myProcess";
        ProcessInstance processInstance = processEngine.getRuntimeService()// 与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应leave.bpmn文件中id的属性
        System.out.println("流程实例ID:" + processInstance.getId());// 流程实例ID:
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());// 流

    }

    //10、启动流程实例--使用流程变量 userId
    @RequestMapping("/startProcessInstance2")
    public void startProcessInstance2() {
        // 流程定义的Key
        String processDefinitionKey = "myProcess";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("userId", "user1");//这里传入id为user1的用户
        ProcessInstance processInstance = processEngine.getRuntimeService()// 与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey,variables);// 使用流程定义的key启动流程实例，key对应leave.bpmn文件中id的属性
        System.out.println("流程实例ID:" + processInstance.getId());// 流程实例ID:
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());// 流

    }
}