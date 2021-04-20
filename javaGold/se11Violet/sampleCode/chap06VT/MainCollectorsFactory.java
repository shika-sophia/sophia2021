/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollectorsFactory.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p505 / List 10-47 ～ 10-50
 * @content ◆Collectorsファクトリーメソッド -> 戻値: Collectorオブジェクトを生成
 *          ＊static joining()
 *          戻値: Collector<CharSequence, ?, String>
 *          引数: joining([CharSequence delimiter, //区切り文字
 *                        [CharSequence prefix,    //連結時の接頭辞
 *                         CharSequence suffix]] ) //連結時の接尾辞
 *
 *          ＊static groupingBy()
 *          戻値: Collector<T, ?, Map<K, List<T>>
 *          引数: groupingBy(Function<? super T,? extends K>　classifier)
 *
 *          戻値: Collector<T, ?, Map<K,D>>
 *          引数: groupingBy(Function<? super T, ? extends K> classifier,
 *                           Collector<? super T,A,D> downstream )
 *
 *          T: 入力要素の型(Streamの要素型)
 *          K: グループ化の key
 *          A: 引数 downstreamでの中間型
 *          D: 引数 downstreamでの結果型
 *          classifier: キーによって値を分類するための式
 *          downstream: グループ化後の処理を表すコレクター
 *
 *          ＊static partitioningBy()
 *          戻値: Collector<T, ?, Map<Boolean, List<T>>
 *          引数: partitioningBy(Predicate<? super T>)
 *
 * @author shika
 * @date 2021-04-20
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollectorsFactory {

    public static void main(String[] args) {
        List<String> data =
            Stream.of("バラ","さくら","チューリップ","あさがお","ゆり")
            .collect(Collectors.toList());

        //---- joining() ----
        System.out.println(
            data.stream()
                .sorted()
                .collect(Collectors.joining(",", "<", ">"))
        );

        //---- groupingBy(Function<T,K>) ----
        data.set(data.indexOf("チューリップ"), "さざんか");
        data.add("うめ");
        System.out.println("data: " + data);

        System.out.println(
            data.stream()
                .sorted()
                .collect(
                    Collectors.groupingBy(str -> str.length())
                )
        );

      //---- groupingBy(Function<T,K>, Collector<T,?,Map<K,D>) ----
        System.out.println(
            data.stream()
                .sorted()
                .collect(
                    Collectors.groupingBy(
                        str -> str.length(),
                        Collectors.joining("/")
                    )
                )
        );

      //---- partitioningBy(Predicate<? super T>) ----
        System.out.println(
            data.stream()
                .sorted()
                .collect(
                    Collectors.partitioningBy(
                        str -> str.length() > 3)
                )
        );
    }//main()

}//class

/*
//---- joining() ----
[バラ, さくら, チューリップ, あさがお, ゆり]
<あさがお,さくら,ゆり,チューリップ,バラ>

//---- groupingBy(Function<T,K>) ----
data: [バラ, さくら, さざんか, あさがお, ゆり, うめ]
{2=[うめ, ゆり, バラ], 3=[さくら], 4=[あさがお, さざんか]}

//---- groupingBy(Function<T,K>, Collector<T,?,Map<K,D>) ----
{2=うめ/ゆり/バラ, 3=さくら, 4=あさがお/さざんか}

//---- partitioningBy(Predicate<? super T>) ----
{false=[うめ, さくら, ゆり, バラ], true=[あさがお, さざんか]}

*/