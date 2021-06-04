package javaGoF.chap09Bridge.bridgeFunction;

import java.util.stream.IntStream;

import javaGoF.chap09Bridge.bridgeImplementation.AbsDisplayImpl;

public class IncrementDisplay extends javaGoF.chap09Bridge.bridgeFunction.RandomDisplay {

    public IncrementDisplay(AbsDisplayImpl impl) {
        super(impl);
    }

    //逓増する繰り返し
    public void gradualIncrease(int times) {
        int randomTimes = ramdomReturn(times);
        IntStream.rangeClosed(0, randomTimes)
                 .forEach(i -> multiDisplay(i));
    }//gradualIncrease()
}//class
