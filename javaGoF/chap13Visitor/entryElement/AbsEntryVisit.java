package javaGoF.chap13Visitor.entryElement;

import java.util.Iterator;

public abstract class AbsEntryVisit implements IElementVisit {
    public abstract String getName();
    public abstract int getSize();

    public AbsEntryVisit add(AbsEntryVisit entry)
            throws FileTreatException {
        throw new FileTreatException();
    }

    public Iterator<AbsEntryVisit> iterator()
            throws FileTreatException {
        throw new FileTreatException();
    }

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}//class

