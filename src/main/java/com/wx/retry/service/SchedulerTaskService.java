package com.wx.retry.service;

import com.wx.retry.scheduler.model.Task;

import java.util.Date;
import java.util.List;

public interface SchedulerTaskService {


    void execFailed(String taskId);

    void execSuccess(String taskId);

    void execTask(String taskId);

    void ignoreTask(String taskId);

    List<Task> queryUnFinishedTask();

    void addCommonTask(String taskName, Date startTime,String classCommonName,String variables);

    void addUndestoryTask(String taskName, Date startTime,String classCommonName,String variables);
}
