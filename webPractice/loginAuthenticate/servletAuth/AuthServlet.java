/**
 * @title webPractice / loginAuthenticate / servletAuth / AuthServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第７章 Deployment Descriptor / p373 / List 7-21
 *          void HttpServletRequest.login(String user, String pass)
 *          を利用することで、<form action="j_security_check">では
 *          固定フォームであったものを開発者がカスタマイズできる。
 *          <form action="/AuthServlet">に書き換える必要がある。
 *
 * @author shika
 * @date 2021-07-09
 */

package webPractice.loginAuthenticate.servletAuth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("j_username");
        String pass = request.getParameter("j_password");

        try {
            //認証に付随する処理
            request.login(user, pass);
            out.printf("Hello, %sさん。 \n", request.getRemoteUser());
        } catch(ServletException e) {
            e.printStackTrace();
            out.println("認証済であるか、ユーザー名 / パスワードが間違っています。");
        }
    }//doPost()

}//class
