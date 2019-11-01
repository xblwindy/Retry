package com.jcohy.scis.scheduler.config;

import com.jcohy.scis.scheduler.task.AbstractSchedulerTaskHandler;
import com.jcohy.scis.scheduler.task.SchedulerTaskQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public SchedulerTaskConfig taskConfig(AbstractSchedulerTaskHandler taskHandler, SchedulerTaskQueue taskQueue){
        return new SchedulerTaskConfig(taskHandler,taskQueue);
    }
}
