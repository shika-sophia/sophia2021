/**
 * @title javaGold / se08Black / Practice02bkCollection.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第２章 Collection, Generics
 * @author shika
 * @date 2021-05-03
 */
/* Appendix 2021-05-03
 * @costTime 09:52 - 10:15 ( 22 分)
 * @correctRate 正答率 66.67 ％ ( 〇16問 / 全24問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice02bkCollection {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-03 ======
 第２章 Collection, Generics
〇 （1） A
    => Generics: 総称的な、包括的な
    => 総称型ではない型を raw type 原型という。
    => C++のテンプレート

〇 （2） E
     => ◆アスペクト指向プログラム: [JavaEE]
         さまざまなクラス間に散在する共通処理を分離してコンポーネント化し
         アプリケーションのロジックと分けて管理・適用するためのプログラミング・パラダイム

     => ◆O/R Mapping: [JavaEE]
         オブジェクト指向と RDBMS(=リレーショナルDB）を結び付けるテクノロジー

     => ◆関数型プログラミング:
         関数を中心とした宣言型のコーデイングを特徴とするプログラミング・パラダイム

    => ◆ JDBC (Java Database Connectivity):
        Javaと DB繋ぐためのライブラリ .jarファイル。各DB製品ごとの違いを吸収し、
        統一された Javaコマンドで DBへの接続や操作が可能。

〇 （3） D
Ｘ （4） C, F -> C, E
    => F: Foo<String> foo = new Foo<> { };
    匿名クラスでは <>による省略不可。 Foo<String> { } とする。

Ｘ （5） F, G -> A, G
    => ◆Genericsクラスの禁忌
             ・static 型変数
             ・型変数によるインスタンス生成
             ・型変数を要素とする配列の生成
             ・instanceof演算子による型の判定
             ・型変数に対する .classの参照

    => フィールド、ローカル変数、仮引数、戻り値はＯＫ。

〇 （6） A
    => Genericsメソッドは、戻り値のまえに <T>などを宣言。

〇 （7） C
    => super X <- sub Y, Z の継承関係があり、
    Foo<T, U extends T>のジェネリックで定義した場合
    Foo<X, Y>, Foo<X, Z> はＯＫ。
    Foo<Y, X>, Foo<Z, X> はコンパイルエラー。

〇 （8） A, B, D
    => ワイルドカード「?」 <?>, <? extends T>, <? super T>
        型変数 class Foo<?> 不可
        インスタンス生成時不可 Foo<?> foo = new Foo<?>
        型引数においてのみワイルドカード利用可。

Ｘ （9） D -> A
    => 総称型を継承/実装する場合、型引数を指定しないとコンパイルエラー。
        型変数Tのまま利用できない。

    A: class Bar exends Foo<T> 上記により誤り
    B: class Bar<T> extends Foo<T>
        Foo<T>の Tは Bar<T>においてパラメタ化された Tなので問題ない。？

    C: class Bar extends Foo<String>
    D: class Bar extends Foo<Inteder>
        Foo<>の型は決まり、Barはそれを継承する非ジェネリックなクラスなのでＯＫ。

〇 （10） C
    => List<E> List.subList(int from, int to) リストの一部をリスト化
〇 （11） A, D
〇 （12） C
    => ◆Arrays.asList(): 基本型要素からラッパークラスへの変換
        List<Double> list = Arrays.asList(1.5, 3.2, 2.4);
        List<Boolean> list = Arrays.asList(true, false, true);

    => ◆Arrays.asList()で生成する ArrayListは
    Arraysクラス内部で生成する private staticな ArrayListインスタンス。
    Collectionフレームワークの java.util.ArrayListと互換性がない
        X ArrayList<Integer> list = Arrays.asList(1, 2, 3); //コンパイルエラー
        X ArrayList<Integer> list = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
            -> ClassCastException

Ｘ （13） F -> C
    => Arrays.asList()で生成した Listは配列のList化のため要素数を増やせない。(不変Listではない)
        set(0, 2);はＯＫ。
    => new ArrayList<>(Arrays.asList())は
        ArrayListのコンストラクタに要素を入れた ArrayListを生成。
        -> add()も可。

Ｘ （14） C -> D
    => Queue FIFO 最初に格納した要素を最初に取り出す = 待ち行列
〇 （15） B
Ｘ （16） B, D -> A, C
    => ArrayDeque<E>は FIFO キューとして利用する場合は LinkedListより高速
        FILO スタックとして利用する場合は、Stack<E>よりも高速

    => ArrayDeque<E>はスレッドセーフではない
        Stack<E>はスレッドセーフなクラス

    => ArrayDeque<E>に nullは格納不可。

〇 （17） C
〇 （18） B, C
〇 （19） B
〇 （20） A, C
〇 （21） C
〇 （22） C, E
Ｘ （23） D
Ｘ （24） A

開始時刻 09:52
終了時刻 10:15
所要時間 22 分
正答率 66.67 ％ ( 〇16問 / 全24問 )
*/

