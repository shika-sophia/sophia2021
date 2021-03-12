/**
 * @title javaGold / selfLearn / DJchap10Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content [ 第10章 Lambda, StreamAPI / 練習問題 10.1,  章末問題]
 * @author shika
 * @date 2021-03-12
 */
/* Appendix
 * @costTime 10:51 - 11:08 ( 16 分)
 * @correctRate 正答率 66.67 ％ ( 〇8問 / 全12問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap10Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-12 ======
 第10章 Lambda, StreamAPI / 練習問題 10.1
〇 （1） (int i) -> { return i * i;} / i -> i * i
Ｘ （2） list.stream().filter( s -> s.length > 5).forEach(System.out::println);
    => list.removeIf()を使う。Stream.filter()でも出るが、それはまだ。

 章末問題
〇 （1） Ｘ -> 引数にメソッドを引き渡すコードは、匿名クラスより、ラムダやメソッド参照を利用すべき。
〇 （2） Ｘ 引数がないラムダ式は ()->式。()の省略は不可。
〇 （3） Ｘ Streamの終端処理で全ての処理が行われるので、省略不可。
〇 （4） Ｘ 並列化 .parallel() / 直列化 .sequence()?
  => sequential()
〇 （5） Ｘ forEach()は実行順序を保証しない。forEachOrdered()を用いる。
〇 （6） [2]① <T>
Ｘ （7） ② Predicater<T>
  => Predicate<T>

Ｘ （8） ③ cond
    cond.test(value)
Ｘ （9） ④ accept()
    result.add(value)
〇 （10） ⑤ s -> s.length() > 3

開始時刻 10:51
終了時刻 11:08
所要時間 16 分
正答率 66.67 ％ ( 〇8問 / 全12問 )
*/

