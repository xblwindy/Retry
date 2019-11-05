package com.wx.retry.scheduler.config;

import com.wx.retry.scheduler.task.AbstractSchedulerTaskHandler;
import com.wx.retry.scheduler.task.SchedulerTaskQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public SchedulerTaskConfig taskConfig(AbstractSchedulerTaskHandler taskHandler, SchedulerTaskQueue taskQueue){
        return new SchedulerTaskConfig(taskHandler,taskQueue);
    }
}
