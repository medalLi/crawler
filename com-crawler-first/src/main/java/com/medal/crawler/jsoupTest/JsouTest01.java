package com.medal.crawler.jsoupTest;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.net.URL;

/**
 * @author medal
 * @create 2019-10-05 16:01
 **/
public class JsouTest01 {
    public static void main(String[] args) throws Exception {
        // testUrl();
      //  testString();
        testFile();
    }

    public static void testUrl() throws Exception {
        // 解析url地址，第一个参数是访问的url，第二个参数是访问时候的超时时间
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"),1000);

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    public static void testString() throws Exception{
        // 使用工具类读取文件，获取字符串
        String content = FileUtils.readFileToString(new File("com-crawler-first/test.html"),"utf8");
         // 解析字符串
        Document doc = Jsoup.parse(content);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    public static void testFile() throws Exception{
        // 解析文件
        Document doc = Jsoup.parse(new File("com-crawler-first/test.html"),"utf8");

        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    public static void testDom() throws Exception{
        // 解析文件，获取Document对象
        Document doc = Jsoup.parse(new File("com-crawler-first/test.html"),"utf8");
        // 获取元素
        // 1. 根据id查询元素getElementById
        Element element = doc.getElementById("city_bj");

        // 2.根据标签获取元素getElementsByTag
        Element element1 = doc.getElementsByTag("span").first();

        // 3.根据class获取元素getElementsByClass
        Element element2 = doc.getElementsByClass("class_a class_b").first();
        Element element3 = doc.getElementsByClass("class_a").first();
        Element element4 = doc.getElementsByClass("class_b").first();

        // 4.根据属性获取元素getElementsByAttuibute
        Element element5 = doc.getElementsByAttribute("abc").first();
        Element element6 = doc.getElementsByAttributeValue("href","http://sh.itcast.cn").first();
    }

    public static void testData() throws Exception{
        // 解析文件，获取Document
        Document doc = Jsoup.parse(new File("com-crawler-first/test.html"),"utf8");

        // 根据id获取元素
        Element element = doc.getElementById("test");

        String str = "";
        // 1.从元素中获取id
        str = element.id();

        //2.从元素中获取className
        str = element.className();

        // 3.从元素中获取属性的值attr
        str = element.attr("id");
        str = element.attr("class");

        // 4.从元素中获取所有属性attributes
        str = element.attributes().toString();

        // 5.从元素中获取文本内容text
        str = element.text();

    }

    public static void testSelector() throws Exception{
        // 解析文件
        Document doc = Jsoup.parse(new File("com-crawler-first/test.html"),"utf8");

        //tagName: 通过标签查找元素，比如：span
        Element span = doc.select("span").first();

        // #id：通过ID查找元素，比如：#city_bj
        Element element = doc.select("#city_bj").first();

        // .class: 通过class名称查找元素，比如：.class_a
        Element element1 = doc.select(".class_a").first();

        // [attribute]: 利用属性查找元素，比如：[abc]
        Element first = doc.select("[abc]").first();

        // [attr=value]: 利用属性值查找元素，比如：[class=s_name]
        Element first1 = doc.select("[class=s_name]").first();

    }

    public static void testSelector2() throws Exception{
        // 解析文件
        Document doc = Jsoup.parse(new File("com-crawler-first/test.html"),"utf8");

        // el#id: 元素+ID，比如：h3#city_bj
        Element element = doc.select("h3#city_bj").first();

        // el.class: 元素+class,比如：li.class_a
        Element element1 = doc.select("li.class_a").first();

        // el[attr]:元素+属性名，比如：span[abc]
        Element element2 = doc.select("span[abc]").first();

        // 任意组合：比如：span[abc].s_name
        Element element3 = doc.select("span[abc].s_name").first();

        // ancestor child: 查找某个元素下子元素，比如：.city_con li 查找"city_con"下的所有li
        Element element4 = doc.select(".city_con li").first();

        // parent > child : 查找某个父元素下的直接子元素，比如：
                // .city_con > ul > li 查找city_con第一级(直接子元素)的ul,再找所有ul下的第一级li
        Element element5 = doc.select(".city_con > ul > li").first();
        // parent > * : 查找某个父元素下所有直接子元素
        Element element6 = doc.select(".city_con > ul > *").first();
    }
}
