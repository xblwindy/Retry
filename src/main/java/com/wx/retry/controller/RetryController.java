package com.wx.retry.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.retry.scheduler.common.Constants;
import com.wx.retry.service.NotifyService;
import com.wx.retry.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/retry")
public class RetryController extends BaseController {

    @Autowired
    private SchedulerTaskService schedulerTaskService;

    @Autowired
    private NotifyService notifyService;

    private final String TASK_NAME = "retryTask";

    @PostMapping("/add")
    @ResponseBody
    public String addRetry(@RequestBody String params) throws Exception {
        JSONObject obj = JSONObject.parseObject(params);
        String variables = obj.getString("args");
        int retryTimes = obj.getInteger("times");
        Long startTime = System.currentTimeMillis() + 1 * 1000 * 60;
        Date date = new Date(startTime);
        if(retryTimes> Constants.RETRY_TIMERS){
            notifyService.sendNotify();
        }
        schedulerTaskService.addCommonTask(TASK_NAME, date, "retryService", variables);
        return "ok";
    }


}
