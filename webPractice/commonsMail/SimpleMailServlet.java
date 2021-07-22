/**
 * @title webPractice / commonsMail / SimpleMailServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-1, 9-2
 * @content 電子メールを送信するServlet
 * @content 【web.xml】初期化パラメタに送信先メールサーバのアドレスを登録
 * @deploy /WEB-INF/lib/commons-email-x.x.jar
 *         https://commons.apache.org/proper/commons-email/
 * @deploy /WEB-INF/lib/javax.mail.jar
 *         https://github.com/javaee/javamail/releases
 *
 * @see Eclipse: mailRegisterプロジェクト / fakeSMTPにて実装
 * @author shika
 * @date 2021-07-17
 */

package webPractice.commonsMail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/SimpleMailServlet")
public class SimpleMailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String host;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.host = config.getServletContext()
                .getInitParameter("smtp.host");
    }//init()
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleEmail email = new SimpleEmail();
        try {
            email.setHostName(host);
            email.addTo("dammy@domain.jp", "山田祥寛", "ISO-2022-JP");
            email.setFrom("myAdress@domain.jp", "差出人", "ISO-2022-JP");
            email.addHeader("X-Mailer", "Commons Email");
            email.setCharset("ISO-2022-JP");
            email.setSubject("Title");
            email.setSentDate(new Date());
            email.setMsg("メール本文");
            //メール送信
            email.send();

        } catch(EmailException e) {
            throw new ServletException();
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("メールが正しく送信されました");
    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }//doPost()

}//class

/*
【web.xml】初期化パラメタに送信先メールサーバのアドレスを登録
<? xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/javaee/web-javataglibrary_3_0.xsd"
  version="3.0" >

  <context-param>
    <param-name>smtp.host</param-name>
    <param-value>smtp.xxxxx.ne.jp</param-value>
  </context-param>
</web-app>
*/