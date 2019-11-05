package com.jcohy.scis.controller;

import com.jcohy.scis.scheduler.model.Task;
import com.jcohy.scis.scheduler.schedule.BusinessTaskHandler;
import com.jcohy.scis.scheduler.schedule.TriggerTaskQueue;
import com.jcohy.scis.service.RetryService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.io.HttpResponseWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/retry")
public class RetryController extends BaseController{


    @Autowired
    private TriggerTaskQueue triggerTaskQueue;

    @Autowired
    private BusinessTaskHandler businessTaskHandler;

    @PostMapping("/add")
    @ResponseBody
    public String addRetry(HttpServletRequest request) throws Exception {


        triggerTaskQueue.addTask(new Task(),businessTaskHandler);

        return "ok";
    }




}
