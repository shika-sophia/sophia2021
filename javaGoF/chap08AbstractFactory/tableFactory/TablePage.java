package javaGoF.chap08AbstractFactory.tableFactory;

import java.util.Iterator;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsItem;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsPage;

public class TablePage extends AbsPage {

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHtml() {
        var buffer = new StringBuffer();
        buffer.append("<html><head><title>");
        buffer.append(title);
        buffer.append("</title></head> \n");
        buffer.append("<body> \n");
        buffer.append("<h1>" + title + "</h1> \n");

        buffer.append("<table border='1'> \n ");
        Iterator<AbsItem> contentItr = contentList.iterator();
        while(contentItr.hasNext()) {
            AbsItem item = contentItr.next();
            buffer.append("<tr>");
            buffer.append(item.makeHtml());
            buffer.append("</tr>");
        }//while
        buffer.append("</table> \n");

        buffer.append("<hr>");
        buffer.append("<address>" + author + "</address>");
        buffer.append("</body></html> \n");

        return buffer.toString();
    }//makeHtml()

}//class
