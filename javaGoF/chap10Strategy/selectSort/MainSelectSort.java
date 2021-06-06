/**
 * @title javaGoF / chap10Strategy / selectSort / MainSelectSort.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第10章 Strategy / 練習問題 10-1, 10-4, A10-3, A10-4
 * @content sort()のソート仕様の切り替えを Strategyで実現。
 *
 * @class MainSelectSort / ◆main()
 * @class SortedPrint<T>
 *          / Comarable<T>[] data, ISorter<T> sorter
 *          / SortedPrint<T>(Comarable<T>[] data, ISorter<T> sorter),
 *            execute(), print()
 * @interface ISorter<T> / abstract sort()
 * @class NaturalSorter<T> implements ISorter<T>
 *          / sort(Comparable<T>) 自然順序で配列を入れ替え
 * @class LengthSorter<T> implements ISorter<T>
 *          / sort(Comparable<T>) Stringの文字列長でソート
 * @class QuickSorter<T> implements ISorter<T>
 *          / sort(), quickSort() 中央値で分割して前後でソート
 *
 * @author shika
 * @date 2021-06-06
 */
package javaGoF.chap10Strategy.selectSort;

public class MainSelectSort {

    public static void main(String[] args) {
        String[] data = {
            "Dumpty","Bob","Carrolline","Elfland","Alice"
        };

        System.out.println("---- NaturalSorter ----");
        var printer = new SortedPrint<String>(
                data, new NaturalSorter<String>());
        printer.execute();

        System.out.println("---- LengthSorter ----");
        var printer2 = new SortedPrint<String>(
                data, new LengthSorter<String>());
        printer2.execute();

        System.out.println("---- QuickSorter ----");
        var printer3 = new SortedPrint<String>(
                data, new QuickSorter<String>());
        printer3.execute();
    }//main()

}//class

/*
---- NaturalSorter ----
Dumpty, Bob, Carrolline, Elfland, Alice,
Alice, Bob, Carrolline, Dumpty, Elfland,

---- LengthSorter ----
Alice, Bob, Carrolline, Dumpty, Elfland,
Bob, Alice, Dumpty, Elfland, Carrolline,

---- QuickSorter ----
Bob, Alice, Dumpty, Elfland, Carrolline,
Alice, Bob, Carrolline, Dumpty, Elfland,

【考察】 NaturalSorter, LengthSorter
for文で配列入替を作ってみた。
おそらく、Arrays.sort()/Collection.sort()の中身もこうなっているのかも。

やっていることは for i で (data.length-1)まで全ての配列を調べる
int minで最小値の indexを保持。
for j で data[i] と　次の要素 data[i + 1]を比較
Comparable.compareTo(T)
  A.compareTo(B) A > B なら 1, A == Bなら 0, A < Bなら -1
A < B || A == B なら  順番そのまま。
A > B のときだけ、最小 index を jとし、(jは i + 1で iの次の要素)

入れ替え処理
Comparable<T> tempは、２つのものを入れ替えるとき、
仮に３つめに値をいれておく必要があるので作る。
temp = data[min];

data[min] = data[i]; 最小indexに data[i]を代入
data[i] = temp; data[i]に元の data[min]の値を代入。
先ほどの j検査で、indexに変更がなければ、min = iのまま。要素順に変更なし
j検査で data[i]より、data[i+1]の値が小さければ
min = j = i + 1になっており、上記の入れ替え処理で要素順が変わる。

んで、for iに戻って i++でも検査。

【考察】 QuickSorter / クイックソート・アルゴリズム
解答 A10-3, A10-4
やっていることは、配列 dataの中央値を取得 midに代入。
先頭からmid、midから最後で それぞれソート。
元の先頭と元の最終要素の indexが順になっていなければ
その範囲だけもう一回 quickSort()する。

while文３つをシングルスレッドで順にソートするので、
中央値で分ける意味はあるだろうか。
それに部分的に もう一度 quickSort()をするケースもあるため
どう考えても Quick(= 速い)とは思えぬ。

マルチスレッドや parallel()で行うなら、あるいは速いかも。
クイックソート・アルゴリズムの考え方は面白いと思う。
Stream.parallel()で行う 細分化アルゴリズムの元になる考え方を
whileと配列で実現した感じ。
でも、実用的ではなさそう。

*/

