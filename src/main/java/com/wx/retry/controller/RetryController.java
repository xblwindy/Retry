package com.wx.retry.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.schedule.BusinessTaskHandler;
import com.wx.retry.scheduler.schedule.TriggerTaskQueue;
import com.wx.retry.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/admin/retry")
public class RetryController extends BaseController {


    @Autowired
    private TriggerTaskQueue triggerTaskQueue;

    @Autowired
    private BusinessTaskHandler businessTaskHandler;

    @Autowired
    private SchedulerTaskService schedulerTaskService;

    private final String TASK_NAME = "retryTask";

    @PostMapping("/add")
    @ResponseBody
    public String addRetry(@RequestBody String params) throws Exception {
        JSONObject obj = JSONObject.parseObject(params);
        String variables = obj.getString("args");
        Long startTime = System.currentTimeMillis() + 5 * 1000 * 60;
        Date date = new Date(startTime);
        schedulerTaskService.addCommonTask(TASK_NAME, date, "retryService", variables);
        triggerTaskQueue.addTask(new Task(), businessTaskHandler);
        return "ok";
    }


}
