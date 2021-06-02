package javaGoF.chap08AbstractFactory.tableFactory;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsLink;

public class TableLink extends AbsLink {

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHtml() {
        return String.format(
            "<td><a href=\"%s\">%s</a>\n", url, caption);
    }//makeHtml()
}//class
