/**
 * @title multiThread / chap05MT / heavyTask / MainHeavy.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / List A5-6, A5-7 / p517
 * @content 練習問題 5-7 解答 / 重い処理の中断
 * @class HeavyHost //重い処理(10秒間のループ)
 * @author shika
 * @date 2021-03-05
 */
package multiThread.chap05MT.heavyTask;

public class MainHeavy {

    public static void main(String[] args) {
        //HeavyHostの重い処理を実行するスレッド
        Thread exeThread = new Thread() {
            public void run() {
                System.out.println("HeavyHost.execute() BEGIN");

                try {
                    HeavyHost.execute(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("HeavyHost.execute() END");
            }//run()
        };//Thread inner-class

        exeThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("#### interrupt() ####");
        exeThread.interrupt();
    }//main()

}//class

/*
HeavyHost.execute() BEGIN
doHeavyJob() BEGIN
#### interrupt() ####
doHeavyJob() END
java.lang.InterruptedException
HeavyHost.execute() END
    at multiThread.chap05MT.heavyTask.HeavyHost.execute(HeavyHost.java:8)
    at multiThread.chap05MT.heavyTask.MainHeavy$1.run(MainHeavy.java:20)

【考察】 重い処理は wait(), sleep(), join()以外なので、
Thread.interrupt()しても 例外をスローしない。

明示的に throw句を書いてスローさせる。
ログを見ると、doHeavyJob（）を中断することなく、処理が完了し、
execute()の for文に戻ってから InterruptedExceptionが throwされていることが判る。
*/