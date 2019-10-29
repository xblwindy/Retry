package com.jcohy.scis.scheduler.config;

import com.jcohy.scis.scheduler.task.SchedulerTaskHandler;
import com.jcohy.scis.scheduler.task.SchedulerTaskQueue;

public class SchedulerTaskConfig {
    private SchedulerTaskQueue taskQueue;
    private SchedulerTaskHandler taskHandler;
    public SchedulerTaskConfig(SchedulerTaskHandler taskHandler,SchedulerTaskQueue taskQueue){
        this.taskHandler = taskHandler;
        this.taskQueue= taskQueue;
    }

    public SchedulerTaskQueue getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(SchedulerTaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public SchedulerTaskHandler getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(SchedulerTaskHandler taskHandler) {
        this.taskHandler = taskHandler;
    }
}
