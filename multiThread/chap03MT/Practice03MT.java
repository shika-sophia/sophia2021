/**
 * @title multiThread / chap03MT / Practice03MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspension / 練習問題
 * @author shika
 * @date 2021-02-28
 */
/* Appendix
 * @costTime 08:12 - 08:49 ( 36 分)
 * @correctRate 正答率 52.63 ％ ( 〇10問 / 全19問 )
 */
package multiThread.chap03MT;

import javaGold.PracticeEditor;

public class Practice03MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-02-28 ======
 第３章 GuardedSuspension / 練習問題 3-1
〇 （1） getRequest(),putRequest()は別のスレッドから呼び出し。〇
〇 （2） RequestQueueのインスタンスは２個作られる。Ｘ -> ここは１つにして、スレッドを２個
〇 （3） remove()時 queue.peek() != null 必ずは true。〇 -> nullになってないのがガード条件
〇 （4） wait()時 queue.peek() != null 必ずは false。〇 -> nullのとき wait()
〇 （5） Clientが put実行時、Serverは動いていない。Ｘ
    -> wait中のもあるが常にgetしている。？
    => wait中はとまっているが、それ以外は動いている。

Ｘ （6） ロックを解放してウエイトセットに入る。〇
     => queueのウエイトセットではなく、this(= RequestQueue)のウェイトセットに入る。

〇 （7） queue.notifyAll()でも同じ意味。Ｘ
    -> Objectクラスのメソッドなのでコンパイルは通るが、
    currentThread().notifyAll()が正しい
    => queueのウェイトセットで待機しているのではなく、this(= RequestQueue)
    => this.notifyAll()ならＯＫ

 練習問題 3-2
Ｘ （1） notifyAll()で解放しても、インスタンスの状態は変わっていないのでまたwait()に入る。
Ｘ （2） でも次のput時には行けそう。
    => notifyAll()で解放されたwait中のスレッドは、
    notifyAll()をしたスレッドが抜けるまでは、ここがロックを持っているので、
    offer()を実行してput{ }を抜けた時点でロック解放、
    wait中のスレッドがロックを取り始める。
    => notifyAll()が先でも問題ないが、
    可読性の意味から最後に記述したほうが解りやすい。

 練習問題 3-3
〇 （1） デバックprint: 別紙

 練習問題 3-4
Ｘ （1） while -> if: if(false)でも remove()が実行されてしまう
    => wait()だから、remove()が実行されることはない。
    => notifyAll()時に解放されたwait中のスレッドはすでにifで判定済のため、
    そのまま、remove()に来る。
    wait中が複数あり、queueの要素が1つしかなけば、
    ２つ目のスレッドは null状態で remove()することになる。
    => whileにするのはwaitを抜けたスレッドを再度ガード条件判定するため。

〇 （2） synchronizedを wait()だけ: 別々のスレッドが利用しているので行けそう
    => このプログラムでは別々なので問題は起きないが
    wait()だけ synchronizedにすると、
    while(),remove()が synchronizedから外れ、
    要素が１つしかないとき、２つのスレッドで同時に while(true)が出て、
    ２つ同時に remove() -> NoSuchElementException

    => フィールドqueue = LinkedListはスレッドセーフではないので、
    フィールド queueの関わるところは synchronizedして使うべき。

Ｘ （3） try-catchを whileの外に: wait()が try{ }内ならＯＫ
    => wait中に intrrupt()をされ、catch節に飛び remove()
    ガード条件の判定をしなくても remove()できてしまう。

〇 （4） wait() -> Thread.sleep(): そのスレッドはロックを取ったまま眠り、一定時間後に再開する。ロックは解放されなので別スレッド以外の全体が停止する。

 練習問題 3-5
Ｘ （1） get -- req1, put -- req2のように、別のインスタンスがそれぞれのメソッドだけを利用。
Ｘ （2） req1のqueueには常に値がなく、全てのスレッドが wait()に入り、
Ｘ （3） req2 の queueには　値が入り続け notifyAll()するが、wait()で待機しているスレッドがない。
Ｘ （4） queueを持つ RequestQueueインスタンスを1つにして、TalkThreadを２つにすれば解決か？

 練習問題 3-6
〇 （1） -99保留

開始時刻 08:12
終了時刻 08:49
所要時間 36 分
正答率 52.63 ％ ( 〇10問 / 全19問 )
*/

