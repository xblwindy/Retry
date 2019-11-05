package com.wx.retry.scheduler.schedule;


import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.task.AbstractSchedulerTaskHandler;
import com.wx.retry.scheduler.task.SchedulerTaskQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Component
public class TriggerTaskQueue implements SchedulingConfigurer, SchedulerTaskQueue {

    private final static Logger logger = LoggerFactory.getLogger(TriggerTaskQueue.class);
private ScheduledTaskRegistrar scheduledTaskRegistrar;

private Map<String, ScheduledFuture<?>> taskFutures = new ConcurrentHashMap<>();

    @Override
    public void addTask(Task task, AbstractSchedulerTaskHandler abstractSchedulerTaskHandler) {
        if (!contains(task.getTaskId())){
            TaskScheduler scheduler = scheduledTaskRegistrar.getScheduler();
            //TODO 增加日志
            TriggerTask triggerTask = createTask(task, abstractSchedulerTaskHandler);
            ScheduledFuture<?> future = scheduler.schedule(triggerTask.getRunnable(),triggerTask.getTrigger());
            taskFutures.put(task.getTaskId(),future);
        }
    }

    private TriggerTask createTask(Task task, AbstractSchedulerTaskHandler abstractSchedulerTaskHandler) {
        return new TriggerTask(()->{
            abstractSchedulerTaskHandler.execTask(task);
        },new CronTrigger(task.getStartTime().substring(0,task.getStartTime().length()-5)));
    }

    @Override
    public void cancelTask(String taskId) {
        if(!taskFutures.isEmpty()){
            ScheduledFuture<?> future = taskFutures.get(taskId);
            future.cancel(true);
            taskFutures.remove(taskId);
            //TODO 增加日志操作
        }
    }

    @Override
    public int getCount() {
        return taskFutures.size();
    }

    @Override
    public Set<String> getTaskIds() {
        return taskFutures.keySet();
    }

    @Override
    public boolean contains(String taskId) {
        return taskFutures.containsKey(taskId);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
            this.scheduledTaskRegistrar = scheduledTaskRegistrar;
    }


}
