package javaGoF.chap11Composite.entryFile;

public abstract class AbsEntryComposite {
    public abstract String getName();
    public abstract int getSize();

    public AbsEntryComposite add(AbsEntryComposite entry)
            throws FileTreatException {
        throw new FileTreatException();
    }

    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}//class

class FileTreatException extends RuntimeException {
    public FileTreatException() { }
    public FileTreatException(String msg) {
        super(msg);
    }
}//class