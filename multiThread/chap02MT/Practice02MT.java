/**
 * @title multiThread / chap02MT / Practice02MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable 練習問題
 * @author shika
 * @date 2021-02-25
 */
/* Appendix
 * @costTime 15:05 - 15:35 ( 29 分)
 * @correctRate 正答率 88.24 ％ ( 〇15問 / 全17問 )
 */
package multiThread.chap02MT;

import javaGold.PracticeEditor;

public class Practice02MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-02-25 ======
 第２章 Immutable / 練習問題 2-1
〇 （1） java.lang.Stringは immutable。〇
〇 （2） java.lang.StringBufferは immutable。Ｘ
〇 （3） finalフィールドは 二度代入されない。〇
〇 （4） privateフィールドは そのクラスとサブクラス。Ｘ -> サブクラスには継承されない。
〇 （5） synchronizedにしても困ることはない。Ｘ -> パフォーマンス落ちるから、必要以外は付けない。

 練習問題 2-2
〇 （1） String.replace()は元の Stringオブジェクトを変更しているのではなく、
〇 （2） 新しい Stringオブジェクトを生成している。
〇 （3） 元のStringオブジェクトは不変のまま存在し続けているimmutableなクラス。

 練習問題 2-3
〇 （1） 別紙

 練習問題 2-4
〇 （1） フィールドは private finalでも、StringBufferはmutableなクラスなので、
〇 （2） インスタンス後に状態が変化する可能性があるから。

 練習問題 2-5
〇 （1） Pointクラスのフィールドが publicになっており、他クラスから代入される可能性がある。
〇 （2） Pointクラス自体は mutableなクラスなので一度インスタンスしても、その後 変化する可能性がある。

 練習問題 2-6
Ｘ （1） public setPerson(name, address)で MutablePersonのフィールドは書き換え可能。
Ｘ （2） public getImmutablePerson(this); の thisはMutablePersonなので、Immutable
〇 （3） ImmutablePersonのフィールドも書き換え可能。 -> 不変性が崩れる
〇 （4） Immutableの各メソッドは synchronizedされておらず、Thread-safeが崩れる可能性あり。

開始時刻 15:05
終了時刻 15:35
所要時間 29 分
正答率 88.24 ％ ( 〇15問 / 全17問 )
*/

