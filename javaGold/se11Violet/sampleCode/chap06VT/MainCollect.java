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
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

public class MainCollect {

    public static void main(String[] args) {

    }//main()

}//class
