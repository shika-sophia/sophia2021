/**
 * @title javaGoF / chap08AbstractFactory / MainAbstractFactory.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第８章 AbstractFactory / p96 / List 8-1 ～ 8-14
 * @content abstractの部品で abstractな製品を作る。それを具体化。
 *          TemplateMethodを、クラス構造にした感じ。
 *
 * @class MainAbstractFactory / ◆main(), new SwingSelectList()
 * @class SwingSelectList
 *
 * @package ---- abstractFactory ----
 * @class AbsFactory
 * @class AbsItem
 * @class AbsLink extends AbsItem
 * @class AbsTray extends AbsItem
 * @class AbsPage
 *
 * @package ---- listFactory ----
 * @class ListFactory extends AbsFactory
 * @class ListLink extends AbsLink
 * @class ListTray extends AbsTray
 * @class ListPage extends AbsPage / makeHtml(), output()
 *
 * @package ---- tableFactory ----
 * @class TableFactory extends AbsFactory
 * @class TableLink extends AbsLink
 * @class TableTray extends AbsTray
 * @class TablePage extends AbsPage / makeHtml(), output()
 *
 * @package ---- outputHtml ----
 * @file listpage.html
 * @see  listFactoryResult.jpg
 * @file tablefactory.html
 * @see  tableFactoryResult.jpg
 * @author shika
 * @date 2021-06-01
 */
package javaGoF.chap08AbstractFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsFactory;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsLink;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsTray;

public class MainAbstractFactory {

    public static void main(String[] args) {
        //---- build List of directory + className ----
        String here = System.getProperty("sun.java.command");
        String dir = here.substring(0, here.lastIndexOf("."));

        List<String> classNameList = new ArrayList<>(
            Arrays.asList(".listFactory.ListFactory", ".tableFactory.TableFactory"));

        //---- view selectList of Swing ----
        System.out.println("Swing Window is making...");
        var swing = new SwingSelectList(classNameList);
        String select = swing.getSelect();
        System.out.println("select: " + select);
        System.out.println(dir + select);

        //---- Factory ----
        @SuppressWarnings("deprecation")
        AbsFactory factory = AbsFactory.getFactory(dir + select);

        AbsLink asahi = factory.createLink(
            "朝日新聞", "http://www.asahi.com/");
        AbsLink yomiuri = factory.createLink(
            "讀賣新聞", "http://www.yomiuri.co.jp/");
        AbsLink yahoo_us = factory.createLink(
            "Yahoo!", "http://www.yahoo.com/");
        AbsLink yahoo_jp = factory.createLink(
            "Yahoo!Japan", "http://www.yahoo.co.jp/");
        AbsLink excite = factory.createLink(
            "Excite", "http://www.excite.com/");
        AbsLink google = factory.createLink(
            "Google", "http://www.google.com/");

        AbsTray trayNews = factory.createTray("news");
        trayNews.addItem(asahi);
        trayNews.addItem(yomiuri);

        AbsTray trayYahoo = factory.createTray("yahoo");
        trayYahoo.addItem(yahoo_us);
        trayYahoo.addItem(yahoo_jp);

        AbsTray traySearch = factory.createTray("search");
        traySearch.addItem(trayYahoo);
        traySearch.addItem(excite);
        traySearch.addItem(google);

        AbsPage page = factory.createPage(
            select.substring(select.lastIndexOf(".") + 1), "結城 浩");
        page.addContent(trayNews);
        page.addContent(traySearch);

        //---- output ----
        page.output();

        System.exit(0); //Swingを閉じる
    }//main()
}//class

/*
select in Swing Window
select: ListFactory

Swing Window is making...
select in Swing Window
select: /listFactory/ListFactory
build/classes/javaGoF/chap08AbstractFactory/listFactory/ListFactory
java.lang.ClassNotFoundException: build/classes/javaGoF/chap08AbstractFactory/listFactory/ListFactory
    at java.base/java.lang.Class.forName0(Native Method)
    at java.base/java.lang.Class.forName(Class.java:315)
    at javaGoF.chap08AbstractFactory.abstractFactory.AbsFactory.getFactory(AbsFactory.java:10)
    at javaGoF.chap08AbstractFactory.MainAbstractFactory.main(MainAbstractFactory.java:33)
Exception in thread "main" java.lang.NullPointerException
    at javaGoF.chap08AbstractFactory.MainAbstractFactory.main(MainAbstractFactory.java:35)

Swing Window is making...
select in Swing Window
select: .listFactory.ListFactory
javaGoF.chap08AbstractFactory.listFactory.ListFactory
linkpage.html を作成しました。

【考察】
Class.forName()のクラスローダーで pathが通らず
ClassNotFoundExceptionが出ている状態。

おぉ、できた。
Eclipseのカレントであるプロジェクト名からの相対パスと考えていたが、
importと同じで、完全修飾クラス名は「src/」や「build/classes/」は不要で
package名の最初から、つまりいつもの完全修飾名を
Class.forName()の引数に渡せばそれで済む。

//====== listfactory.html ======
<html><head><title>LinkPage</title></head>
<body>
<h1>LinkPage</h1>
<ul>
<li>
news
<ul>
  <li><a href="http://www.asahi.com/"> 朝日新聞 </a></li>
  <li><a href="http://www.yomiuri.co.jp/"> 讀賣新聞 </a></li>
</ul>
</li>
<li>
search
<ul>
<li>
yahoo
<ul>
  <li><a href="http://www.yahoo.com/"> Yahoo! </a></li>
  <li><a href="http://www.yahoo.co.jp/"> Yahoo!Japan </a></li>
</ul>
</li>
  <li><a href="http://www.excite.com/"> Excite </a></li>
  <li><a href="http://www.google.com/"> Google </a></li>
</ul>
</li>
</ul>
<hr><address>結城 浩</address></body></html>

@see ./outputHtml/listFactoryResult.jpg


//====== tablefactory.html ======
<html><head><title>TableFactory</title></head>
<body>
<h1>TableFactory</h1>
<table border='1'>
 <tr><td><table border='1'><tr><td bgcolor='pink' align='center' colspan='2'><b>news</b></td></tr>
<tr>
<td><a href="http://www.asahi.com/">朝日新聞</a>
<td><a href="http://www.yomiuri.co.jp/">讀賣新聞</a>
</tr></table></td></tr><tr><td><table border='1'><tr><td bgcolor='pink' align='center' colspan='3'><b>search</b></td></tr>
<tr>
<td><table border='1'><tr><td bgcolor='pink' align='center' colspan='2'><b>yahoo</b></td></tr>
<tr>
<td><a href="http://www.yahoo.com/">Yahoo!</a>
<td><a href="http://www.yahoo.co.jp/">Yahoo!Japan</a>
</tr></table></td><td><a href="http://www.excite.com/">Excite</a>
<td><a href="http://www.google.com/">Google</a>
</tr></table></td></tr></table>
<hr><address>結城 浩</address></body></html>

@see tableFactoryResult.jpg
*/

