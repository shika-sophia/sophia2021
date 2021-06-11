package javaGoF.chap13Visitor.visitor;

import java.util.Iterator;

import javaGoF.chap13Visitor.entryElement.AbsEntryVisit;
import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileVisit;

public class ShowVisitor extends AbsVisitor {
    private String currentDir ="";

    @Override
    public void visit(FileVisit file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(DirectoryVisit dir) {
        System.out.println(currentDir + "/" + dir);

        String saveDir = currentDir;
        currentDir = currentDir + "/" + dir.getName();
        Iterator<AbsEntryVisit> dirItr = dir.iterator();
        while(dirItr.hasNext()) {
            AbsEntryVisit entry = dirItr.next();
            entry.accept(this);
        }//while

        currentDir = saveDir;
    }//visit(Directory)

}//class
