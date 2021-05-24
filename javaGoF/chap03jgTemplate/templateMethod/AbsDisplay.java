package javaGoF.chap03jgTemplate.templateMethod;

public abstract class AbsDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        final int BOUND = 5;//最大回数
        open();
        for(int i = 0; i < BOUND; i++) {
            print();
        }//for

        close();
    }//display()
}//class
