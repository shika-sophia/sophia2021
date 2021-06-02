package javaGoF.chap08AbstractFactory.tableFactory;

import java.util.Iterator;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsItem;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsTray;

public class TableTray extends AbsTray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHtml() {
        var buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table border='1'><tr>");
        buffer.append(String.format(
            "<td bgcolor='pink' align='center' colspan='%d'>" +
            "<b>%s</b></td>", itemList.size(), caption));
        buffer.append("</tr> \n");

        buffer.append("<tr> \n");
        Iterator<AbsItem> itemItr = itemList.iterator();
        while(itemItr.hasNext()) {
            AbsItem item = itemItr.next();
            buffer.append(item.makeHtml());
        }//while
        buffer.append("</tr></table>");
        buffer.append("</td>");

        return buffer.toString();
    }//makeHtml()

}//class
