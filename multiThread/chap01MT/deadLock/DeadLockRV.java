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

public class DeadLockRV {

    public static void main(String[] args) {
        System.out.println("Testing EaterThread...");
        MyTool spoon = new MyTool("Spoon");
        MyTool fork = new MyTool("Fork");
        new EaterThreadRV("Alice", spoon, fork).start();
        new EaterThreadRV("Bobby", fork, spoon).start();
    }//main()
}//class

/*
Alice takes up [Spoon](left)
Alice takes up [Fork](right)
Alice is eating now.
Alice put down [Fork](right)
Alice put down [Spoon](left)
Alice takes up [Spoon](left)
Bobby put down [Fork](left)
Bobby takes up [Fork](left)
Bobby takes up [Spoon](right)
Bobby is eating now.
Bobby put down [Spoon](right)
Bobby put down [Fork](left)
    :
(デッドロック起こらず)

【考察】
EaterThread.eat() に２つあった synchronizedを
１つ eat()だけにすれば解決。必ず leftしたら rightも同じ synchronized内で行うにした。

結果を見ると必ずしも eat()内の一連の行動を完了する前に
他の行動が入り込んでいるが、
デッドロックでプログラムが止まることはなかったので、
処理は完了したが、表示が遅れたということか。

あと volatile, Semaphoreによる解決法もありそう。

【解答】 解説 p475
new EaterThreadRV("Alice", spoon, fork).start();
new EaterThreadRV("Bobby", fork, spoon).start();
    ↓
new EaterThreadRV("Alice", spoon, fork).start();
new EaterThreadRV("Bobby", spoon, fork).start();

同じ順でオブジェクト生成。
=> 「synchronizedの対称性」を崩すという解決法

〔別解〕
Pair pair = new Pair(spoon, folk);
new EaterThreadRV("Alice", pair).start();
new EaterThreadRV("Bobby", pair).start();

synchronized(pair){ }とする

synchronizedを１つにするという解決法は、私のコードと同じ。
*/