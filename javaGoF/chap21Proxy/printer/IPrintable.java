package javaGoF.chap21Proxy.printer;

public interface IPrintable {
    public abstract void setPrintName(String name);
    public abstract String getPrintName();
    public abstract void print(String str);
}//interface
