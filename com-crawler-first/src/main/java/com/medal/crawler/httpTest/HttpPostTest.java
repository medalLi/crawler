package com.medal.crawler.httpTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author medal
 * @create 2019-10-05 14:45
 **/
public class HttpPostTest {
    public static void main(String[] args) throws Exception {
        // 打开浏览器，创建一个HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 输入网址
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        // 按回车，发起请求，返回响应，使用httpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 解析数据
        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity,"utf8");
            System.out.println(content);
        }
    }
}
