/**
 * @title webPractice / commonsMail / AttachHtmlMailServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-3
 * @content 添付ファイル付き HTMLメールを送信するServlet
 * @content 【web.xml】初期化パラメタに送信先メールサーバのアドレスを登録
 * @prepair /WEB-INF/lib/commons-email-x.x.jar
 * @prepair /WEB-INF/lib/javax.mail.jar
 * @prepair src/webPractice/commonsMail/image/htmlHeader.jpg
 * @prepair src/webPractice/commonsMail/image/flower.jpg
 * @see Eclipse: mailRegisterプロジェクト / fakeSMTPにて実装
 * @author shika
 * @date 2021-07-18
 */

package webPractice.commonsMail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@WebServlet("/AttachHtmlMailServlet")
public class AttachHtmlMailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String host;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.host = config.getServletContext()
                .getInitParameter("smtp.host");
    }//init()

    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        ServletContext app = this.getServletContext();

        //---- HTML part ----
        StringBuffer buf = new StringBuffer(3000);
        buf.append("<!DOCTYPE html>\n");
        buf.append("<html>\n");
        buf.append("<head>\n");
        buf.append("<meta charset=\"UTF-8\">\n");
        buf.append("<title>CommonsEmail with AttachHtml</title>");
        buf.append("</head>\n");
        buf.append("<body>\n");
        buf.append("<img src='http://www.webPractice.commonsMail/image/mailHeader.jpg' /> \n");
        buf.append("</body>\n");
        buf.append("</html>\n");

        //---- email setting ----
        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.addTo("dammy@domain.jp", "山田祥寛", "ISO-2022-JP");
            email.setFrom("myAdress@domain.jp", "差出人", "ISO-2022-JP");
            email.addHeader("X-Mailer", "Commons Email");
            email.setCharset("ISO-2022-JP");
            email.setSubject("Title");
            email.setTextMsg("メール本文");
            email.setHtmlMsg(buf.toString());

            //---- 添付ファイル ----
            EmailAttachment attach = new EmailAttachment();
            attach.setDescription(EmailAttachment.ATTACHMENT);
            attach.setPath(app.getRealPath("src/webPractice/commonsMail/image/flower.jpg"));
            attach.setName("flower.jpg");
            email.attach(attach);

            //---- email 送信 ----
            email.send();
        } catch (EmailException e) {
            throw new ServletException();
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("メール送信完了");
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