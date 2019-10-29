package com.jcohy.scis.service.impl;

import com.jcohy.scis.scheduler.model.Task;
import com.jcohy.scis.service.SchedulerTaskService;
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
}
