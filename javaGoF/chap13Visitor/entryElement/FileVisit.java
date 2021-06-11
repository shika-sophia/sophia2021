package javaGoF.chap13Visitor.entryElement;

import javaGoF.chap13Visitor.visitor.AbsVisitor;

public class FileVisit extends AbsEntryVisit {
    private String name;
    private int size;

    public FileVisit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(AbsVisitor v) {
        v.visit(this);
    }

}//class
