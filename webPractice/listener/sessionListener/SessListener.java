/**
 * @title webPractice / listener / sessionListener / SessListener.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / p411 / List 8-4, 8-5
 *          sessionの開始・終了をログに記述する
 *          implements HttpSessionListener
 *          @WebListenerを付記すると、 web.xmlの設定を代替。
 * @content 【web.xml】 リスナークラスの登録
 *
 * @author shika
 * @date 2021-07-11
 */

package webPractice.listener.sessionListener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//import javax.servlet.annotation.WebListener;

//@WebListener
public class SessListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent ev)  {
        ServletContext app = ev.getSession().getServletContext();
        app.log("session start");
    }//sessionCreated()

    public void sessionDestroyed(HttpSessionEvent ev)  {
        ServletContext app = ev.getSession().getServletContext();
        app.log("session end");
    }
}//class

/*
【web.xml】 リスナークラスの登録
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <!-- Listenerクラスを登録 -->
  <listener>
    <listener-class>to.msn.wings.chap08.SessListener</listener-class>
  </listener>
</web-app>
*/