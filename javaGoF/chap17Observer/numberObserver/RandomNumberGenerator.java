package javaGoF.chap17Observer.numberObserver;

import java.util.Random;

public class RandomNumberGenerator extends AbsNumberGenerator {
    private Random random = new Random();
    private int number;           //生成した数値
    private final int TIMES = 20; //乱数生成の回数
    private final int RANGE = 50; //乱数の範囲 [0 <= number < RANGE]

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for(int i = 0; i < TIMES; i++) {
            number = random.nextInt(RANGE);
            notifyObserver();
        }//for
    }//execute()

}//class
