/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollectingSndThen.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p508 / List 10-51
 * @content ◆Collectorsファクトリーメソッド -> 戻値: Collectorオブジェクトを生成
 *          ＊static collectionAndThen()
 *          戻値: Collector<T, A, RR>
 *          引数: collectingAndThen(
 *                    Collector<T,A,R> downstream,
 *                    Function<R,RR> finisher )
 *          T: 入力要素の型(Streamの要素型)
 *          A: コレクタ downstreamが蓄積する型
 *          R: コレクタ downstreamの結果型
 *          RR: finisherの結果型(= メソッド全体の結果型)
 *          downstream: コレクタ
 *          finisher: downstreamの結果を受けて実行する処理
 *
 * @author shika
 * @date 2021-04-20
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollectingAndThen {

    public static void main(String[] args) {
        List<String> list =
            Stream.of("バラ","さくら","チューリップ","あさがお","ゆり")
            .sorted()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    Collections::unmodifiableList
                )
            );

        System.out.println("list: " + list);

    }//main()

}//class

/*
list: [あさがお, さくら, ゆり, チューリップ, バラ]

list.add("さざんか");
    java.lang.UnsupportedOperationException

*/