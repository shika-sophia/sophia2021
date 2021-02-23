/**
 * @title multiThread / chap01MT / deadLock / DeadLock.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content SingleTreadedExecution / デッドロックを起こさせるプログラム
 * @content 練習問題 1-6 デッドロックを防ぐプログラムに改変せよ。-> -RVクラスに記述
 *
 * @class DeadLock //main()
 * @class Tool     //toolNameフィールド
 * @class EaterThread extends Thread
 *        //Thread(), run(), eat(){ synchronized(left), synchronized(right)}
 *
 * @author shika
 * @date 2021-02-23
 */
package multiThread.chap01MT.deadLock;

public class DeadLock {

    public static void main(String[] args) {
        System.out.println("Testing EaterThread...");
        MyTool spoon = new MyTool("Spoon");
        MyTool fork = new MyTool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }//main()
}//class

/*
//====== Result ======
Alice takes up [Spoon](left)
Alice takes up [Fork](right)
Alice is eating now.
Alice put down [Fork](right)
Alice put down [Spoon](left)
Alice takes up [Spoon](left)
Alice takes up [Fork](right)
Alice is eating now.
Alice put down [Fork](right)
Alice put down [Spoon](left)

Bobby takes up [Fork](left)
Alice takes up [Spoon](left)
【デッドロック発生】
*/