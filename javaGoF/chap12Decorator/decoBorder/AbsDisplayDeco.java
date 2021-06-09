package javaGoF.chap12Decorator.decoBorder;

public abstract class AbsDisplayDeco {
    public abstract int getColumn();
    public abstract int getRow();
    public abstract String getText(int row);

    public final void show() {
        for(int i = 0; i < getRow(); i++) {
            System.out.println(getText(i));
        }//for
    }//show()
}//class
