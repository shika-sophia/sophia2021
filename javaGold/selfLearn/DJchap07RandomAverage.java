package javaGold.selfLearn;

import java.util.Arrays;
import java.util.Random;

public class DJchap07RandomAverage {

    public void getAverage(int... seed) {
        Arrays.stream(seed)
            .average()
            .ifPresent(
                ave -> System.out.printf(
                        "average:  %.2f \n", ave));
    }//getAverage()

    public static void main(String[] args) {
        var here = new DJchap07RandomAverage();
        var random = new Random();
        int[] seedAry = random.ints(1, 100)
                .limit(random.nextInt(20))
                .toArray();
        here.getAverage(seedAry);
        System.out.println("seedAry: " + Arrays.toString(seedAry));
    }//main()

}//class

/*
average:  75.50
seedAry: [90, 61]

average:  41.92
seedAry: [84, 23, 11, 38, 51, 24, 43, 27, 95, 50, 49, 8]

seedAry: []
要素数 0で avarage: nullのケース
 */
