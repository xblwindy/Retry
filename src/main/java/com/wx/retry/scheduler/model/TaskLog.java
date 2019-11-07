package com.wx.retry.scheduler.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskLog {

    private String taskId;
    private String eventStatus;
    private String comment;
    private Date execTime;

    public TaskLog(String taskId, String eventStatus, String comment) {
        this.taskId = taskId;
        this.eventStatus = eventStatus;
        this.execTime = new Date();
        this.comment = comment;
    }

    public TaskLog() {
    }
}
