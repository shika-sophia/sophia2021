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
        //---- view selectList of Swing ----
        List<String> classNameList = new ArrayList<>(
            Arrays.asList("ListFactory", "TableFactory"));

        var swing = new SwingSelectList(classNameList);
        String select = swing.getSelect();
        //System.out.println("select: " + select);

        //---- Factory ----
        @SuppressWarnings("deprecation")
        AbsFactory factory = AbsFactory.getFactory(select);

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

        AbsPage page = factory.createPage("LinkPage", "結城 浩");
        page.addContent(trayNews);
        page.addContent(traySearch);

        //---- output ----
        page.output();
    }//main()
}//class

/*
select in Swing Window
select: ListFactory
*/