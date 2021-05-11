/**
 * @title javaGold / se11White / Practice08whMultiThread.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第８章 並行処理
 * @author shika
 * @date 2021-04-26
 */
/* Appendix 2021-04-26
 * @costTime 13:36 - 14:09 ( 32 分)
 * @correctRate 正答率 66.67 ％ ( 〇10問 / 全15問 )
 */
/* Appendix 2021-05-11 
 * @costTime 16:01 - 16:18 ( 17 分) 
 * @correctRate 正答率 100.00 ％ ( 〇15問 / 全15問 )
 */ 
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice08whMultiThread {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-26 ======
 第８章 並行処理
〇 （1） A
      => Thread(Runnable, String) コンストラクタ、第２引数にThreadのname。

〇 （2） A
〇 （3） C
〇 （4） A
Ｘ （5） A -> C
     => catch (){}で catch節は閉じているので、
     t.interrupt()は必ず実行される。(ケアレスミス)
     試験問題も省略して書いてあることが多いので注意する

〇 （6） D
〇 （7） A
〇 （8） B
      => RejectedExecutionExecrption: shutdown()後に再び execte()をすると throw。

Ｘ （9） B -> A
      => B: コンパイルエラーの回答理由: submit()で呼び出す call()を定義していない。
      => submit()内のラムダ式で処理内容を定義しているので、これが Callable.call()の定義。
      => es.shutdown()を記述していないので、ThreadPoolは新たなタスクを待ち続け、
      プログラムは終了しないままとなる。

〇 （10） A
Ｘ （11） C -> D
      => 経路は display() -> show()のひと通りだが、
      display(c)はフィールドのオブジェクト
      show(c)は引数のオブジェクトを それぞれロックすることになり、
      デッドロックが発生する。

      詳細
      show()呼出は display()内でされているので、
      display()のロックを取ったスレッドはまだロック解放されていない状態で、
      show()のロックを別スレッドで取ろうとしてブロックされ、エントリーセットで待たされる。
      どちらも、相手のスレッドがロック解放するのを待っているので、
      これをデッドロックと呼ぶ。

〇 （12） C
    => Stavation [= 飢餓] ライブロック(=スレッドの処理は動いている)のうち、
    他のスレッドがロックを占有してしまい、処理が進まないこと。
    setPriority()などで優先度の修正が必要。

Ｘ （13） A, C? -> A, D
    => abstractメソッドに synchronizedの定義不可。
    => Enum内のメソッドにも synchronized可。

Ｘ （14） A -> B
    => GuardedSuspentionパターン
    if()の判定後に他スレッドが割り込んでくる可能性があるため、
    push(),pop()に synchronizedが必要。

    => wait(), notify(), notifyAll()は synchronized内でしか利用できない。
    IllegalMonitorStateException

〇 （15） D

開始時刻 13:36
終了時刻 14:09
所要時間 32 分
正答率 66.67 ％ ( 〇10問 / 全15問 )
*/

/* 
//====== 2021-05-11 ====== 
 MultiThread [２回目]
〇 （1） A   
〇 （2） A   
〇 （3） C   
〇 （4） A   
〇 （5） C   
〇 （6） D   
〇 （7） A   
〇 （8） B   
〇 （9） D   
〇 （10） A   
〇 （11） D   
〇 （12） C   
〇 （13） A, D   
〇 （14） B   
〇 （15） D   

開始時刻 16:01
終了時刻 16:18
所要時間 17 分
正答率 100.00 ％ ( 〇15問 / 全15問 )
*/ 

