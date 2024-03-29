package com.wx.retry.scheduler.task;

import com.wx.retry.scheduler.common.Constants;
import com.wx.retry.scheduler.model.Task;

public abstract class AbstractSchedulerTaskHandler {
    private SchedulerTaskQueue schedulerTaskQueue;

    public AbstractSchedulerTaskHandler(SchedulerTaskQueue queue){
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
        if(Constants.AUTO_DESTROY.equals(task.getAutoDestory())){
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
