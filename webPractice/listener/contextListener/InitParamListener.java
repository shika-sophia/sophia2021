/**
 * @title webPractice / listener / contextListener / InitParamListener.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / p415, p351 / List 8-7, 7-6, 8-8
 *          アプリケーション開始時に初期化パラメータをロードする
 * @content 【web.xml】 初期化パラメタの登録
 * @content 【initParam.jsp】 jspページでの値の取得・表示
 *
 * @author shika
 * @date 2021-07-11
 */
package webPractice.listener.contextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class InitParamListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent ev)  {
        ServletContext app = ev.getServletContext();
        String bookTitle = app.getInitParameter("bookTitle");
        app.setAttribute("bookTitle", bookTitle);
    }//contextInitialized()

    public void contextDestroyed(ServletContextEvent ev)  { }

}//class

/*
【web.xml】 初期化パラメタの登録
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <context-param>
    <param-name>bookTitle</param-name>
    <param-value>独習Javaサーバーサイド編</param-value>
  </context-param>

</web-app>

【initParam.jsp】 jspページでの値の取得・表示
<%@ page contentType="text/html; charset=UTF-8" %>
<% String bookTitle = (String) application.getAttribute("bookTitle"); %>
<%= bookTitle %>

<%@ page contentType="text/html; charset=UTF-8" %>
${applicationScope['bookTitle']}
*/