package javaGoF.chap11Composite.entryFile;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsEntryComposite {
    public static List<String> allList = new ArrayList<>();

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

    public static void getAbsolute(String entryName) {
        allList.stream()
            .map(s -> s.substring(0, s.lastIndexOf(" (" )))
            .filter(s -> s.endsWith(entryName))
            .forEach(System.out::println);
    }//getAbsolute
}//class

class FileTreatException extends RuntimeException {
    public FileTreatException() { }
    public FileTreatException(String msg) {
        super(msg);
    }
}//class