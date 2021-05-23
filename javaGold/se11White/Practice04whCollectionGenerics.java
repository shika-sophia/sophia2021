/**
 * @title javaGold / se11White / Practice04whCollectionGenerics.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 collection / Generics
 * @author shika
 * @date 2021-04-02
 */
/* Appendix 2021-04-02
 * @costTime 17:03 - 17:39 ( 35 分)
 * @correctRate 正答率 65.00 ％ ( 〇13問 / 全20問 )
 */
/* Appendix 2021-05-05
 * @costTime 10:49 - 11:26 ( 36 分)
 * @correctRate 正答率 90.00 ％ ( 〇18問 / 全20問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice04whCollectionGenerics {

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
    => Queue.push()は addFirst()

〇 （7） B
    => Set.add()で重複要素は格納されない falseが返ってコンパイルは通る。
    => Set.remove()で消去対象の要素がなくても falseが返り何も起きない。コンパイルも通る。

〇 （8） E TreeSet implement Navigable, Comparable / Navigable extends SortSet
    => SortedSet<E>.subSet(E from, E to) from以上 to未満の Setを返す。
    => 引数４つ subSet(from, boolean, to, boolean) booleanはその数を含むか。defaultで true, false

〇 （9） A
    => Map.重複キーは値を上書き

〇 （10） B
    => TreeMapは キーで sort
    => TreeMap.put(null, )は不可。ソートの際 Comparableにキャスト

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
    => java.lang.Comparable<T> this.compareTo(T)
    => java.util.Comparator<T> compare(T, T)

〇 （17） B
    => Collections.binarySearch(List, T):
    *    List内に 要素が存在すれば ingexを返す
    *    事前に自然順序に sort()いておかないと、正しい結果を保証できない。

〇 （18） B
Ｘ （19） C -> E
    int check = empNo.compareTo(emp.empNo);
    if(check != 0){
        return check;
    } else {
        check = empName.compareTo(emp.empName);
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

/*
//====== 2021-05-05 ======
 Collection, Generics [２回目]
〇 （1） C
    => Foo<T> こんなインスタンス生成がある
       Foo<Integer> foo = new Foo<>();
       Foo foo2 = new Foo(); -> Foo<Object>になる

〇 （2） A, B, E
    => インスタンス生成時、右辺に<?>ワイルドカードは不可。

Ｘ （3） B, D -> A, B, D
    <? super BBB>, <? extends BBB>は両方とも BBBを格納可。

〇 （4） D
〇 （5） A
    => List<Object> に String型の"789"
    (Integer) list.get(i);で ClassCastException
    コンパイルは通る。

〇 （6） D
    => Collections.sort(), Collections.reverse()は
        元のlinkに代入しなおさなくても、要素の順番を入れ替えている。

〇 （7） B
    => Setの重複は無視、add()が falseを返し何も起こらない。
    コンパイルエラーも起こらない。
    remove(T)の引数にあたる要素がなくても同様。

〇 （8） E
〇 （9） A
〇 （10） B
Ｘ （11） C -> D
    => Map.of()は不変オブジェクト
    => Map.put(), set(), remove()は不可
    => putIfAbsent()は条件によって実際に変更しなくても、
    不変オブジェクトには不可。実行時の UnsupportedOperationException

    putIfPresent()は存在しない。
    keyが重複するなら 値が上書きされる put()と同様。

〇 （12） D
〇 （13） A
〇 （14） D
〇 （15） E
〇 （16） A, C
〇 （17） B
    => int Collections.binarySearch(Collection, Object)
    引数オブジェクトの indexを返す

〇 （18） B
〇 （19） E
〇 （20） A, B, D

開始時刻 10:49
終了時刻 11:26
所要時間 36 分
正答率 90.00 ％ ( 〇18問 / 全20問 )
*/

