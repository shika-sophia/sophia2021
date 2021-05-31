package javaGoF.chap08AbstractFactory.abstractFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsTray extends AbsItem {
    protected List<AbsItem> itemList = new ArrayList<>();

    public AbsTray(String caption) {
        super(caption);
    }

    public void addItem(AbsItem item) {
        itemList.add(item);
    }//addItem()
}//class
