package com.medal.crawler.httpTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author medal
 * @create 2019-10-05 14:45
 **/
public class HttpGetParamTest {
    public static void main(String[] args) throws Exception {
        // 打开浏览器，创建一个HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        // 设置参数
        uriBuilder.setParameter("keys","java");
        // 输入网址
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        // 按回车，发起请求，返回响应，使用httpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 解析数据
        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity,"utf8");
            System.out.println(content);
        }
    }
}
