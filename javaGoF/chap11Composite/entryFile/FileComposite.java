package javaGoF.chap11Composite.entryFile;

public class FileComposite extends AbsEntryComposite {
    private String name;
    private int size;

    public FileComposite(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        String output = prefix + "/" + this;
        allList.add(output);
        System.out.println(output);
    }

}//class
