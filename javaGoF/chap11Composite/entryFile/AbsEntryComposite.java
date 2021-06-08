package javaGoF.chap11Composite.entryFile;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsEntryComposite {
    protected static List<List<AbsEntryComposite>>
            allList = new ArrayList<>();
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

    public static void getAbsolute(final String entryName) {
        allList.stream()
            .filter(list ->
                list.stream()
                    .anyMatch(e -> e.getName().contains(entryName)))
            .forEach(list ->
                    list.stream()
                        .forEach(e -> e.printList(entryName))
            );
    }//getAbsolute()

}//class

class FileTreatException extends RuntimeException {
    public FileTreatException() { }
    public FileTreatException(String msg) {
        super(msg);
    }
}//class