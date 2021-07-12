/**
 * @title webPractice / listener / contextListener / ExtendListener.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / p417 / List 8-9, 8-10
 *          アプリケーション起動時、プログラム内から動的に
 *          Servlet/Filter/Listenerを有効化しアプリに追加する。
 *
 *          MyServlet等は事前に用意する。(Servletを生成するわけではない)
 *          ServletContext.createServlet()/createFilter()/createListener()等は、
 *          ServletContextListener.contextInitialized()でのみ有効。
 *
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
