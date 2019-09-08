package com.hb.springboot.model;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 16:08
 **/

public class WorkFlow {
    private Long  leaveId;
    private String deploymentId;//部署对象ID
    private String taskId;		//任务ID
    private String outcome;		//连线名称
    private String comment;		//备注

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}