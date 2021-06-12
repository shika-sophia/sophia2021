package javaGoF.chap13Visitor.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javaGoF.chap13Visitor.entryElement.AbsEntryVisit;
import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileVisit;

public class FindVisitor extends AbsVisitor {
    private String findKey;
    private List<AbsEntryVisit> findList = new ArrayList<>();

    public FindVisitor(String findKey) {
        this.findKey = findKey;
    }

    @Override
    public void visit(FileVisit file) {
        if(file.getName().contains(findKey)) {
            findList.add(file);
        }
    }//visit(File)

    @Override
    public void visit(DirectoryVisit dir) {
        Iterator<AbsEntryVisit> dirItr = dir.iterator();
        while(dirItr.hasNext()) {
            AbsEntryVisit entry = dirItr.next();
            entry.accept(this);
        }
    }//visit(Directory)

    public List<AbsEntryVisit> getFindList() {
        return findList;
    }
}//class
