/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainMidOperation.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.3 StreamAPI 中間処理 / p484 / List 10-19 ～ 10-22, 10-26, 10-27
 * @content Stream<T> filter(Predicate<T>)
 *          Stream<R> map(Function<T, R>)
 *          Stream<R> flatMap(Function<T,R>)
 *          Stream<T> sorted([Comparater])
 *          Stream<T> sorted(Comparator) / Comparator.compare(T, T)
 *          Stream<T> peek(Comsumer<T>)
 *          Stream<T> distinct()
 *
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainMidOperation {

    public static void main(String[] args) {
        //Stream<T> filter(Predicate<T>)
        Stream.of("https://www.shoeisha.co.jp",
                "SEshop",
                "https://codezine.jp",
                "http://wings.msn.to",
                "WingsOroject")
        .filter(s -> s.startsWith("https://"))
        .forEach(System.out::println);

        //Stream<R> map(Function<T, R>)
        List<String> list = new ArrayList<>(
            Arrays.asList("バラ","さくら","チューリップ","あさがお"));
        list.stream()
            .map(s -> s.length())
            .forEach(i -> System.out.printf("%d ", i));
        System.out.println();

        //Stream<R> flatMap(Function<T,R>)
        var biAry = new String[][] {
            {"あいう","かきく","さしす"},
            {"たちつ","なにぬ"},
            {"はひふ","まみむ"}
        };
        String[] flatAry =Arrays.stream(biAry)
            .flatMap(ary -> Arrays.stream(ary))
            .toArray(String[]::new);
        System.out.println("flatAry: " + Arrays.toString(flatAry));

        //flatMap()で要素を加工。
        //二次元配列なので入れ子のstream()で要素を取り出し flatMap()で一次元配列へ
        Arrays.stream(biAry)
            .flatMap(ary -> Arrays.stream(ary).map(s -> s.charAt(0)))
            .forEach(s -> System.out.print(s + " "));
        System.out.println();

        //Stream<T> sorted()
        list.stream()
            .sorted()
            .forEach(s -> System.out.printf("%s ", s));
        System.out.println();

        //Stream<T> sorted(Comparator)
        list.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(s -> System.out.printf("%s ", s));
        System.out.println();

        //Stream<T> sorted(Comparator) / Comparator.compare(T, T)
        list.stream()
            .sorted((str1, str2) -> str1.length() - str2.length())
            .forEach(s -> System.out.printf("%s ", s));
        System.out.println();

        //distinct()
        list.add("きんもくせい");
        list.add("さくら");
        list.add("あさがお");
        System.out.println("list: before " + list);

        System.out.print("list: after [");
        list.stream()
            .distinct()
            .forEach(s -> System.out.print(s + " "));
        System.out.println("]");
    }//main()

}//class

/*
//---- filter() ----
https://www.shoeisha.co.jp
https://codezine.jp

//---- map() ----
2 3 6 4

//---- flatMap() ----
flatAry: [あいう, かきく, さしす, たちつ, なにぬ, はひふ, まみむ]
あ か さ た な は ま

//---- sorted() ----
あさがお さくら チューリップ バラ
バラ チューリップ さくら あさがお
バラ さくら あさがお チューリップ

//---- distinct()----
list: before [バラ, さくら, チューリップ, あさがお, きんもくせい, さくら, あさがお]
list: after [バラ さくら チューリップ あさがお きんもくせい ]

*/