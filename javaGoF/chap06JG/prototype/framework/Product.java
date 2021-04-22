package javaGoF.chap06JG.prototype.framework;

public interface Product extends Cloneable {
    public abstract void use(String str);
    public abstract Product createClone();
}//interface
