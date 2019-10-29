package com.jcohy.scis.scheduler.task;

import com.jcohy.scis.scheduler.common.CronUtil;
import com.jcohy.scis.scheduler.config.SchedulerTaskConfig;
import com.jcohy.scis.scheduler.model.Task;
import com.jcohy.scis.scheduler.schedule.TriggerTaskQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TaskScanner {

    private SchedulerTaskHandler taskHandler;
    private SchedulerTaskQueue taskQueue;
    private final static Logger logger = LoggerFactory.getLogger(TaskScanner.class);
    private List<Task> backTaskList;

    public TaskScanner(SchedulerTaskConfig schedulerTaskConfig){
        this.taskQueue = schedulerTaskConfig.getTaskQueue();
        this.taskHandler = schedulerTaskConfig.getTaskHandler();
        this.backTaskList = new ArrayList<>();
    }


    public void scanNewTask(){
        logger.info("scanning task start,taskqueue:" + Arrays.toString(taskQueue.getTaskIds().toArray()));
        List<Task> tasks = getTaskList();
        if(backTaskList.isEmpty()){
           backTaskList =tasks;
        }else {
            backTaskList.stream().forEach(list->{
                if(!tasks.contains(list)){
                    taskQueue.cancelTask(list.getTaskId());
                    logger.info("refresh task ,taskId:"+list.getTaskId());
                }
            });
            backTaskList = tasks;
        }
tasks.stream().forEach(task->{
    if(!taskQueue.contains(task.getTaskId())){
        if(CronUtil.isOverTime(task.getStartTime())){
            ignoreTask(task.getTaskId());
        }else{
            addTaskIntoQueue(task);
        }

    }
});
        logger.info("scanning task over ,taskqueue:" + Arrays.toString(taskQueue.getTaskIds().toArray()));
    }

    private void addTaskIntoQueue(Task task){
        taskQueue.addTask(task,taskHandler);
    }

    protected abstract void ignoreTask(String taskId);

    protected abstract List<Task> getTaskList();


}

