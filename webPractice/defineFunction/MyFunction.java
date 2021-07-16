/**
 * @title webPractice / defineFunction / MyFunction.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descript / List 8-18, 8-19, 8-20
 * @content 式言語から呼出すFunctionを定義
 * @content 【WingsTag.tld】 タグライブラリ・ディスクリプタへの登録
 * @content 【myFunction.jsp】式言語で staticメソッドの呼出
 * @author shika
 * @date 2021-07-16
 */
package webPractice.defineFunction;

public class MyFunction {
    public static String getProperty(String key) {
        return System.getProperty(key);
    }
}//class

/*
/WEB-INF/taglibs/xxxxx.tld
【WingsTag.tld】 タグライブラリ・ディスクリプタへの登録
<? xml version="1.0" encoding="UTF-8" ?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee/web-javataglibrary_2_1.xsd"
  version="2.1" >

  <uri>http://www.webPractice.defineFunction/WingsTagLibs-1.0</uri>
  <function>
    <name>getProperty</name>
    <function-class>webPractice.defineFunction.MyFunction</function-class>
    <function-signature>
      java.lang.String getProperty(java.lang.String)
    </function-signature>
  </function>
</taglib>

【myFunction.jsp】式言語で staticメソッドの呼出
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- タグライブラリを有効化 --%>
<%@ taglib prefix="win" uri="http://www.webPractice.defineFunction/WingsTagLibs-1.0"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カスタムタグ</title>
</head>
<body>
  拡張フォルダのパス: ${win:getProperty("java.ext.dirs")}
  必要なプロパティ: ${win:getProperty("key")}
</body>
</html>

*/