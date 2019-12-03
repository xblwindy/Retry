package com.wx.retry.scheduler.task;


import com.wx.retry.scheduler.model.Task;

import java.util.Set;

public interface SchedulerTaskQueue {
     void addTask(Task task, AbstractSchedulerTaskHandler abstractSchedulerTaskHandler);

     void cancelTask(String taskId);

     int getCount();

     Set<String> getTaskIds();

     boolean contains(String taskId);
}
