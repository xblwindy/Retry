package com.wx.retry.scheduler.schedule;

import com.wx.retry.scheduler.config.SchedulerTaskConfig;
import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.task.AbstractTaskScanner;
import com.wx.retry.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TaskScannerExtender extends AbstractTaskScanner {


    @Autowired
    private SchedulerTaskService schedulerTaskService;


    public TaskScannerExtender(SchedulerTaskConfig schedulerTaskConfig) {
        super(schedulerTaskConfig);
    }

    @Override
    protected void ignoreTask(String taskId) {
        schedulerTaskService.ignoreTask(taskId);
    }

    @Override
    protected List<Task> getTaskList() {
        return schedulerTaskService.queryUnFinishedTask();
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void scannerStart(){
        super.scanNewTask();
    }
}
