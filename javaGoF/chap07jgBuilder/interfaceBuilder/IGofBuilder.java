package javaGoF.chap07jgBuilder.interfaceBuilder;

public interface IGofBuilder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItem(String[] item);
    public abstract void close();
}//interface
