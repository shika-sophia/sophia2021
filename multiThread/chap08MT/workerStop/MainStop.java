/**
 * @title multiThread / chap08MT / workerStop / MainStop.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / 練習問題 8-6, 解 List A8-6, A8-7, A8-8
 * @content 全スレッドを 5秒後に停止。 interrupt()だけでなく、booleanフラグで put(),take()の入口も封鎖。
 * @author shika
 * @date 2021-03-15
 */
package multiThread.chap08MT.workerStop;

import multiThread.chap08MT.workerThread.ChannelWork;
import multiThread.chap08MT.workerThread.ClientThread;

public class MainStop {

    public static void main(String[] args) {
        ChannelWork channel = new ChannelWork(5);
        channel.startWorker();

        var alice = new ClientThread("Alice",channel);
        var bobby = new ClientThread("Bobby",channel);
        var chris = new ClientThread("Chris",channel);
        alice.start();
        bobby.start();
        chris.start();

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alice.stopThread();
        bobby.stopThread();
        chris.stopThread();
        channel.stopAllWorker();

//        System.out.println("totalRequest: " + ChannelStop.getTotalRequest());
//        System.out.println("totalExecute: " + ChannelStop.getTotalExecute());
//        System.out.printf("freeMemory: %,d \n",
//                Runtime.getRuntime().freeMemory());
//        System.exit(0);
    }//main()

}//class

/*
  :
Worker-4 executes [Request from Bobby No.8]
Worker-0 executes [Request from Chris No.12]
Worker-1 executes [Request from Bobby No.9]
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:20)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.RequestWork.execute(RequestWork.java:20)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:14)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.RequestWork.execute(RequestWork.java:20)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:14)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:20)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:20)
java.lang.InterruptedException
    at java.base/java.lang.Object.wait(Native Method)
    at java.base/java.lang.Object.wait(Object.java:328)
    at multiThread.chap08MT.workerThread.ChannelWork.takeRequest(ChannelWork.java:50)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:13)
java.lang.InterruptedException
    at java.base/java.lang.Object.wait(Native Method)
    at java.base/java.lang.Object.wait(Object.java:328)
    at multiThread.chap08MT.workerThread.ChannelWork.takeRequest(ChannelWork.java:50)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:13)
java.lang.InterruptedException
    at java.base/java.lang.Object.wait(Native Method)
    at java.base/java.lang.Object.wait(Object.java:328)
    at multiThread.chap08MT.workerThread.ChannelWork.takeRequest(ChannelWork.java:50)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:13)

【考察】
interrupt()の Exceptionが出た後も、終了にならなかったので、
「^C」で停止したが、まだどこか動いていた様子。

//====== 解 List A8-6, A8-7, A8-8 ======
  :
Worker-3 executes [Request from Chris No.11]
Worker-2 executes [Request from Bobby No.8]
Worker-4 executes [Request from Alice No.9]
java.lang.InterruptedException: sleep interrupted
Worker-2 is terminated.
Worker-3 is terminated.
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:21)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.RequestWork.execute(RequestWork.java:20)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:18)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.RequestWork.execute(RequestWork.java:20)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:18)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.RequestWork.execute(RequestWork.java:20)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:18)
Worker-4 is terminated.
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:21)
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap08MT.workerThread.ClientThread.run(ClientThread.java:21)
java.lang.InterruptedException
    at java.base/java.lang.Object.wait(Native Method)
    at java.base/java.lang.Object.wait(Object.java:328)
    at multiThread.chap08MT.workerThread.ChannelWork.takeRequest(ChannelWork.java:52)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:17)
java.lang.InterruptedException
    at java.base/java.lang.Object.wait(Native Method)
    at java.base/java.lang.Object.wait(Object.java:328)
    at multiThread.chap08MT.workerThread.ChannelWork.takeRequest(ChannelWork.java:52)
    at multiThread.chap08MT.workerThread.WorkerThread.run(WorkerThread.java:17)

【考察】 inerrupt()だけでなく
boolean tarminatedで put(), take()の入口も封鎖したが
やはり、終了はせず。どこか動いていている様子。
*/