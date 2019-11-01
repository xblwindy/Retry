package com.jcohy.scis.scheduler.task;


import com.jcohy.scis.scheduler.model.Task;

import java.util.Set;

public interface SchedulerTaskQueue {
    public void addTask(Task task, AbstractSchedulerTaskHandler abstractSchedulerTaskHandler);

    public void cancelTask(String taskId);

    public int getCount();

    public Set<String> getTaskIds();

    public boolean contains(String taskId);
}
