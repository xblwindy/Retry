package com.wx.retry.scheduler.schedule;

import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.task.BusinessTask;

public class BusinessTaskImpl implements BusinessTask {

    @Override
    public void doTask(Task task) {
        //TODO 调用源系统的callback方法
    }
}
