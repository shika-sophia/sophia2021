package javaGoF.chap10Strategy.threeDeadlock;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class HistoryStrategy implements IThreeStrategy {
    private Random random;
    private int prevValue = 0;
    private int currentValue = 0;
    private int[][] history = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    public HistoryStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public ThreeHand nextHand() {
        int bet = random.nextInt(getSum(currentValue));

        int handValue = 0;
        if(bet < history[currentValue][0]) {
            handValue = 0;
        } else if(bet < history[currentValue][0]
                + history[currentValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }//if
        prevValue = currentValue;
        currentValue = handValue;

        return ThreeHand.getHand(handValue);
    }//nextHand()

    private int getSum(final int currentValue) {
        int sum = Arrays.stream(history)
            .flatMapToInt(ary -> IntStream.of(ary[currentValue]))
            .sum();
        return sum;
    }//getSum()

    @Override
    public void study(boolean win) {
        if(win) {
            history[prevValue][currentValue]++;
        } else {
            history[prevValue][(currentValue + 1) % 3]++;
            history[prevValue][(currentValue + 2) % 3]++;
        }
    }//study()

    //---- Test main() of getSum() ----
    public static void main(String[] args) {
        var here = new HistoryStrategy(0);
        int sum = here.getSum(0);
        System.out.println(sum); // 3
    }//main()
}//class
