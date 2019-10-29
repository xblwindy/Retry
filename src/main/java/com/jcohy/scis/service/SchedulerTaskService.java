package com.jcohy.scis.service;

import com.jcohy.scis.scheduler.model.Task;

import java.util.List;

public interface SchedulerTaskService {


    void execFailed(String taskId);

    void execSuccess(String taskId);

    void execTask(String taskId);

    void ignoreTask(String taskId);

    List<Task> queryUnFinishedTask();
}
