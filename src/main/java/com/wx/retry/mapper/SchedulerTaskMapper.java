package com.wx.retry.mapper;

import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.model.TaskLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface SchedulerTaskMapper{

    void saveTask(Task task);

    void addTaskLog(TaskLog taskLog);

    void updateTaskStatus(@Param("taskId") String taskId,@Param("taskStatus") String taskStatus);

    List<Task> queryTask(@Param("status") String status);
}
