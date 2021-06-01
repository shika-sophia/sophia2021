package javaGoF.chap08AbstractFactory.listFactory;

import java.util.Iterator;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsItem;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;

public class ListPage extends AbsPage {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHtml() {
        var buffer = new StringBuffer();
        buffer.append(
            "<html><head><title>" + title + "</title></header> \n");
        buffer.append("<body> \n");
        buffer.append("<h1>" + title + "</h1> \n");
        buffer.append("<ul> \n");

        Iterator<AbsItem> itemItr = contentList.iterator();
        while(itemItr.hasNext()) {
            AbsItem item = itemItr.next();
            buffer.append(item.makeHtml());
        }//while

        buffer.append("</ul> \n");
        buffer.append("<hr><address>" + author + "</address>");
        buffer.append("</body></html> \n");

        return buffer.toString();
    }//makeHtml()

}//class
