package com.medal.crawler.httpTest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author medal
 * @create 2019-10-05 15:34
 **/
public class HttpClientPoolTest {
    public static void main(String[] args) {
        // 创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        // 设置最大连接数
        cm.setMaxTotal(100);
        // 设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(10);
        // 使用连接池管理器发起请求
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm){
        // 不是每次创建新的HttpClient，而是从连接池中获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        // 后面和其它的是一样的
    }

}
