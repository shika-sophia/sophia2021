package javaGoF.chap13Visitor.entryElement;

import java.util.ArrayList;
import java.util.List;

import javaGoF.chap13Visitor.visitor.AbsVisitor;

public class ElementListVisit implements IElementVisit {
    List<AbsEntryVisit> elementList = new ArrayList<>();

    public AbsEntryVisit add(AbsEntryVisit entry) {
        elementList.add(entry);
        return entry;
    }

    @Override
    public void accept(final AbsVisitor v) {
        elementList.forEach(e -> v.visit(e));
    }//accept()

}//class
