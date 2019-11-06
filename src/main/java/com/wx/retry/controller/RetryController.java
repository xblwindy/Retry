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
import java.util.Map;

@RestController
@RequestMapping("/admin/retry")
public class RetryController extends BaseController{


    @Autowired
    private TriggerTaskQueue triggerTaskQueue;

    @Autowired
    private BusinessTaskHandler businessTaskHandler;

    @Autowired
    private SchedulerTaskService schedulerTaskService;

    @PostMapping("/add")
    @ResponseBody
    public String addRetry(@RequestBody String params) throws Exception {
        JSONObject obj = JSONObject.parseObject(params);
        Task task = generateTask(obj);
        schedulerTaskService.saveTask(task);
        triggerTaskQueue.addTask(new Task(),businessTaskHandler);
        return "ok";
    }

    private Task generateTask(JSONObject obj) {
        Task task = new Task();
        String args = obj.getJSONObject("args").toString();
        task.setVariables(args);
        return task;
    }


}
