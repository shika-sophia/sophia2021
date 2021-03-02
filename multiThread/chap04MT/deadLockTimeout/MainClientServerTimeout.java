/**
 * @title multiThread / chap04MT / deadLockTimeout / MainCientServerTimeout.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第４章 Balking / デッドロックをタイムアウトさせる。
 * @author shika
 * @date 2021-03-02
 */
package multiThread.chap04MT.deadLockTimeout;

import multiThread.chap03MT.guardedSuspension.RequestQueue;
import multiThread.chap03MT.talkThread.TalkThread;

public class MainClientServerTimeout {

    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueueTimeout();
        RequestQueue requestQueue2 = new RequestQueueTimeout();
        //requestQueue1.putRequest(new Request("Mr.Robot"));
        new TalkThread(requestQueue1, requestQueue2, "Eliote").start();
        new TalkThread(requestQueue2, requestQueue1, "Daring").start();
    }//main()

}//class

/*
＊デッドロックを起こして、タイムアウトを検証するために
getRequest()の synchronizedを外したが、
java.lang.IllegalMonitorStateException

wait(), notify()/notifyAll()は synchronized内でロック取ってないと あかんかった。

//====== 解答 ======
chap03MT.guardedSuspentionの Mainは デッドロック起きずに
うまくいっていたのだから
デッドロックが起きていた 練習問題 3-5の
chap03MT.talkThread.MainTalk にしないと いかん。

Eliote: BEGIN
Daring: BEGIN
Eliote: wait() begin[]
Daring: wait() begin[]
Eliote: wait() end[]
Eliote: wait() begin[]
Daring: wait() end[]
Daring: wait() begin[]
失敗か・・
*/