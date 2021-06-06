package javaGoF.chap10Strategy.threeDeadlock;

import java.util.Random;

public class RandomStrategy implements IThreeStrategy {
    private Random random;
    
    public RandomStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public ThreeHand nextHand() {
        return ThreeHand.getHand(random.nextInt(3));
    }//

    @Override
    public void study(boolean win) { }

}//class
