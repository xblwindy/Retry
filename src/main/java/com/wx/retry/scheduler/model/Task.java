package com.wx.retry.scheduler.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
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


    public void setVariables(Map<String, String> variables) {
        String json = JSONObject.toJSONString(variables);
        this.taskContext = json;
    }

    public void setVariables(String json) {
        this.taskContext = json;
    }

    public Map<String, String> getVariables() {
        Map<String, String> map = JSONObject.parseObject(taskContext, new TypeReference<Map<String, String>>() {
        });
        return map;
    }

    @Override
    public String toString() {
        return "Task{" +
                "autoDestroy='" + autoDestroy + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", riskTime='" + riskTime + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskHandler='" + taskHandler + '\'' +
                ", taskContext='" + taskContext + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(autoDestroy, task.autoDestroy) &&
                Objects.equals(taskId, task.taskId) &&
                Objects.equals(taskName, task.taskName) &&
                Objects.equals(startTime, task.startTime) &&
                Objects.equals(riskTime, task.riskTime) &&
                Objects.equals(taskStatus, task.taskStatus) &&
                Objects.equals(taskHandler, task.taskHandler) &&
                Objects.equals(taskContext, task.taskContext) &&
                Objects.equals(id, task.id);
    }

}
