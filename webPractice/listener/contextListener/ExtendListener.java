/**
 * @title webPractice / listener / contextListener / ExtendListener.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / p417, p277 / List 8-9, 8-10, 6-3
 *          アプリケーション起動時、プログラム内から動的に
 *          Servlet/Filter/Listenerを有効化しアプリに追加する。
 *          web.xml / @WebServlet()を代替。
 *
 *          MyServlet等は事前に用意する。(Servletを生成するわけではない)
 *          ServletContext.createServlet()/createFilter()/createListener()等は、
 *          ServletContextListener.contextInitialized()でのみ有効。
 *
 * @content 【web.xml】 Servletの登録(通常の登録) -> @WebServlet()で代替
 *
 * @see MyServlet.java
 * @author shika
 * @date 2021-07-12
 */

package webPractice.listener.contextListener;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//@WebListener
public class ExtendListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent ev)  {
        ServletContext app = ev.getServletContext();
        Servlet servlet = null;
        try {
            //Servletをインスタンス化
            servlet = app.createServlet(webPractice.listener.contextListener.MyServlet.class);

        } catch (ServletException e){
            e.printStackTrace();
        }

        //Servletを登録、指定パスにマッピング(=URLパターン登録)
        ServletRegistration reg = app.addServlet("MyServlet", servlet);
        reg.addMapping("/url-pattern");
    }//contextInitialized()

    public void contextDestroyed(ServletContextEvent ev)  { }

}//class

/*
【web.xml】 Servletの登録 / p277 / List 6-3
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>webPractice.listener.contextListener.MyServlet</servlet-class>
  </servlet>

  <servlet-mapping>
      <servlet-name>MyServlet</servlet-name>
      <url-pattern>/Myservlet</url-pattern>
  </servlet-mapping>

  <context-param>
    <param-name>bookTitle</param-name>
    <param-value>独習Javaサーバーサイド編</param-value>
  </context-param>

  <session-congig>
    <session-timeout>10</session-timeout>
  </session-config>
</web-app>

*/