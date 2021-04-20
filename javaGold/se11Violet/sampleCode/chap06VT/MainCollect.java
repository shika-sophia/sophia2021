/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollect.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p501 / List 10-44, 10-45, 10-46
 * @content ◆Stream.collect()
 *          R collect(Collector<? super T, A, R>)
 *          	T:入力要素型, A:コレクターが蓄積する型, R:コレクターの結果型
 *
 *          R collect(Supplier<R> supplier,                 //可変コンテナの生成
 *                    BiConsumer<R, ? super T> accumulator, //コンテナに値を渡す式
 *                    BiConsumer<R, R> combiner)            //(並行処理時)コンテナを結合
 *              T:Streamの要素型, R:可変コンテナの型
 *
 *          ◆static Collector.of()
 *          ＊戻値: Collector<T,R,R>
 *              of(Supplier<R> supplier,        //可変コンテナを生成
 *                 BiConsumer<R,T> accumulator, //コンテナに値を渡す式
 *                 BinaryOperator<R> combniner, //(並行処理時)コンテナを結合
 *                 Collector.Characteristics...)//コレクタの特性を表す列挙型定数
 *              T:Stremの型, A:コレクタが蓄積する型, R:コレクタの結果型
 *
 *          ＊戻値: Collector<T,A,R>
 *              of(Supplier<A> supplier,
 *                 BiConsumer<A,T> accumulator,
 *                 BinaryOperator<A> combniner,
 *                 Function<A,T> finisher       //最終的な結果の変換に用いる式
 *                 Collector.Characteristics...)
 *              T:Stremの型, A:コレクタが蓄積する型, R:コレクタの結果型
 * @author shika
 * @date 2021-04-20
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {

    public static void main(String[] args) {
        //---- Stream.collect() ----
        //R collect(Collector<? super T, A, R>)
        List<String> data =
            Stream.of("バラ","さくら","チューリップ","あさがお","ゆり")
            .collect(Collectors.toList());
        System.out.println(data);

//    	R collect(Supplier<R> supplier,     //可変コンテナの生成
//    			  BiConsumer<R, ? super T>  //コンテナに値を渡す式
//    			  BiConsumer<R, R> combiner)//(並行処理時)コンテナを結合
//    		T:Streamの要素型, R:可変コンテナの型
        System.out.println(
            data.stream()
                .sorted()
                .collect(
                    ArrayList<String>::new,
                    (list,str) -> list.add(str),
                    (list1,list2) -> list1.addAll(list2)
                )
        );

        //---- Collector.of() ----
        System.out.println(
            data.stream()
                .sorted()
                .collect(Collector.of(
                    ArrayList<String>::new,
                    ArrayList::add,
                    (list1, list2) -> {
                        list1.addAll(list2);
                        return list1;
                    },
                    Collector.Characteristics.IDENTITY_FINISH
                ))
        );

        System.out.println(Arrays.toString(
            data.stream()
                .sorted((str1,str2) -> str1.length() - str2.length())
                .collect(Collector.of(
                    ArrayList<String>::new,
                    ArrayList::add,
                    (list1, list2) -> {
                        list1.addAll(list2);
                        return list1;
                    },
                    list -> list.toArray() //finisher
                ))
            ));
    }//main()

}//class

/*
//---- Stream.collect() ----
[バラ, さくら, チューリップ, あさがお, ゆり]
[あさがお, さくら, ゆり, チューリップ, バラ]

＊メソッド参照でも可
    colect(
        ArrayList<String>::new, //supplier
        ArrayList::add,         //accumulator
        ArrayList::addAll       //combiner
    )

//---- Collector.of() ----
[あさがお, さくら, ゆり, チューリップ, バラ]
[バラ, ゆり, さくら, あさがお, チューリップ]

＊この部分
    (list1, list2) -> {
        list1.addAll(list2);
        return list1;
    },

ArrayList::addAll や
(list1, list2) -> list1.addAll(list2),だと 型の不一致で
うまくいきません。上記の形でないとダメです。

collect()を そのまま Collector.of()のにできるわけではないみたい。
of()を使うメリットは finisherと Characteristicsを記述できることぐらい。
複雑すぎて使う機会は ほぼなさそう。
*/