package javaGold.testExamin;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestAryEquals {

    public static void main(String[] args) {
        int[] ary1 = new int[9];
        ary1 = IntStream.range(10,20).toArray();

        int[] ary2 = new int[9];
        ary2 = IntStream.range(10,20).toArray();

        System.out.println(Arrays.equals(ary1, ary2));
        //result: true
    }//main()

}//class
