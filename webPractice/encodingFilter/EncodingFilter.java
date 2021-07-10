/**
 * @title webPractice / encodingFilter / EncodingFilter.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / p401, p404 / List 8-1, 8-2
 *          エンコードFilterのコード/ web.xml設定
 *          アノテーションで設定することも可。(web.xmlを代替) どちらか記述してあれば良い
 *
 * @author shika
 * @date 2021-07-10
 */

package webPractice.encodingFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/EncodingFilter")
//---- 下記 web.xmlの設定をアノテーションで行う場合 ----
//@WebFilter(
//  urlPatterns = { "/*" },
//  initParameters = {
//    @WebInitParameter(name = "encoding", value = "UTF-8")
//  },
//  dispatcherTypes = {
//    DispatcherType.REQUEST,
//    DispatcherType.FORWARD,
//    DispatcherType.INCLUDE
//  }
//)
public class EncodingFilter implements Filter {
    private String encoding = null;

    public EncodingFilter() { }

    public void init(FilterConfig fConfig) throws ServletException {
        this.encoding = fConfig.getInitParameter("encoding");
    }//init()

    public void doFilter(
            ServletRequest req, ServletResponse res, FilterChain chain)
                throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding(encoding);

        chain.doFilter(req, res);
    }//doFilter()

    public void destroy() { }
}//class

/*
//---- フィルタの設定 / 初期化パラメタを定義 / 適用タイミングを設定 ----
【web.xml】
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <filter>
    <filter-name>EncodingFilter</filter-name>
    <filter-class>to.msn.wings.chap08.EncodingFilter</filter-class>

    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    <init-param>
  </filter>

  <filter-mapping>
    <filter-name>EncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWORD</dispatcher>
    <dispatcher>INCLUDE</dispatcher>
  </filter-mapping>
</web-app>
*/