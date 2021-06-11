package javaGoF.chap13Visitor.visitor;

import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileVisit;

public abstract class AbsVisitor {
    public abstract void visit(FileVisit file);
    public abstract void visit(DirectoryVisit dir);
}//class
