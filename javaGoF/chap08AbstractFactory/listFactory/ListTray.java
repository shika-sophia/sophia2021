package javaGoF.chap08AbstractFactory.listFactory;

import java.util.Iterator;

import javaGoF.chap08AbstractFactory.abstractFactory.AbsItem;
import javaGoF.chap08AbstractFactory.abstractFactory.AbsTray;

public class ListTray extends AbsTray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHtml() {
        var buffer = new StringBuffer();
        buffer.append("<li> \n");
        buffer.append(caption + "\n");
        buffer.append("<ul> \n");

        Iterator<AbsItem> itemItr= itemList.iterator();
        while(itemItr.hasNext()) {
            AbsItem item = itemItr.next();
            buffer.append(item.makeHtml());
        }//while

        buffer.append("</ul> \n");
        buffer.append("</li> \n");

        return buffer.toString();
    }//makeHtml()

}//class
