package javaGoF.chap11Composite.entryFile;

import java.util.ArrayList;
import java.util.List;

public class DirectoryComposite extends AbsEntryComposite {
    private String name;
    private List<AbsEntryComposite>
                entryList = new ArrayList<>();

    public DirectoryComposite(String name) {
        this.name = name;
        AbsEntryComposite.allList.add(entryList);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = entryList.stream()
                    .mapToInt(entry -> entry.getSize())
                    .sum();
        return size;
    }//getSize()

    public AbsEntryComposite add(AbsEntryComposite entry) {
        entryList.add(entry);
        return this;
    }//add()

    @Override
    protected void printList(final String prefix) {
        System.out.println(prefix + "/" + this);

        entryList.forEach(entry ->
            entry.printList(prefix + "/" + name));//ここのprintList()は各Fileのメソッド
    }//printList()

}//class

/*
//====== getSize() as original code Iterator version ======
import java.util.Iterator;
public int getSize() {
    int size = 0;
    Iterator<AbsEntryComposite> entryItr = entryList.iterator();
    while(entryItr.hasNext()) {
        AbsEntryComposite entry = entryItr.next();
        size += entry.getSize();
    }//while
}//getSize()
*/