package com.wx.retry.httpclient;

import com.wx.retry.model.HttpResult;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class HttpClient {

    private CloseableHttpClient httpClient;

    public HttpClient() {
        // 1 创建HttpClinet，相当于打开浏览器
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * 带参数的get请求
     *
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doGet(String url, Map<String, Object> map) throws Exception {

        // 声明URIBuilder
        URIBuilder uriBuilder = new URIBuilder(url);

        // 判断参数map是否为非空
        if (map != null) {
            // 遍历参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // 设置参数
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 2 创建httpGet对象，相当于设置url请求地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        // 3 使用HttpClient执行httpGet，相当于按回车，发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 返回
        return result(response);
    }

    /**
     * 不带参数的get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doGet(String url) throws Exception {
        HttpResult httpResult = doGet(url, null);
        return httpResult;
    }

    /**
     * 带参数的post请求
     *
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, String json) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);

        // 判断map不为空
        if (json != null) {
            // 创建form表单对象
            StringEntity formEntity = new StringEntity(json, "UTF-8");

            // 把表单对象设置到httpPost中
            httpPost.setEntity(formEntity);
        }

       // 使用HttpClient发起请求，返回response
        CloseableHttpResponse response = this.httpClient.execute(httpPost);

        // 返回结果
        return result(response);
    }


    private HttpResult result(CloseableHttpResponse response) throws IOException {


        // 解析response封装返回对象httpResult
        HttpResult httpResult = null;
        if (response.getEntity() != null) {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } else {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(), "");
        }
        return httpResult;
    }

    /**
     * 不带参数的post请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url) throws Exception {
        HttpResult httpResult = doPost(url, null);
        return httpResult;
    }


}
