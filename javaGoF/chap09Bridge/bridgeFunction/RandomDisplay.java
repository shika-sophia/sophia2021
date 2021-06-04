package javaGoF.chap09Bridge.bridgeFunction;

import java.util.Random;

import javaGoF.chap09Bridge.bridgeImplementation.AbsDisplayImpl;

public class RandomDisplay extends CountDisplay {

    public RandomDisplay(AbsDisplayImpl impl) {
        super(impl);
    }

    protected int ramdomReturn(int times) {
        //0以上 times未満の乱数
        var random = new Random();
        int randomTimes = random.nextInt(times);

        return randomTimes;
    }

    public void randomDisplay(int times) {
        int randomTimes = ramdomReturn(times);

        //CountDisplay.multiDisplay()
        multiDisplay(randomTimes);
    }//ramdomDisplay()

}//class
