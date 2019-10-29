package com.jcohy.scis.scheduler.task;

import com.jcohy.scis.scheduler.common.Constants;
import com.jcohy.scis.scheduler.model.Task;

public abstract class SchedulerTaskHandler {
    private SchedulerTaskQueue schedulerTaskQueue;

    public SchedulerTaskHandler(SchedulerTaskQueue queue){
        this.schedulerTaskQueue = queue;
    }

    public void execTask(Task task){
        try {
            doBefore(task);
            doTask(task);
            execSuccess(task);
        }catch (Exception e){
            e.printStackTrace();
            execFailed(task);
        }
        if(Constants.AUTO_DESTROY.equals(task.getAutoDestroy())){
            cancelTask(task.getTaskId());
        }
    }

    public void cancelTask(String taskId) {
        schedulerTaskQueue.cancelTask(taskId);
    }

    public abstract void execFailed(Task task);

    public abstract void execSuccess(Task task);

    public abstract void doTask(Task task);

    public abstract void doBefore(Task task);
}
