/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainMethodReference.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p194
 * @content List 5-10, 5-11, 5-12 / メソッド参照
 * @author shika
 * @date 2021-04-04
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainMethodReference {
    private static List<Integer> list = Arrays.asList(3, 1, 2);

    public static void main(String[] args) {
        //---- List 5-10 ラムダ式とメソッド参照 ----
        //Function<String,Integer> func = str -> Integer.parseInt(str);
        Function<String,Integer> func = Integer::parseInt;
        int num = func.apply("100");
        System.out.println("num: " + num);

        //---- List 5-11 Consumer ----
//        List<Integer> list = Arrays.asList(3, 1, 2);
//        //匿名クラス
//        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
//            public void accept(List<Integer> list) {
//                Collections.sort(list);
//            }//accept()
//        };//consumer

        //ラムダ式: listが finalではないため定義不可。フィールドに持っていけば可能。
        //Consumer<List<Integer>> consumer = list -> Collections.sort(list);

        //メソッド参照
        Consumer<List<Integer>> consumer = Collections::sort;

        consumer.accept(list);
        System.out.println("list: " + list);

        //---- List 5-12 Comparator ----
        //ラムダ式
        //Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        //メソッド参照
        Comparator<Integer> comparator = Integer::compare;

        System.out.println(comparator.compare(3, 4));
        System.out.println(comparator.compare(3, 0));
    }//main()

}//class

/*
//====== Lambda / Integer::parsInt ======
num: 100

//====== Anonymous / Lambda / MethodReference ======
list: [1, 2, 3]

//====== Comparator.compare() / Integer.compare() ======
-1
1
 */
