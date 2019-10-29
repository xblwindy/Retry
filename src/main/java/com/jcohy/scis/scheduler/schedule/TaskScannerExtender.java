package com.jcohy.scis.scheduler.schedule;

import com.jcohy.scis.scheduler.config.SchedulerTaskConfig;
import com.jcohy.scis.scheduler.model.Task;
import com.jcohy.scis.scheduler.task.TaskScanner;
import com.jcohy.scis.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TaskScannerExtender extends TaskScanner {


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
