package com.jcohy.scis.scheduler.config;

import com.jcohy.scis.scheduler.task.AbstractSchedulerTaskHandler;
import com.jcohy.scis.scheduler.task.SchedulerTaskQueue;

public class SchedulerTaskConfig {
    private SchedulerTaskQueue taskQueue;
    private AbstractSchedulerTaskHandler taskHandler;
    public SchedulerTaskConfig(AbstractSchedulerTaskHandler taskHandler, SchedulerTaskQueue taskQueue){
        this.taskHandler = taskHandler;
        this.taskQueue= taskQueue;
    }

    public SchedulerTaskQueue getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(SchedulerTaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public AbstractSchedulerTaskHandler getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(AbstractSchedulerTaskHandler taskHandler) {
        this.taskHandler = taskHandler;
    }
}
