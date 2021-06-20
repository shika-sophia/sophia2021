package javaGoF.chap17Observer.numberObserver;

import java.util.Random;

public class RandomNumberGenerator extends AbsNumberGenerator {
    private Random random = new Random();
    private int number;           //生成した数値
    private final int TIMES; //乱数生成の回数
    private final int RANGE; //乱数の範囲 [0 <= number < RANGE]

    public RandomNumberGenerator() {
        this.TIMES = 20;
        this.RANGE = 50;
    }

    public RandomNumberGenerator(int TIMES, int RANGE) {
        this.TIMES = TIMES;
        this.RANGE = RANGE;
    }

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

    public int getTimes() {
        return TIMES;
    }

}//class
