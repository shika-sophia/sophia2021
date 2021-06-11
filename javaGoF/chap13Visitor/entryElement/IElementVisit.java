package javaGoF.chap13Visitor.entryElement;

import javaGoF.chap13Visitor.visitor.AbsVisitor;

public interface IElementVisit {
    public abstract void accept(AbsVisitor v);
}//interface
