/**
 * @title webPractice / welcomePage / MyDefaultServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第７章 Deployment Descriptor / p379 - 382 / List 7-25, 7-26, 7-27
 *          ウェルカムページ <welcome-file-list>
 *          Tomcat6以降、ファイル名を省略したURLは「404NotFound」を返す仕様。
 *          それ以前のTomcatはファイルリストを返す仕様だったが、セキュリティ上の理由で廃止。
 * @content Tomcat6以降もファイルリストを表示するには web.xmlに設定が必要。
 * @content index.jsp/default.jspをウェルカムページに設定。
 * @content デフォルトServletをカスタマイズ。
 *
 * @author shika
 * @date 2021-07-10
 */

package webPractice.welcomePage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyDefaultServlet") //本来は「/」にする
public class MyDefaultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("デフォルトサーブレット");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}//class

/*
//---- Tomcat6以降もファイルリスト(デフォルトページ)を有効にする。 ----
【web.xml】 /%CATALINA_HOME%/conf/web.xml
<servlet>
  <servlet-name>default</servlet-name>
  <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>

  <init-param>
    <param-name>listening</param-name>
    <param-value>true</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>

//----  index.jsp/default.jspをウェルカムページに設定する。----
【web.xml】
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <welocome-file-list>
    <welocome-file>index.jsp</welocome-file>
    <welocome-file>default.jsp</welocome-file>
  </welocome-file-list>
</web-app>

//---- MyDefaultServletの urlPatternを「/」にして下記の設定をする
DefaultServletは すでにTomcatで用意されている。

【web.xml】 /%CATALINA_HOME%/conf/web.xml
<servlet>
  <servlet-name>default</servlet-name>
  <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>

  <init-param>
    <param-name>debug</param-name>
    <param-value>0</param-value>
  </init-param>
  <init-param>
    <param-name>listening</param-name>
    <param-value>true</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
  <servlet-name>default</servlet-name>
  <url-pattern>/</url-pattern>
</servlet-mapping>
*/