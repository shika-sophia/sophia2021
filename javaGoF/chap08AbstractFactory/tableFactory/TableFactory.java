package javaGoF.chap08AbstractFactory.tableFactory;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsFactory;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsLink;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsTray;

public class TableFactory extends AbsFactory {
    @Override
    public AbsLink createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public AbsTray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public AbsPage createPage(String title, String author) {
        return new TablePage(title, author);
    }

}//class
