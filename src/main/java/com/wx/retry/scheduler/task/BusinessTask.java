package com.wx.retry.scheduler.task;

import com.wx.retry.scheduler.model.Task;

public interface BusinessTask {

     void doTask(Task task) throws Exception;
}
