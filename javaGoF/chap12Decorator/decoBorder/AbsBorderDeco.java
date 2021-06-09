package javaGoF.chap12Decorator.decoBorder;

public abstract class AbsBorderDeco extends AbsDisplayDeco {
    protected AbsDisplayDeco display;

    protected AbsBorderDeco(AbsDisplayDeco display) {
        this.display = display;
    }

}//class
