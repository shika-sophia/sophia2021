package javaGoF.chap05jgSingletion.singleton;

public final class Singleton {
    private final static Singleton singleton = new Singleton();

    private Singleton() { }

    public final static Singleton getInstance() {
        return singleton;
    }//getInstance()
}//class
