/**
 * @title javaGold / selfLearn / DJchap06Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / 練習問題, 章末問題
 * @author shika
 * @date 2021-02-24
 */
/* Appendix
 * @costTime 09:23 - 09:40 ( 16 分)
 * @correctRate 正答率 85.71 ％ ( 〇12問 / 全14問 )
 */
/* Appendix
 * @costTime 11:07 - 11:24 ( 16 分)
 * @correctRate 正答率 92.86 ％ ( 〇13問 / 全14問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap06Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-02-24 ======
 Collection / 練習問題 6.1
〇 （1） ジェネリクス: <～>の形でオブジェクトの型を扱う仕組み。
    Object[]に見られる ClassCastExceptionを防止し、
    Collectionに型安全 type-safeを提供する。

〔別紙で検証〕 -> DJchap06List / あちこち間違っていたので修正
〇 （2） List<Integer> list1 = new ArrayList<>(Arrays.asList(16, 24, 30 39);
〇 （3） List<Integer> list2 = List.of(16, 24, 30, 39); 不変リスト
〇 （4） List<Integer> list3 = IntStream.of(16, 24, 30, 39).boxed().collect(toList());

 練習問題 6.2
〇 （1） <Integer>
Ｘ （2） add => remove
    加工後の結果から 0の値は入っていない。
    最初の要素が削除されていることから remove(0)

〇 （3） 20
Ｘ （4） list => 2
    list.addAll(2, list2); listのindex 2から list2を追加
〇 （5） i

 練習問題 6.3
〇 （1） List, Setの違いは、Setは値の重複を許さず、要素順がないこと。
〇 （2） HashMap 要素順がなく、Setとして集合演算に向く。
〇 （3） TreeSet 要素を自然順序でソートした状態で保持。
〇 （4） LinkedHashSet 要素順(add順)を考慮したSet
〇 （5） SynchronizedSet, SynchronizedSortedSet スレッドセーフな Set

開始時刻 09:23
終了時刻 09:40
所要時間 16 分
正答率 85.71 ％ ( 〇12問 / 全14問 )
*/
/*
//====== 2021-02-24 ======
 章末問題
〇 （1） ArrayListの挿入・削除は位置に関わらず一定速度。Ｘ -> 先頭に近いほど低速。
〇 （2） LinkedListの挿入・削除は比較的低速。Ｘ -> ArrayListより速い。
〇 （3） HashSetは要素の重複を許さず、一定の順序で保持。Ｘ -> 順序は維持されない
〇 （4） HashMapはkey,valueのペア。順序は保証されない。〇
Ｘ （5） Stack: FIFO, Queue: LIFO。〇
    => Stack: LIFO or FILO (車の運搬トレーラー)
       Queue: FIFO (待ち行列)

〇 （6） [2]① <String,String>
〇 （7） ② "carrot","ニンジン"
〇 （8） ③ remove
〇 （9） ④ replace
〇 （10） ⑤ entry.getKey()
〇 （11） ⑥ rntry.getValue()
〇 （12） [3]<Integer>が抜けている
〇 （13） remove(5) -> IndexOutOfBoundsExecption, indexは 0から始まる。
〇 （14） for(String i : list) 型パラメタ無指定なので Object i が正しい。

開始時刻 11:07
終了時刻 11:24
所要時間 16 分
正答率 92.86 ％ ( 〇13問 / 全14問 )
*/

