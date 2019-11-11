package com.wx.retry.scheduler.schedule;

import com.alibaba.fastjson.JSONObject;
import com.wx.retry.httpclient.HttpClientUtil;
import com.wx.retry.scheduler.model.Task;
import com.wx.retry.scheduler.task.BusinessTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("retryService")
public class BusinessTaskImpl implements BusinessTask {

    @Autowired
    HttpClientUtil httpClientUtil;

    @Override
    public void doTask(Task task) throws Exception{
        send(task);
    }

    private void send(Task task) throws Exception {
        String url = task.getVariables().get("url");
        String args = task.getVariables().get("args");
        Map<String, Object> map = new HashMap<>();
        map.put("args", args);
        String putJson = new JSONObject(map).toString();
        httpClientUtil.doPost(url, putJson);
        System.out.println("send to 8081 success!");
    }
}
