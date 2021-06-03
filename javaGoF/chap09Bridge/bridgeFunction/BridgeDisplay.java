package javaGoF.chap09Bridge.bridgeFunction;

import javaGoF.chap09Bridge.bridgeImplementation.AbsDisplayImpl;

public class BridgeDisplay {
    private AbsDisplayImpl impl;

    public BridgeDisplay(AbsDisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}//class
