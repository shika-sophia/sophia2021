package javaGoF.chap08AbstractFactory.listFactory;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsLink;

public class ListLink extends AbsLink {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHtml() {
        return String.format(
            "  <li><a href=\"%s\"> %s </a></li> \n", url, caption);
    }

}//class
