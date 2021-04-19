/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainFactoryStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2 StreamAPI / p481 / List 10-13 ～ 10-18
 * @content ◆Streamインターフェイス
 *          Stream<T> of(T...)
 *          Stream<T> generate(Supplier<T>)
 *          Stream<T> iterate(T, UnaryOperator<T>)
 *          Stream<T> concat(Stream<T>, Stream<T>)
 *          Builder<Object> Stream.builder() / add(), build()
 *
 *          ◆その他
 *          IntStream Random.ints(int begin, int end)
 *          IntStream IntStream.range(int begin, int end) endを含まず
 *          IntStream IntStream.rangeClosed(int begin, int end) endを含む
 *
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainFactoryStream {

    public static void main(String[] args) {
        //Stream<T> Stream.of(T...)
        Stream<String> stream = Stream.of("first","second","third");
        stream.forEach(System.out::println);

        //Stream<T> Stream.generate(Supplier<T>).limit(long)
        Stream<Integer> stream2 = Stream.generate(() -> {
            Random random = new Random();
            return random.nextInt(100);
        }).limit(10);
        stream2.forEach(i -> System.out.print(i + " "));
        System.out.println();

        //IntStream Random.ints(int begin, int end)
        IntStream stream3 = new Random().ints(0, 100).limit(15);
        stream3.forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Stream<T> Stream.ierate(T identity, UnaryOperator<T>)
        Stream<Integer> stream4 = Stream.iterate(1, i -> i * 2).limit(10);
        stream4.forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Builder<Object> Stream.builder()
        Stream.Builder<Object> builder = Stream.builder()
            .add("いちじく")
            .add("にんじん")
            .add("さんしょう");
        builder.build().forEach(System.out::println);

        //Stream<T> Stream.concat(Stream<T>, Stream<T>)
        Stream<String> stream5 = Stream.of("いちじく","にんじん","さんしょう");
        Stream<String> stream6 = Stream.of("しいたけ","ごぼう","れんこん");
        Stream<String> conStream = Stream.concat(stream5, stream6);
        conStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //concat()を違う型のStreamで使ったらどうなるか
        Stream<Integer> streamInt = IntStream.range(1, 10).boxed();
        Stream<String> streamStr = Stream.of("バラ","さくら","あさがお");
        Stream<Object> conStreamIntStr = Stream.concat(streamInt, streamStr);
        conStreamIntStr.forEach(s -> System.out.print(s + " "));

        //型の不一致: Stream<Object & Serializable & Comparable<?>> から
        //Stream<String> には変換できません
        //Stream<Object>にすると解決。
    }//main()
}//class

/*
//====== Result ======
//---- of() ----
first
second
third

//---- generate() ----
31 15 82 87 2 91 20 93 38 26

//---- Random.ints() ----
54 90 91 87 23 57 54 66 93 44 83 61 83 16 11

//---- iterate() ----
1 2 4 8 16 32 64 128 256 512

//---- builder() ----
いちじく
にんじん
さんしょう

//---- concat() ----
いちじく にんじん さんしょう しいたけ ごぼう れんこん

//---- concat(Stream<Integer>, Stream<String>) ----
1 2 3 4 5 6 7 8 9 バラ さくら あさがお

//---- おまけ ----
一度、終端処理をした Streamは、もう使えない
stream.forEach(System.out::print);
    java.lang.IllegalStateException:
    stream has already been operated upon or closed

*/