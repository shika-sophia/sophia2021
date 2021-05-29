package javaGoF.chap07jgBuilder.abstractBuilder;

public abstract class GofBuilder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItem(String[] item);
    public abstract void close();
}//class
