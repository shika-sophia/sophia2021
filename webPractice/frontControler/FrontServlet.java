/**
 * @title WebContent / frontControler / FrontServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第６章 Servlet / p305 / List 6-14
 * @content FrontServletを起点として、各クラスに振り分ける
 *          ここでは、Webページに出力しているだけだが、
 *          URL情報を取得しそれを keyにクラスの行き先を分岐する処理をする。
 *
 *          StringBuffer request.getRequestURL()
 *          String request.getRequestURI()
 *          String request.getServletPath()
 *          String request.getPathInfo()
 *
 * @author shika
 * @date 2021-06-10
 */
package webPractice.frontControler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/webPractice/frontControler/FrontServlet/*")
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuffer url = request.getRequestURL(); //URL
        String uri = request.getRequestURI();       //URI
        String servletPath = request.getServletPath();//ServletPath
        String pathInfo = request.getPathInfo();    //拡張パス

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<pre>");
        out.println("URL: " + url.toString());
        out.println("URI: " + uri);
        out.println("Servlet: " + servletPath);
        out.println("pathInfo: " + pathInfo);
        out.println("</pre>");
    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//doPost()

}//class

/*
＊Webページに出力
URL: http://localhost:8080/sophia2021/webPractice/frontControler/FrontServlet/*
URI: /sophia2021/webPractice/frontControler/FrontServlet/*
Servlet: /webPractice/frontControler/FrontServlet
pathInfo: /*
*/