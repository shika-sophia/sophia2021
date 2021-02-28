/**
 * @title multiThread / chap03MT / talkThread / MainTalk.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspension / 練習問題 3-5
 * @author shika
 * @date 2021-02-28
 */
package multiThread.chap03MT.talkThread;

import multiThread.chap03MT.guardedSuspension.Request;
import multiThread.chap03MT.guardedSuspension.RequestQueue;

public class MainTalk {

    public static void main(String[] args) {
        var requestQueue1 = new RequestQueue();
        var requestQueue2 = new RequestQueue();
        requestQueue1.putRequest(new Request("Mr.Robot"));
        new TalkThread(requestQueue1, requestQueue2, "Eliote").start();
        new TalkThread(requestQueue2, requestQueue1, "Daring").start();
    }//main()

}//class

/*
Eliote: BEGIN
Daring: BEGIN
Eliote: wait() begin[]
Daring: wait() begin[]

＊List 3-12改 / 元の文を変えて、RequestQueueを１つにしてみたが、デッドロック。
初回は queueに何も入っていないので、両方 wait()になるだろう。
今回は Client,Serverモデルと違い、１つのThreadが get(), put()の両方を行うので、
queueの初期値を入れたとしても、タイミングによって、デッドロックになる可能性はある。
*/
/*
//====== 解答 3-5 ======
main: notifyAll() begin[[Request: Mr.Robot]]
main: notifyAll() end[[Request: Mr.Robot]]
Eliote: BEGIN
Eliote gets [Request: Mr.Robot]
Eliote puts [Request: Mr.Robot!]
Eliote: notifyAll() begin[[Request: Mr.Robot!]]
Eliote: notifyAll() end[[Request: Mr.Robot!]]
Eliote: wait() begin[]
Daring: BEGIN
Daring gets [Request: Mr.Robot!]
Daring puts [Request: Mr.Robot!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!]]
Eliote gets [Request: Mr.Robot!!]
Eliote puts [Request: Mr.Robot!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!]]
Daring gets [Request: Mr.Robot!!!]
Daring puts [Request: Mr.Robot!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!]]
  :
  :
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: wait() begin[]
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: wait() begin[]
Eliote: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Eliote: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Eliote: END
Daring: wait() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring gets [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring puts [Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]
Daring: notifyAll() begin[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: notifyAll() end[[Request: Mr.Robot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!]]
Daring: END

【考察】
元の List 3-12 のように、RequestQueueインスタンス２つだと、あかん気がするけど、
(片方に inputばかりして、もう片方は outputだと、inputの種がなくなり、 outputにばかり溜まりそうだが)
解答を見ると大丈夫みたい。もとのListのように変更。
解答の解決策は初期値の種を main()で入れることで動き出すとのこと。
入れてみると「Mr.Robot」の話で二人は盛り上がってる様子。

１つのスレッドが get(), put()の両方を行うので、
私の回答のように １つの RequestQueueにすると、デッドロックの可能性があるが、
解答のは get() -> input, put() -> outputに分けているので、デッドロックは起きない。
やっぱ、RequestQueueは２つ必要ということか。

＊ちなみに２人がデッドロックに陥ったとき、両者ともロックは持っていない。
wait()に入ってロックを解放しているから。
ただ、両方 wait()に入って、notifyAll()をしてくれる人がいないというデッドロック。
wait()のタイムアウトって大事。
*/