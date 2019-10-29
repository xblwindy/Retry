package com.jcohy.scis.scheduler.model;

public class Task {
    private String autoDestroy;
    private String taskId;
    private String taskName;
    private String startTime;
    private String riskTime;
    private String taskStatus;
    private String taskHandler;
    private String taskContext;
    private Long id;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRiskTime() {
        return riskTime;
    }

    public void setRiskTime(String riskTime) {
        this.riskTime = riskTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(String taskHandler) {
        this.taskHandler = taskHandler;
    }

    public String getTaskContext() {
        return taskContext;
    }

    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutoDestroy() {
        return autoDestroy;
    }

    public void setAutoDestroy(String autoDestroy) {
        this.autoDestroy = autoDestroy;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
