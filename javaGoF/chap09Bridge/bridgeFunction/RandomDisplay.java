package javaGoF.chap09Bridge.bridgeFunction;

import java.util.Random;
import java.util.stream.IntStream;

import javaGoF.chap09Bridge.bridgeImplementation.AbsDisplayImpl;

public class RandomDisplay extends CountDisplay {

    public RandomDisplay(AbsDisplayImpl impl) {
        super(impl);
    }

    private int ramdomReturn(int times) {
        //0以上 times未満の乱数
        var random = new Random();
        int randomTimes = random.nextInt(times - 1) + 1;

        return randomTimes;
    }

    public void randomDisplay(int times) {
        int randomTimes = ramdomReturn(times);

        //CountDisplay.multiDisplay()
        multiDisplay(randomTimes);
    }//ramdomDisplay()


    //逓増する繰り返し
    public void gradualIncrease(int times) {
        int randomTimes = ramdomReturn(times);
        IntStream.rangeClosed(0, randomTimes)
                 .forEach(i -> multiDisplay(i));
    }//gradualIncrease()
}//class
