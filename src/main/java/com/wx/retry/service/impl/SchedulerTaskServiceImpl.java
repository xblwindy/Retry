package com.wx.retry.service.impl;

import com.wx.retry.mapper.SchedulerTaskMapper;
import com.wx.retry.scheduler.common.CronUtil;
import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.model.TaskLog;
import com.wx.retry.scheduler.schedule.BusinessTaskHandler;
import com.wx.retry.scheduler.task.SchedulerTaskQueue;
import com.wx.retry.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wx.retry.scheduler.common.Constants.*;

@Service
public class SchedulerTaskServiceImpl implements SchedulerTaskService {
    @Autowired
    private SchedulerTaskMapper schedulerTaskMapper;

    @Autowired
    private SchedulerTaskQueue schedulerTaskQueue;

    @Autowired
    private BusinessTaskHandler businessTaskHandler;


    @Override
    public void execFailed(String taskId) {
        addTaskLog(taskId, EVENT_FAILED, "");
        updateTaskStatus(taskId, TASK_FAILED);
    }

    @Override
    public void execSuccess(String taskId) {
        addTaskLog(taskId, EVENT_SUCC, "");
        updateTaskStatus(taskId, TASK_SUCC);
    }

    @Override
    public void execTask(String taskId) {
        addTaskLog(taskId, EVENT_EXEC, "");
        updateTaskStatus(taskId, TASK_EXEC);
    }

    @Override
    public void ignoreTask(String taskId) {
        addTaskLog(taskId, EVENT_INGORE, "");
        updateTaskStatus(taskId, TASK_INGORE);
    }

    private void updateTaskStatus(String taskId, String taskStatus) {
        schedulerTaskMapper.updateTaskStatus(taskId, taskStatus);
    }

    private void addTaskLog(String taskId, String eventStatus, String comment) {
        schedulerTaskMapper.addTaskLog(new TaskLog(taskId, eventStatus, comment));
    }

    @Override
    public List<Task> queryUnFinishedTask() {
        return schedulerTaskMapper.queryTask(TASK_INIT);
    }

    @Override
    public void addCommonTask(String taskName, Date startTime, String classCommonName, String variables) {
        Task task = initTask(taskName, CronUtil.dateToCron(startTime), classCommonName, AUTO_DESTROY, variables);
        schedulerTaskMapper.saveTask(task);
        schedulerTaskQueue.addTask(task, businessTaskHandler);

    }

    @Override
    public void addUndestoryTask(String taskName, Date startTime, String classCommonName, String variables) {
        Task task = initTask(taskName, CronUtil.dateToCron(startTime), classCommonName, UN_AUTO_DESTROY, variables);
        schedulerTaskMapper.saveTask(task);
    }

    private Task initTask(String taskName, String cron, String classCommonName, String autoDestory, String variables) {
        Task task = new Task();
        task.setAutoDestroy(autoDestory);
        task.setStartTime(cron);
        task.setTaskHandler(trans2Bean(classCommonName));
        task.setTaskStatus(TASK_INIT);
        task.setTaskName(taskName);
        task.setTaskId(generateTaskId());
        task.setVariables(variables);
        return task;
    }

    private String generateTaskId() {
        return System.currentTimeMillis() + "";
    }

    private String trans2Bean(String className) {
        return Character.isLowerCase(className.charAt(0)) ? className : (new StringBuilder()).append(Character.toLowerCase(className.charAt(0))).append(className.substring(1)).toString();
    }
}
