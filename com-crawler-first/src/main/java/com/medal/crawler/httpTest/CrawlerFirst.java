package com.medal.crawler.httpTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author medal
 * @create 2019-10-05 14:45
 **/
public class CrawlerFirst {
    public static void main(String[] args) throws Exception {
        // 1. 打开浏览器，创建一个HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2.输入网址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //创建连接的最长时间，单位毫秒
                                .setConnectionRequestTimeout(500) // 设置获取连接的最长时间，单位毫秒
                                .setSocketTimeout(10 * 1000)  // 设置数据传输的最长时间，单位毫秒
                                .build();
        httpGet.setConfig(config);
        // 3. 按回车，发起请求，返回响应，使用httpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 4.解析数据
        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity,"utf8");
            System.out.println(content);
        }
    }
}
