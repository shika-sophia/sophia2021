/**
 * @title javaGoF / chap08AbstractFactory / MainYahooPage.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第８章 AbstractFactory / List A8-1, A8-2
 * @content Yahooリンクを表示するHTMLを作成。
 *          ListFactory, TableFactoryを選択できる。
 *          追加したのは、以下のクラス・メソッドのみ
 * @class MainYahooPage / ◆main()
 * @class AbsFactory / createYahooPage(String select)
 *
 * @see listFactoryYahoo.jpg
 * @see tableFactoryYahoo.jpg
 * @author shika
 * @date 2021-06-02
 */
package javaGoF.chap08AbstractFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsFactory;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;

public class MainYahooPage {

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

        //---- create YahooPage ----
        AbsPage page = factory.createYahooPage(
            select.substring(select.lastIndexOf(".") + 1));
        page.output();

        System.exit(0);
    }//main()

}//class

/*
//====== ListFactory_Yahoo ======
<html><head><title>ListFactory_Yahoo</title></head>
<body>
<h1>ListFactory_Yahoo</h1>
<ul>
  <li><a href="http://www.yahoo.com/"> Yahoo! </a></li>
</ul>
<hr><address>Yahoo!</address></body></html>

@see listFactoryYahoo.jpg


//====== TableFactory_Yahoo ======
<html><head><title>TableFactory_Yahoo</title></head>
<body>
<h1>TableFactory_Yahoo</h1>
<table border='1'>
 <tr><td><a href="http://www.yahoo.com/">Yahoo!</a>
</tr></table>
<hr><address>Yahoo!</address></body></html>

@see tableFactoryYahoo.jpg
*/