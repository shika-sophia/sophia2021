/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollectorsFactory.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI / p252 / List 6-24, 6-25
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
 *          戻値: Collector<T, ?, M>
 *          引数: groupingBy(Function<? super T, ? extends K> classifier,
 *                           Supplier<M> mapFactory
 *                           Collector<? super T,A,D> downstream )
 *
 *          T: 入力要素の型(Streamの要素型)
 *          K: グループ化の key
 *          A: 引数 downstreamでの中間型
 *          D: 引数 downstreamでの結果型
 *          M: 引数 mapFactoryの要素型
 *          classifier: キーによって値を分類するための式
 *          downstream: グループ化後の処理を表すコレクター
 *          mapFactory: 結果用のMapを生成
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
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollectorsFactory {

    public static void main(String[] args) {
        List<String> data =
            Stream.of("バラ","さくら","チューリップ","あさがお","ゆり")
            .collect(Collectors.toList());

        //---- joining() ----
        String joined =
            data.stream()
                .sorted()
                .collect(Collectors.joining(",", "<", ">"));
        System.out.println(joined);

        //---- groupingBy(Function<T,K>) ----
        data.set(data.indexOf("チューリップ"), "さざんか");
        data.add("うめ");
        System.out.println("data: " + data);

        Map<Integer,List<String>> groupMap1 =
            data.stream()
                .sorted()
                .collect(
                    Collectors.groupingBy(str -> str.length())
                );
        System.out.println(groupMap1);

      //---- groupingBy(Function<T,K>, Collector<T,?,Map<K,D>) ----
        Map<Integer,String> groupMap2 =
            data.stream()
                .sorted()
                .collect(
                    Collectors.groupingBy(
                        str -> str.length(),
                        Collectors.joining("/")
                    )
                );
        System.out.println(groupMap2);

      //---- partitioningBy(Predicate<? super T>) ----
        Map<Boolean, List<String>> mapBoolean =
            data.stream()
                .sorted()
                .collect(
                    Collectors.partitioningBy(
                        str -> str.length() > 3)
                );
            System.out.println(mapBoolean);

        //====== YM: List 6-24, 6-25 ======
        //---- groupingBy(Function<T,K>) ----
        List<String> data2 =
            Stream.of("bobby","akiko","ami","belle","nao")
            .collect(Collectors.toList());

        Map<String, List<String>> groupMap3 =
            data2.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println(groupMap3);

      //---- groupingBy(Function<T,K>, Collector<T,?,Map<K,D>) ----
        Map<String,Set<String>> groupMap4 =
            data2.stream()
                .collect(
                    Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        Collectors.toSet())
                );
        System.out.println(groupMap4);

        Map<String,String> groupMap5 =
            data2.stream()
                .collect(
                    Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        Collectors.joining("/"))
                );
        System.out.print(groupMap5.getClass().getSimpleName());
        System.out.println(groupMap5);

        Map<String,String> groupMap6 =
            data2.stream()
                .collect(
                    Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        TreeMap::new,
                        Collectors.joining("/"))
                );
        System.out.print(groupMap6.getClass().getSimpleName());
        System.out.println(groupMap6);
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

//---- YM: List 6-24, 6-25 ----
{a=[akiko, ami], b=[bobby, belle], n=[nao]}
HashMap{a=akiko/ami, b=bobby/belle, n=nao}
TreeMap{a=akiko/ami, b=bobby/belle, n=nao}
*/