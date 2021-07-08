/**
 * @title webPractice / customErrorPage / ErrorServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第７章 Deployment Descriptor / p357 / List 7-12, 7-13
 *          カスタムエラーページ用の ErrorServlet
 * @author shika
 * @date 2021-07-08
 */
package webPractice.customErrorPage;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        final String CRLF = System.getProperty("line.separator"); //システム依存の改行コード

        Object uri = request.getAttribute("javax.servlet.error.request_uri");//例外発生のファイル/クラス URI
        Object msg = request.getAttribute("jaxax.servlet.error.message");    //例外メッセージ
        Object exc = request.getAttribute("javax.servlet.error.exception");  //例外情報
        Object excType = request.getAttribute("javax.servlet.error.exception_type");//例外クラス
        Object servletName = request.getAttribute("javax.servlet.error.servlet_name");//サーブレット名
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");//HTTP応答ステータスコード 404, 500など

        StringBuffer buf = new StringBuffer();
        buf.append(new Date()).append(CRLF);
        buf.append(uri).append(CRLF);
        buf.append(msg).append(CRLF);
        buf.append(exc).append(CRLF);
        buf.append(excType).append(CRLF);
        buf.append(servletName).append(CRLF);
        buf.append(statusCode).append(CRLF);
        application.log(buf.toString());

        String path = request.getContextPath() + "/error.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}//class

/*
【web.xml】  /WEB-INF/配下 | /%CATALINA_HOME%/conf 配下に配置
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <error-page>
    <exception-type>java.lang.Exception</exception-type>
    <location>/ErrorServlet</location>
  </error-page>

</web-app>

*/