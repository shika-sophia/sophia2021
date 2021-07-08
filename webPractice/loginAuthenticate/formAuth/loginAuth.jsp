<% /**
 * @title webPractice / loginAuthenticate / formAuth / loginAuth.jsp
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第７章 Deployment Descriptor / p360 / List 7-15, 7-16, 7-17
 *          form認証の設定XMLと JSPページ
 *          動作させるには JSPを WebContent配下に配置し、XMLを所定の位置に記述
 * @author shika
 * @date 2021-07-08
 */ %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム認証</title>
</head>
<body>
<form action="j_security_check" method="POST">
    <input type="text" name="j_username" size="15" />
    <input type="password" name="j_password" size="15" />
    <input type="submit" value="ログイン" />
    <input type="reset" value="取消" />
</form>
</body>
</html>

<% /*
【web.xml】 /WEB-INF/配下 | /%CATALINA_HOME%/webapps配下に配置
<?xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/web-app_3_0.xsd"
  version="3.0" >

  <!-- アクセス制限する領域とアクセス許可するロールを定義>
  <security-constraint>
    <web-soruce-collection>
      <web-soruce-name>Chap07 Form Auth</web-soruce-name>
      <url-pattern>/chap07/auth/*</url-pattern>
    </web-soruce-collection>

    <auth-constraint>
      <role-name>admin-gui</role-name>
      <role-name>manager-gui</role-name>
    </auth-constraint>
  <security-constraint>

  <!-- 認証の方法と表示ページのパスを定義 -->
  <login-config>
    <auth-method>FORM</auth-method>
    <form-login-config>
      <form-login-page>/chap07/loginAuth.jsp</form-login-page>
      <form-error-page>/chap07/loginAuth_err.jsp</form-error-page>
    </form-login-config>
  </login-config>

  <!-- 利用可能なロール(=ユーザーグループ)を定義 -->
  <security-role>
    <role-name>admin-gui</role-name>
  </security-role>
  <security-role>
    <role-name>manager-gui</role-name>
  </security-role>
</web-app>

【tomcat-users.xml】 /%CATALINA_HOME%/conf配下に配置
<? xml version="1.0" encoding="ms932" ?>
<tomcat-users>
  <!-- 利用可能なロール名を定義 -->
  <role rolename="admin-gui" />
  <role rolename="manager-gui" />

  <!-- 利用可能なユーザー名を定義 -->
  <user name="yamada" password="12345" roles="admin-gui, manager-gui" />
  <user name="suzuki" password="12345" roles="admin-gui" />
  <user name="fujii" password="12345" roles="manager-gui" />
</tomcat-users>
*/ %>