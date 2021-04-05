/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainTwoArgsMethodRef.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p198
 * @content List 5-15, 5-16 / ２引数のメソッド参照, staticとインスタンス
 * @author shika
 * @date 2021-04-05
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MainTwoArgsMethodRef {

    public static void main(String[] args) {
        //==== List 5-15 / ２引数のメソッド参照 ====
        //---- Lambda ----
        BiFunction<String,Integer,Character>
                biFunc1 = (s, i) -> s.charAt(i);
        System.out.println("apply(): " + biFunc1.apply("java", 0));

        BiFunction<Integer,String,Character>
                biFunc2 = (i, s) -> s.charAt(i);
        System.out.println("apply(): " + biFunc2.apply(0, "java"));

        //---- MethodRef ----
        BiFunction<String,Integer,Character>
                biFunc3 = String::charAt;
        System.out.println("apply(): " + biFunc3.apply("java", 0));

        //BiFunction<Integer,String,Character>
        //		biFunc4 = String::charAt;
            //The type String does not define charAt(Integer, String)
            //that is applicable here
        System.out.println();

        //==== List 5-16 / staticとインスタンス ====
        //---- String.length() ----
        Function<String,Integer> func1 = s -> s.length();
        Function<String,Integer> func2 = String::length;
        System.out.println(func1.apply("java"));
        System.out.println(func2.apply("java"));

        //---- String.valueOf() ----
        Function<Integer,String> func3 = i -> String.valueOf(i);
        Function<Integer,String> func4 = String::valueOf;
        System.out.println(func3.apply(10));
        System.out.println(func4.apply(10));

        //---- Integer.hashCode() ----
        Function<Integer,Integer> func5 = i -> i.hashCode();
        System.out.println(func5.apply(100));

        //Function<Integer,Integer> func6 = Integer::hashCode;
            //Ambiguous method reference: あいまいなメソッド参照。２つあって どちらか選べばない。
            //both hashCode() and hashCode(int) from the type Integer are eligible
    }//main()

}//class

/*
//==== List 5-15 ====
apply(): j
apply(): j
apply(): j

//==== List 5-16 ====
4
4
10
10
100 //i.hashCode()
*/