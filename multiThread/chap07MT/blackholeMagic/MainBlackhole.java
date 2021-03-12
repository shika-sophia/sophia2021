/**
 * @title multiThread / chap07MT / blackholeMagic / MainBlackhole.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-7
 * @content 【問】 Blackhole.enter()は完成している。
 *          以下の実行結果になるよう magic()を記述せよ。
 *
 *          〔実行結果〕
 *          BEGIN
 *          Step1
 *          Step2
 *          (ここで停止。step3は現れない。 ^C)
 *
 * @author shika
 * @date 2021-03-12
 */
package multiThread.chap07MT.blackholeMagic;

public class MainBlackhole {

    public static void main(String[] args) {
        System.out.println("BEGIN");

        Object obj = new Object();
        //Blackhole blackhole = new Blackhole();
        //Blackhole blackhole = new BlackholeWait();
        Blackhole blackhole = new BlackholeJoin();
        blackhole.enter(obj);

        System.out.println("END");
    }//main()

}//class

/*
【解答】実行結果から、以下の要件が必要。
[1] Step2が表示されているので、magic()は例外を投げない。
[2] Step3, ENDが表示されていないので、スレッドは enter()から戻れない。
[3] Step3が表示されていないのは、スレッドが objのロックを取れずにブロックされている。
  ↓
[4] magic()の仕事は objのロックを取ることである。
しかし、synchonizedするだけだと、synchronized { }を外れたところで、ロックを解放してしまう。
  ↓
[5] magic()の中で、新たなスレッドを起動、そのスレッドが objのロックを取る。
[6] 新たなスレッドは永遠にロックを取ったままである。
[7] 新たなスレッドが起動して objのロックを取るまでは、
    元のスレッドは magic()から戻ってはいけない。

//====== BlackholeWait ======
BEGIN
Step1
Step2

(^C)

//====== BlackholeJoin ======
BEGIN
Step1
Step2

(^C)
*/