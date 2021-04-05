/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainCombineFunction.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p206
 * @content List 5-21, 5-22 / 関数の合成
 * @author shika
 * @date 2021-04-05
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.function.Function;
import java.util.function.LongPredicate;

public class MainCombineFunction {

    public static void main(String[] args) {
        //---- andThen() ----
        Function<String,Character> func1 = s -> s.charAt(0);
        Function<Character,Boolean> func2 = c -> Character.isUpperCase(c);
        Function<String,Boolean> func3 = func1.andThen(func2);
        System.out.println(func3.apply("Java"));

        //---- compose() / 上記と同様の処理 ----
        Function<String,Boolean> func4 = func2.compose(func1);
        System.out.println(func4.apply("Java"));

        //---- or(), and(), negate() ----
        LongPredicate pred1 = n -> (n % 3) == 0;
        LongPredicate pred2 = n -> (n % 5) == 0;
        LongPredicate pred3 = pred1.or(pred2);
        LongPredicate pred4 = pred1.and(pred2);
        System.out.println(pred3.test(5));
        System.out.println(pred4.test(15));

        LongPredicate pred5 = pred4.negate();
        System.out.println(pred5.test(15));

    }//main()

}//class

/*
//---- andThen(), compose() ----
true
true

//---- or(), and(), negate() ----
true
true
false

*/