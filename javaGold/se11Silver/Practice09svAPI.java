/**
 * @title javaGold / se11Silver / Practice09svAPI.java
 * @reference 志賀澄人 『徹底攻略 Java SE11 Silver 問題集[1ZO-815]』 インプレス, 2019
 * @content  第９章 API
 * @author shika
 * @date 2021-05-15
 */
/* Appendix 2021-05-15
 * @costTime 21:37 - 21:57 ( 20 分)
 * @correctRate 正答率 57.89 ％ ( 〇11問 / 全19問 )
 */
package javaGold.se11Silver;

import javaGold.PracticeEditor;

public class Practice09svAPI {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-15 ======
 第９章 API
〇 （1） A
     => ◆ java.lang.Math
     *  double Math.pow(double a, double b) a ^ b aのb乗。
     *  double Math.sqrt(double) 引数の平方根

Ｘ （2） A -> C
       => int Comparable.compareTo(T)
       => int Comparator.compare(T, T)
       *      第１引数を前にするなら -1 入れ替えはしない
       *      第２引数を前にするなら 1
       *      並び順を変更しないなら 0

〇 （3） D
〇 （4） B
     => ◆Characterクラス
     *   static boolean Character.isAlphabetic(char) アルファベットであるか
     *   static boolean Character.isDesit(char) 数字であるか
     *   static boolean Character.isLowerCase(char) 小文字であるか
     *   ※Unicodeはアルファベットの小文字だけを小文字とするのではない。

〇 （5） E
Ｘ （6） C -> D
   => ◆LocalDateTime
   *  immutable: 不変オブジェクト
   *  ◆Immutableの特徴
   *     ＊そのオブジェクトが変更されたかを確かめる必要がない
   *     ＊スレッドセーフ
   *     ＊データの複製を考える必要がない
   *     ＊複数クライアントによるデータの共有が可能
   *
   *  Temporal　Temporal.with(TemporalAdjuster)
   *  LocalDateTime.with(DayOfWeek.MONDAY);
   *     その週の中の月曜日に変更。ただし immutableオブジェクトのため、
   *     前のオブジェクトはそのままで、新しいオブジェクトが生成される。
   *
〇 （7） B, D, E
    => ◆ 配列
    *    ＊共変: 同じ型、もしくは互換性のある型を扱える。
    *    ＊扱う要素数を最初に決めなければいけない。
    *    ＊要素のアクセスには添え字(index)を使わなければいけない。
    *    ＊要素を扱う際は、要素数を超えないよう配慮しなければいけない。
    *
    => ◆ ArrayList
    *    ＊オブジェクトであれば どのような型でも扱える。
    *    ＊必要に応じて要素数を自動的に増やす。
    *    ＊追加した順に並ぶ。
    *    ＊nullも値として扱える。
    *    ＊重複した値も追加できる
    *    ＊スレッドセーフではない。
Ｘ （8） G -> F
    => ArrayList list = new ArrayList();は
    *  <Object>型と見なされる。
    *  list.add("A");
    *  list.add(10);
    *  list.add('B');
    *  add()は、String, int-> Integer, char -> Characterとして
    *  Object型の Listに格納可。
    *
    *  for(Object obj : list)
    *  各要素を取り出して、Object型変数 objに格納。
    *  それを表示。コンパイル、実行とも例外は出ない。
    *
    *  String str = (String) list.get(i);
    *  とすると、ClassCastException 〔runtime〕
    *  ジェネリックは型が混在しないようにするために導入された。
    *  Objectから Stringへのダウンキャストによって
    *  指定した型 Object以外の型が混在していることになる。
    *

〇 （9） E
    => add(2, "B");でまだ存在しない indexをしていすると
    *  java.lang.IndexOutOfBoundsException

〇 （10） A
Ｘ （11） C -> B
    => List.remove()は equals()が trueを返すものを同じものとして削除。
    => 削除されるのは、先頭から評価して最初の要素１つだけ。

Ｘ （12） E -> C
    => List.remove()によって、削除された後ろの要素は indexが繰り上がる。
    => for文は削除された位置を覚えており、カーソルは移動していない。
    *  Bの位置に Cが繰り上がり、拡張forは次の要素がある時だけカーソルを移動して取得。
    *  Cが繰り上がったため、次の位置に要素はなく、ここで終了して、
    *  Aのみが表示される。

〇 （13） E
    => for文中に remove()だけなら例外は起こらない。
    *  コレクションを一方で読出し、一方で変更すると
    *  ConcurrentModificationException
    *  シングルスレッド環境でも、forブロックが別でも、この例外が起きる。
    *  変更後に読みだしていなければ、例外起きず。
    *  変更後に読みだすと上記の例外発生。
    *

〇 （14） A, C
    => ◆固定長リスト
    *  List.of()
    *  Arrays.asList()

Ｘ （15） C -> D
    => int Arrays.mismatch(T[], T[])
     *    ２つの配列の要素を順に比較しマッチしない indexがあった時点で
     *    その indexを返す。
     *    全ての要素が一致するとき、-1を返す。
     *    配列の長さが異なる場合、片方に比較できる値が存在しなければ
     *    mismatchとして、そこの indexを返す。
Ｘ （16） E -> C
    => Arrays.compare(T, T)
    *  辞書順で Arrays.compare("B","A");
    *  Bは、Aより後ろなので 1が返る。

〇 （17） B
    => Collection.removeIf(Predicate<T>)
    *  new ArraysList<>(Arrays.asList())
    *  ArraysListのコンストラクタに asList()をいれているので、可変長リスト。
    *
    *  Collectionは mutableのため、対象となるコレクションから要素を直接削除する。
    *  代入していなくても変更が反映される。
    *
〇 （18） A, C
Ｘ （19） E -> B
    => Mapは key,valueともに nullを許容する。
    *  nullを keyにすることも可能。
    *  keyが重複する put()をされると、あとからput()した値に上書き。

開始時刻 21:37
終了時刻 21:57
所要時間 20 分
正答率 57.89 ％ ( 〇11問 / 全19問 )
*/

