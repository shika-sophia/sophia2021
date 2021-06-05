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
        ThreeHand nextHand = null;
        if(!won) {
            nextHand = ThreeHand.getHand(random.nextInt(3));
        } else {
            nextHand = prevHand;
        }

        return nextHand;
    }//nextHand()

    @Override
    public void study(boolean win) {
        won = win;
    }//study()

}//class
