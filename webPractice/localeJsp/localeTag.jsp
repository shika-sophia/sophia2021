<%--
/**
 * @title WebContent / locale / localTag.jsp
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第５章 JSTL / p247 / 5.5.4 ロケール情報を設定する
 * @content <fmt:setLocale>
 *              value="ja_JP" 言語コード: ja(日本語), en(英語), fr(仏語), de(独語)
 *                            国コード: JP(日), US(米), BK(英), AU(豪), FR(仏), DE(独)
 *          <fmt:formatDate>
 *          <fmt:formatNumber>

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
<%@ page import="java.util.Date" %>
<% pageContext.setAttribute("today", new Date()); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL: i18nタグライブラリ</title>
</head>
<body>
<c:set var="num" value="2501.9812" />

<%-- Localeが ja_JP 日本の場合の整形 --%>
<fmt:setLocale value="ja_JP" />
日本 ->
<fmt:formatDate value="${ today }" type="BOTH"
    dateStyle="LONG" timeStyle="LONG" /><br />
<fmt:formatNumber value="${ num }" type="NUMBER" groupingUsed="true"
    minIntegerDigits="5" maxFractionDigits="3" /><br />

<%-- Localeが en_US 英語_アメリカの場合の整形 --%>
<fmt:setLocale value="en_US" />
アメリカ ->
<fmt:formatDate value="${ today }" type="BOTH"
    dateStyle="LONG" timeStyle="LONG" /><br />
<fmt:formatNumber value="${ num }" type="NUMBER" groupingUsed="true"
    minIntegerDigits="5" maxFractionDigits="3" /><br />

<%-- Localeが de_DE ドイツ語_ドイツの場合の整形 --%>
<fmt:setLocale value="de_DE" />
ドイツ ->
<fmt:formatDate value="${ today }" type="BOTH"
    dateStyle="LONG" timeStyle="LONG" /><br />
<fmt:formatNumber value="${ num }" type="NUMBER" groupingUsed="true"
    minIntegerDigits="5" maxFractionDigits="3" /><br />

</body>
</html>

<%-- 実行結果
    日本 -> 2021年4月26日 16:40:27 JST
    02,501.981
    アメリカ -> April 26, 2021 at 4:40:27 PM JST
    02,501.981
    ドイツ -> 26. April 2021 um 16:40:27 JST
    02.501,981
--%>

