package com.jcohy.scis.scheduler.schedule;

import com.jcohy.scis.scheduler.model.Task;
import com.jcohy.scis.scheduler.task.AbstractSchedulerTaskHandler;
import com.jcohy.scis.scheduler.task.SchedulerTaskQueue;
import com.jcohy.scis.service.SchedulerTaskService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
@Component
public class BusinessTaskHandler extends AbstractSchedulerTaskHandler implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private SchedulerTaskService schedulerTaskService;

    private final String METHOD_DO_TASK = "doTask";

    public BusinessTaskHandler(SchedulerTaskQueue queue) {
        super(queue);
    }

    @Override
    public void execFailed(Task task) {
        schedulerTaskService.execFailed(task.getTaskId());
    }

    @Override
    public void execSuccess(Task task) {
      schedulerTaskService.execSuccess(task.getTaskId());

    }

    @Override
    public void doTask(Task task) {
        Object object = applicationContext.getBean(task.getTaskHandler());
        Method method = ReflectionUtils.findMethod(object.getClass(),METHOD_DO_TASK,Task.class);
        ReflectionUtils.invokeMethod(method,object,task);
    }

    @Override
    public void doBefore(Task task) {
        schedulerTaskService.execTask(task.getTaskId());

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
this.applicationContext = applicationContext;
    }
}
