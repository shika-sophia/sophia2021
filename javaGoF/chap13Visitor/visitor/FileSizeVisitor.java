package javaGoF.chap13Visitor.visitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javaGoF.chap13Visitor.entryElement.AbsEntryVisit;
import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileVisit;

public class FileSizeVisitor extends AbsVisitor {
    private Map<String, Integer> sizeMap = new HashMap<>();

    @Override
    public void visit(FileVisit file) {
        sizeMap.put(file.getName(), file.getSize());
    }//visit(File)

    @Override
    public void visit(DirectoryVisit dir) {
        sizeMap.put(dir.getName(), dir.getSize());

        Iterator<AbsEntryVisit> dirItr = dir.iterator();
        while(dirItr.hasNext()) {
            AbsEntryVisit entry = dirItr.next();
            entry.accept(this);
        }
    }//visit(Directory)

    public int getFileSize(AbsEntryVisit entry) {
        return sizeMap.get(entry.getName());
    }//getFileSize(Entry)

    public int getFileSize(String entry) {
        return sizeMap.get(entry);
    }//getFileSize(String)

    public Map<String, Integer> getSizeMap() {
        return sizeMap;
    }

    public void showSize() {
        for(var mapEntry : sizeMap.entrySet()){
            System.out.println(
                mapEntry.getKey() + ": " + mapEntry.getValue());
        }//for
    }//showSize()
}//class
