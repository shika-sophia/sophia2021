package javaGoF.chap09Bridge.bridgeFunction;

import javaGoF.chap09Bridge.bridgeImplementation.AbsDisplayImpl;

public class CountDisplay extends BridgeDisplay {

    public CountDisplay(AbsDisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for(int i = 0; i < times; i++) {
            print();
        }
        close();
    }//multiDisplay()
}//class
