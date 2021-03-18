/**
 * @title multiThread / chap10MT / twoPhaseTermination / MainCountup.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Terminationパターン / List 10-1, 10-2
 * @author shika
 * @date 2021-03-19
 */
package multiThread.chap10MT.twoPhaseTermination;

public class MainCountup {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            var th = new CountupThread();
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
main: BEGIN
doWork: counter = 1
doWork: counter = 2
doWork: counter = 3
doWork: counter = 4
doWork: counter = 5
doWork: counter = 6
doWork: counter = 7
doWork: counter = 8
doWork: counter = 9
doWork: counter = 10
main: shutdownRequest()
main: join()
java.lang.InterruptedException: sleep interrupted
doShutdown: counter = 10
main: END
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap10MT.twoPhaseTermination.CountupThread.doWork(CountupThread.java:36)
    at multiThread.chap10MT.twoPhaseTermination.CountupThread.run(CountupThread.java:23)
【考察】
shutdownRequest()を出して interrupt()の例外の間に
終了処理 doShutdown: counter = 10 が挟まって
終了。 main: END

//【修正】 e.printStackTrace();をコメントアウト
main: BEGIN
doWork: counter = 1
doWork: counter = 2
doWork: counter = 3
doWork: counter = 4
doWork: counter = 5
doWork: counter = 6
doWork: counter = 7
doWork: counter = 8
doWork: counter = 9
doWork: counter = 10
main: shutdownRequest()
main: join()
doShutdown: counter = 10
main: END

*/