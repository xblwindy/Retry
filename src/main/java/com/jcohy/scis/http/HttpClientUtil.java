package com.jcohy.scis.http;

import com.jcohy.scis.model.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HttpClientUtil {
    @Autowired
    private HttpClient httpClient;


    public void doGet(String url) throws Exception {
        HttpResult httpResult = this.httpClient.doGet(url);

        System.out.println(httpResult.getCode());
        System.out.println(httpResult.getBody());

    }

    // 新增
    public void doPost(String url, Map<String, Object> map) throws Exception {


        HttpResult httpResult = this.httpClient.doPost(url, map);

        System.out.println(httpResult.getCode());
        System.out.println(httpResult.getBody());

    }

    // 修改


    public void doPut(String url, Map<String, Object> map) throws Exception {


        HttpResult httpResult = this.httpClient.doPut(url, map);

        System.out.println(httpResult.getCode());
        System.out.println(httpResult.getBody());

    }

    // 删除

    public void doDelete(String url, Map<String, Object> map) throws Exception {

        HttpResult httpResult = this.httpClient.doDelete(url, null);

        System.out.println(httpResult.getCode());
        System.out.println(httpResult.getBody());

    }


}

