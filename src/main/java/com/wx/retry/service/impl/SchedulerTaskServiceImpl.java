package com.wx.retry.service.impl;

import com.wx.retry.scheduler.model.Task;
import com.wx.retry.service.SchedulerTaskService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchedulerTaskServiceImpl implements SchedulerTaskService {
    @Override
    public void execFailed(String taskId) {

    }

    @Override
    public void execSuccess(String taskId) {

    }

    @Override
    public void execTask(String taskId) {

    }

    @Override
    public void ignoreTask(String taskId) {

    }

    @Override
    public List<Task> queryUnFinishedTask() {
        return null;
    }

    @Override
    public void saveTask(Task task) {

    }
}
