package javaGoF.chap10Strategy.threeDeadlock;

import java.util.Random;

public class WinningStrategy implements IThreeStrategy {
    private Random random;
    private boolean won = false;
    private ThreeHand prevHand;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public ThreeHand nextHand() {
        if(!won) {
            prevHand = ThreeHand.getHand(random.nextInt(3));
        }

        return prevHand;
    }//nextHand()

    @Override
    public void study(boolean win) {
        won = win;
    }//study()

}//class
