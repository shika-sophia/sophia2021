package javaGoF.chap08AbstractFactory.listFactory;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsFactory;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsLink;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsTray;

public class ListFactory extends AbsFactory {

    @Override
    public AbsLink createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public AbsTray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public AbsPage createPage(String title, String author) {
        return new ListPage(title, author);
    }

}//class
