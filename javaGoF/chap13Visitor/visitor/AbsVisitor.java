package javaGoF.chap13Visitor.visitor;

import javaGoF.chap13Visitor.entryElement.AbsEntryVisit;
import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileVisit;

public abstract class AbsVisitor {
    public abstract void visit(FileVisit file);
    public abstract void visit(DirectoryVisit dir);

    public void visit(AbsEntryVisit entry) {
        if(entry instanceof FileVisit) {
            visit((FileVisit) entry);
        } else if (entry instanceof DirectoryVisit) {
            visit((DirectoryVisit) entry);
        }
    }//visit(AbsEntryVisit)

}//class
