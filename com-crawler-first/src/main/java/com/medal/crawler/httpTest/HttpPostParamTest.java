package com.medal.crawler.httpTest;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author medal
 * @create 2019-10-05 14:45
 **/
public class HttpPostParamTest {
    public static void main(String[] args) throws Exception {
        // 打开浏览器，创建一个HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpPost对象，设置Url访问地址
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();

        pairs.add(new BasicNameValuePair("keys","java"));

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(pairs,"utf8");

        httpPost.setEntity(formEntity);

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
