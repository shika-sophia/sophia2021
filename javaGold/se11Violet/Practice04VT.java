/**
 * @title javaGold / se11Violet / Practice04VT.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content [ 第４章 Collection / Generics]
 * @author shika
 * @date 2021-04-03
 */
/* Appendix 2021-04-03
 * @costTime 10:05 - 10:31 ( 25 分)
 * @correctRate 正答率 33.33 ％ ( 〇5問 / 全15問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice04VT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-03 ======
 第４章 Collection / Generics
〇 （1） D
〇 （2） C
Ｘ （3） F -> E
  => List<Object> を Stringで受けているのでコンパイルエラー。
  => for (Object obj : list)なら警告は出るがコンパイルは通る。

〇 （4） A, D
    => Queue.remove()は引数を持たない
    => remove(1)は Listならindexと解釈。
    Queueなら Collection.remove(1)と解釈され、1のオブジェクト削除の意。
    Queue.remove(1) -> falseで 何も変化なし。

Ｘ （5） A, B
    => ② に next (ケアレスミス)
    分かっているとこ取らんと本当に落ちるよ。気を付けよう。

〇 （6） A, D
〇 （7） B
    => SortedXxxx.ceiling(): その値を含み、より大きくて最小のもの
Ｘ （8） D -> C
    => Map.get(T key): キーから値を取得。
    get(4)で 4に当たるキーが存在しないため、null

Ｘ （9） E -> C
    => Map.contain()は未定義
    => Map.containsKey(), containsValue()を用いる。

Ｘ （10） B -> E
    => F<T>に対し new F<>()だと、警告はでるがコンパイルは通る。

Ｘ （11） A, C -> A, E
    => RuntimeException は Exceptionのサブクラス
    => Map<String, ? extends Number> map = new Map<String, Integer>();
        という書き方が可能。
    =>「<?>」ワイルドカードは、変数宣言側(左辺)のみ可。
    => <>内のクラスに継承関係があっても代入不可。

Ｘ （12） D, E -> B, C
    => foo(List<?> list)に対し、ArrayListを引数にすること可。
    => List<?> list = new ArrayList<?>();は インスタンス側(右辺)に<?>を用いるとコンパイルエラー。

Ｘ （13） A, D, F -> B, D, F
    => java.lang.Comparable / java.util.Comparator

Ｘ （14） B -> A
    => 自然順序: 数字は文字列の前

Ｘ （15） E
    => TreeSet(Comparator)というコストラクタに
         new TreeSet(t1); というインスタンス。
         t1 = Test("apple", 30);は implements Comparatorのため、
         その Comparatorのみ注目されコンパイルは通る。
         Testオブジェクトは無視され、TreeSetの要素とはならない。
         その後、 tree.add(t1); tree.add(t2)ではじめて TreeSetに要素が入る。

     => new TreeSet<>()は自然順序でソート。その際 compareTo()を比較に用いる。
         TreeSetの要素の Test.compareTo()で行う。

開始時刻 10:05
終了時刻 10:31
所要時間 25 分
正答率 33.33 ％ ( 〇5問 / 全15問 )
*/

