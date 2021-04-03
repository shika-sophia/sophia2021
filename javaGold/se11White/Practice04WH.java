/**
 * @title javaGold / se11White / Practice04WH.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 collection / Generics
 * @author shika
 * @date 2021-04-02
 */
/* Appendix 2021-04-02
 * @costTime 17:03 - 17:39 ( 35 分)
 * @correctRate 正答率 65.00 ％ ( 〇13問 / 全20問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice04WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-02 ======
 第４章 collection / Generics
〇 （1） C
Ｘ （2） B, D, E -> A, B, E
    => <? super BBB> には BBB, superの AAA, Objectが可。

〇 （3） A, D
〇 （4） D
    => ダイアモンド演算子「<>」は右辺の省略のみ可。

〇 （5） A
Ｘ （6） C -> D
    => push()は addFirst()
〇 （7） B
    => Set.add()で重複要素は格納されない falseが返ってコンパイルは通る。
    => Set.remove()で消去対象の要素がなくても falseが返り何も起きない。コンパイルも通る。

〇 （8） E TreeSet implement Navigable, Cmparable / Navigable extends SortSet
    => SortedSet<E>.subSet(E from, E to) from以上 to未満の Setを返す。
    => 引数４つ subSet(from, boolean, to, boolean) booleanはその数を含むか。defaultで true, false

〇 （9） A
    => 重複キーは値を上書き

〇 （10） B
    => TreeMapは キーで sort
    => Map.add(null)は不可。

Ｘ （11） A -> D
    => Map.of() 不変Mapを生成。
    put(), set(), remove()は実行時 UnsuppotedOperationException
    putIfAbsent()は キーが存在しなければ値を追加。
    キーが存在して追加しなくても不変Mapは上記の例外が出る。

〇 （12） D
    => ◆Stackクラスのメソッド  LIFO => Deque
        push() => addFirst()
        pop()  => removeFirst()
        peek() => peekFirst()

    => ◆Queueインターフェイスのメソッド FIFO => Deque
        add() => addLast()
        offer() => offerLast() 失敗時 false
        poll() => pollFirst() 末尾から要素を削除。存在しないとき null
        remove() => removeFirst() 末尾から要素を削除。存在しないとき 例外 NotSuchElementException
        element() => getFirst() 先頭検査で取り出す。削除しない。存在しないとき 例外。
        peek() => peekFirst() 先頭検査で取り出す。削除しない。存在しないとき null。

Ｘ （13） D -> A
    => offer()で要素追加 => offerLast(),
    => remove()で取得削除 => removeFirst()

Ｘ （14） F -> D
    => addFirst()で先頭に要素追加
    => pollLast()で末尾から取得削除

〇 （15） E
    => Queue.add(1) => Deque.addLast() 1
    => Queue.offer(2) => Deque.offerLast() 1, 2
    => Stack.push(3) => Deque.offerFirst() 3, 1, 2

    ※DJは push() => addFirst()となっているが、Stackも Dequeも 要素数制限ができないらしく
    push()で例外の出るケースを実験できなかった。(= いつも成功)
    Queueで push()は未定義なので使えない。

〇 （16） A, C
    => Comparable<T> compareTo(T)
    => Comparator<T> compare(T, T)
〇 （17） B
    => Collections.binarySearch(List, T): List内に 要素が存在すれば ingexを返す
〇 （18） B
Ｘ （19） C -> E
    int check = empNo.compareTo(emp.empNo);
    if(check != 0){
        return check;
    } else {
        check = empName.compareTO(emp.empName);
    }
    => フィールドの empNoと 引数の empNoを比較して違うならその順。
        empNoが同じなら名前で比較した自然順序。
Ｘ （20） A, C, D -> A, B, D
    => 「コンパイルが通る」であって、結果に値を出すことは求めていない。
        文法上で正しいものを選択すればよい。
            ◆static Arrays.asList(T... a) -> 戻り値 List<T>
        Arrays.asList(list);
        Arrays.asList(new Integer[3]);
        Arrays.asList(1001, 1002, 1003);

    => { }を使って配列の初期化式のみを引数内に記述するとコンパイルエラー
    newと伴に用いるならＯＫ。
開始時刻 17:03
終了時刻 17:39
所要時間 35 分
正答率 65.00 ％ ( 〇13問 / 全20問 )
*/

