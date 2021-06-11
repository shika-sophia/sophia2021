package javaGoF.chap13Visitor.entryElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javaGoF.chap13Visitor.visitor.AbsVisitor;

public class DirectoryVisit extends AbsEntryVisit {
    private String name;
    private List<AbsEntryVisit>
                entryList = new ArrayList<>();

    public DirectoryVisit(String name) {
        this.name = name;
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

    public AbsEntryVisit add(AbsEntryVisit entry) {
        entryList.add(entry);
        return this;
    }//add()

    @Override
    public Iterator<AbsEntryVisit> iterator(){
        return entryList.iterator();
    }

    @Override
    public void accept(AbsVisitor v) {
        v.visit(this);
    }
}//class

