package com.wx.retry.mapper;

import com.wx.retry.scheduler.model.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedulerTaskMapper{

   void saveTask(Task task);


}
