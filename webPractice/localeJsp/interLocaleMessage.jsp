<%--
/**
 * @title WebContent / locale / interLocaleMessage.jsp
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第５章 JSTL / p249 / 5.5.5 国際化対応ページ
 * @content <fmt:setBundle>, <fmt:message>
 * @propertyFile msg.properties, msg_de.properties, msg_jp.properties
 *               上記のプロパティファイルを WebContent/WEB-INF/classesに配置(階層、名前固定)
 * @prepareEncode Command Promptで実行。あらかじめエンコードしたファイルを作成。
 *                >cd sophia2021\WebContent\WEB-INF\classes
 *                >native2ascii -encoding UTF-8 msg_jp.properties.utf8 msg_jp.properties
 *                準備ファイル  msg_jp.properties.utf8は削除する。
 
 * @enviroment JSTLの jarファイル２つ〔jstl-api-1.2.jar, jasl-impl-1.2.jar〕を
 *             WebContent/WEB-INF/libに配置。
 *             このjspファイルも WebContent内に配置の上、Serverで実行(Tomcat8.5)
 * @author shika
 * @date 2021-04-27
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Date" %>
<% pageContext.setAttribute("today", new Date()); %>

<%-- クライアント言語設定を取得し設定 accept-languageヘッダ --%>
<fmt:setLocale value="${fn:split(header['accept-language'], ',')[0]}" />

<%-- ベース名 msg のプロパティファイルを読み込み --%>
<fmt:setBundle basename="msg" var="msg" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InterLocale Page</title>
</head>
<body>
<%-- keｙ= morning, night, nowのプロパティを取得 --%>
<fmt:message key="morning" bundle="${ msg }" /><br />
<fmt:message key="night" bundle="${ msg }" /><br />
<fmt:message key="now" bundle="${ msg }">
  <fmt:param>
    <fmt:formatDate value="${ today }" type="TIME" timeStyle="MEDIUM" />
  </fmt:param>
</fmt:message> <!-- //now -->
</body>
</html>

<%--
    Good Morning
    Good Night
    It is 18:37:52 Now

    【考察】 プレースホルダ― setLocale value="${fn:split(a, b)[0]}"
    プロパティファイルを { 0 }としていたら、読み込み失敗して、白ページに
  {0}に修正したら、うまくいきました。

<fmt:setLocale value="de_DE" />
	Guten Morgen
	Gute Nacht
	Es ist jetzt 18:46:29

<fmt:setLocale value="ja_JP" />
	おはようございます
	おやすみなさい
	現在時刻は 18:50:01 です
--%>