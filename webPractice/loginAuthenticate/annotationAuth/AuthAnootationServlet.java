/**
 * @title webPractice / loginAuthenticate / annotationAuth / AuthAnnotationServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第７章 Deployment Descriptor / p368 / List 7-19
 *          アノテーションで form認証の機能を実現する
 *          <security-constraint>要素を代替する。
 *          フォルダ単位の管理には、web.xmlが必要。
 *          ページ単位のアクセス規制ならアノテーションで十分
 *
 * @author shika
 * @date 2021-07-08
 */
package webPractice.loginAuthenticate.annotationAuth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(
    @HttpConstraint(
        rolesAllowed = {"admin-gui", "manager-gui"}))
@WebServlet("/AuthAnootationServlet")
public class AuthAnootationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//doPost()

}//class
