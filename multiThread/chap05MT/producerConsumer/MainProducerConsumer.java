/**
 * @title multiThread / chap05MT / producerConsumer / MainArrayBlocking.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / List 5-1, 5-2, 5-3, 5-4
 * @content 練習問題 5-4 / wait()表示
 * @content 練習問題 5-5 / clearCake(), EaterThread.sleep(5000)
 * @content 練習問題 5-6 / 開始10秒後に 全スレッド停止。
 * @author shika
 * @date 2021-03-03
 */
package multiThread.chap05MT.producerConsumer;

import java.util.List;

public class MainProducerConsumer {
    private static final long TIME_LIMIT = 10000; //10秒後に interrupt()

    public static void main(String[] args) {
        var table = new CakeTable(3);
        Thread maker1 = new MakerThread("MakerThread-1", table, 31415);
        Thread maker2 = new MakerThread("MakerThread-2", table, 92653);
        Thread maker3 = new MakerThread("MakerThread-3", table, 58979);
        Thread eater1 = new EaterThread("EaterThread-1", table, 32384);
        Thread eater2 = new EaterThread("EaterThread-2", table, 62643);
        Thread eater3 = new EaterThread("EaterThread-3", table, 38327);

        //ThreadListの生成
        List<Thread> thList = List.of(
                maker1, maker2, maker3,
                eater1, eater2, eater3);

        //Thread.start()
        thList.forEach(Thread::start);

        //10秒後に、Thread.interrupt()
        interruptAll(thList);
    }//main()

    private static void interruptAll(List<Thread> thList) {
        try {
            Thread.sleep(TIME_LIMIT);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Thread.interrupt()
        thList.forEach(Thread::interrupt);
    }//interrupt

}//class

/*
MakerThread-2 puts [Cake No.0 by MakerThread-2]
EaterThread-1 takes [Cake No.0 by MakerThread-2]
MakerThread-1 puts [Cake No.1 by MakerThread-1]
EaterThread-3 takes [Cake No.1 by MakerThread-1]
MakerThread-3 puts [Cake No.2 by MakerThread-3]
EaterThread-2 takes [Cake No.2 by MakerThread-3]
MakerThread-2 puts [Cake No.3 by MakerThread-2]
EaterThread-1 takes [Cake No.3 by MakerThread-2]
MakerThread-3 puts [Cake No.4 by MakerThread-3]
EaterThread-3 takes [Cake No.4 by MakerThread-3]
MakerThread-1 puts [Cake No.5 by MakerThread-1]
EaterThread-1 takes [Cake No.5 by MakerThread-1]
MakerThread-2 puts [Cake No.6 by MakerThread-2]
EaterThread-2 takes [Cake No.6 by MakerThread-2]
MakerThread-3 puts [Cake No.7 by MakerThread-3]
EaterThread-3 takes [Cake No.7 by MakerThread-3]
MakerThread-1 puts [Cake No.8 by MakerThread-1]
EaterThread-1 takes [Cake No.8 by MakerThread-1]
MakerThread-2 puts [Cake No.9 by MakerThread-2]
EaterThread-2 takes [Cake No.9 by MakerThread-2]
MakerThread-1 puts [Cake No.10 by MakerThread-1]
EaterThread-3 takes [Cake No.10 by MakerThread-1]
MakerThread-1 puts [Cake No.11 by MakerThread-1]
EaterThread-1 takes [Cake No.11 by MakerThread-1]
MakerThread-3 puts [Cake No.12 by MakerThread-3]
MakerThread-3 puts [Cake No.13 by MakerThread-3]
EaterThread-3 takes [Cake No.12 by MakerThread-3]
EaterThread-2 takes [Cake No.13 by MakerThread-3]
MakerThread-2 puts [Cake No.14 by MakerThread-2]
EaterThread-2 takes [Cake No.14 by MakerThread-2]
MakerThread-2 puts [Cake No.15 by MakerThread-2]
EaterThread-2 takes [Cake No.15 by MakerThread-2]
MakerThread-3 puts [Cake No.16 by MakerThread-3]
EaterThread-3 takes [Cake No.16 by MakerThread-3]
MakerThread-1 puts [Cake No.17 by MakerThread-1]
EaterThread-3 takes [Cake No.17 by MakerThread-1]
MakerThread-1 puts [Cake No.18 by MakerThread-1]
EaterThread-1 takes [Cake No.18 by MakerThread-1]
MakerThread-3 puts [Cake No.19 by MakerThread-3]
EaterThread-2 takes [Cake No.19 by MakerThread-3]
MakerThread-3 puts [Cake No.20 by MakerThread-3]
EaterThread-3 takes [Cake No.20 by MakerThread-3]
MakerThread-2 puts [Cake No.21 by MakerThread-2]
MakerThread-1 puts [Cake No.22 by MakerThread-1]
EaterThread-3 takes [Cake No.21 by MakerThread-2]

//====== 練習問題 5-4 / wait()表示 ======
EaterThread-1 waits take()
EaterThread-3 waits take()
EaterThread-2 waits take()
MakerThread-2 puts [Cake No.0 by MakerThread-2]
EaterThread-1 notified take()
EaterThread-1 takes [Cake No.0 by MakerThread-2]
EaterThread-2 notified take()
EaterThread-2 waits take()
EaterThread-3 notified take()
EaterThread-3 waits take()
MakerThread-1 puts [Cake No.1 by MakerThread-1]
EaterThread-2 notified take()
EaterThread-2 takes [Cake No.1 by MakerThread-1]
EaterThread-3 notified take()
EaterThread-3 waits take()
MakerThread-3 puts [Cake No.2 by MakerThread-3]
EaterThread-3 notified take()
EaterThread-3 takes [Cake No.2 by MakerThread-3]
EaterThread-1 waits take()
MakerThread-2 puts [Cake No.3 by MakerThread-2]
EaterThread-1 notified take()
EaterThread-1 takes [Cake No.3 by MakerThread-2]
EaterThread-2 waits take()
EaterThread-3 waits take()
MakerThread-3 puts [Cake No.4 by MakerThread-3]
EaterThread-2 notified take()
EaterThread-2 takes [Cake No.4 by MakerThread-3]
EaterThread-3 notified take()
EaterThread-3 waits take()
EaterThread-1 waits take()
MakerThread-1 puts [Cake No.5 by MakerThread-1]
EaterThread-3 notified take()
EaterThread-3 takes [Cake No.5 by MakerThread-1]
EaterThread-1 notified take()
EaterThread-1 waits take()
MakerThread-2 puts [Cake No.6 by MakerThread-2]
EaterThread-1 notified take()
EaterThread-1 takes [Cake No.6 by MakerThread-2]
EaterThread-3 waits take()
MakerThread-3 puts [Cake No.7 by MakerThread-3]
EaterThread-3 notified take()
EaterThread-3 takes [Cake No.7 by MakerThread-3]
EaterThread-2 waits take()
EaterThread-1 waits take()
MakerThread-1 puts [Cake No.8 by MakerThread-1]
EaterThread-2 notified take()
EaterThread-2 takes [Cake No.8 by MakerThread-1]
EaterThread-1 notified take()
EaterThread-1 waits take()
EaterThread-3 waits take()
MakerThread-2 puts [Cake No.9 by MakerThread-2]
EaterThread-1 notified take()
EaterThread-1 takes [Cake No.9 by MakerThread-2]
EaterThread-3 notified take()
EaterThread-3 waits take()

//====== 練習問題 5-5 / clearCake(), EaterThread.sleep(5000) ======
EaterThread-1 waits take()
EaterThread-2 waits take()
EaterThread-3 waits take()
MakerThread-2 puts [Cake No.0 by MakerThread-2]
EaterThread-1 notified take()
EaterThread-1 takes [Cake No.0 by MakerThread-2]
EaterThread-3 notified take()
EaterThread-3 waits take()
EaterThread-2 notified take()
EaterThread-2 waits take()
MakerThread-1 puts [Cake No.1 by MakerThread-1]
EaterThread-3 notified take()
EaterThread-3 takes [Cake No.1 by MakerThread-1]
EaterThread-2 notified take()
EaterThread-2 waits take()
MakerThread-3 puts [Cake No.2 by MakerThread-3]
EaterThread-2 notified take()
EaterThread-2 takes [Cake No.2 by MakerThread-3]
MakerThread-2 puts [Cake No.3 by MakerThread-2]
MakerThread-3 puts [Cake No.4 by MakerThread-3]
MakerThread-1 puts [Cake No.5 by MakerThread-1]
MakerThread-2 cleared All cake.
MakerThread-2 puts [Cake No.6 by MakerThread-2]
MakerThread-3 puts [Cake No.7 by MakerThread-3]
MakerThread-1 puts [Cake No.8 by MakerThread-1]
MakerThread-2 cleared All cake.
MakerThread-2 puts [Cake No.9 by MakerThread-2]
EaterThread-2 takes [Cake No.9 by MakerThread-2]
MakerThread-1 puts [Cake No.10 by MakerThread-1]
MakerThread-1 puts [Cake No.11 by MakerThread-1]
MakerThread-3 puts [Cake No.12 by MakerThread-3]
MakerThread-3 cleared All cake.
MakerThread-3 puts [Cake No.13 by MakerThread-3]
EaterThread-2 takes [Cake No.13 by MakerThread-3]
MakerThread-2 puts [Cake No.14 by MakerThread-2]
MakerThread-2 puts [Cake No.15 by MakerThread-2]
MakerThread-3 puts [Cake No.16 by MakerThread-3]
MakerThread-1 cleared All cake.
MakerThread-1 puts [Cake No.17 by MakerThread-1]
MakerThread-1 puts [Cake No.18 by MakerThread-1]
MakerThread-3 puts [Cake No.19 by MakerThread-3]

//====== 練習問題 5-6 / 開始10秒後に 全スレッド停止。 ======
  : (10秒待つ)
EaterThread-2 takes [Cake No.56 by MakerThread-3]
MakerThread-2 puts [Cake No.59 by MakerThread-2]
EaterThread-2 takes [Cake No.57 by MakerThread-3]
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.MakerThread.run(MakerThread.java:19)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.MakerThread.run(MakerThread.java:19)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.EaterThread.run(EaterThread.java:20)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.MakerThread.run(MakerThread.java:19)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.EaterThread.run(EaterThread.java:20)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.producerConsumer.EaterThread.run(EaterThread.java:20)

InterruptedException ちゃんと 6つある。
*/

