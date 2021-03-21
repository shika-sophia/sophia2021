/**
- * @title multiThread / chap10MT / noFlagTermination / MainNoFlag.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Terminationパターン / 練習問題 10-2, List 10-8
 * @content 終了フラグを除去して interrupt状態のみで終了するプログラム
 * @author shika
 * @date 2021-03-19
 */
package multiThread.chap10MT.noFlagTermination;

public class MainNoFlag {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            var th = new CountupNoFlagThread();
            th.start();

            Thread.sleep(5000);

            //スレッドの終了要求
            System.out.println("main: shutdownRequest()");
            th.shutdownRequest();

            //スレッドの終了を待つ
            System.out.println("main: join()");
            th.join();

        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main: END");
    }//main()

}//class

/*
doWork(): counter = 1063529
doWork(): counter = 1063530
doWork(): counter = 1063531
doWork(): counter = 1045490
doWork(): counter = 1063533
doWork(): counter = 1063534
   :
doWork(): counter = 1063606
doWork(): counter = 1045403
doWork(): counter = 1063608
doWork(): counter = 1063609
doWork(): counter = 1063610

【観察】 同じ countは見あたらないけど、たまに飛んでいるのはある
 */

