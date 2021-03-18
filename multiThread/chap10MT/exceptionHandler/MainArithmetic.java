/**
 * @title multiThread / chap10MT / execeptionHandler / MainArithmetic.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Terminationパターン / List 10-3
 * @content Thread.setDefaultUncoughtExceptionHandler() //例外の取りこぼしがないようにする。
 * @content Runtime.addShutdownHook() //Java処理系終了時に起動するスレッドを呼び出す。
 * @content 3秒後に 0除算をするThreadを起動。ArithmeticExceptionを出す。
 * @author shika
 * @date 2021-03-19
 */
package multiThread.chap10MT.exceptionHandler;

public class MainArithmetic {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");

        //catchされない例外のハンドラを設定する
        Thread.setDefaultUncaughtExceptionHandler(
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable exception) {
                    System.out.println("****");
                    System.out.println("UncoughtExceptionHandler: BEGIN");
                    System.out.println("currentThread: " + Thread.currentThread());
                    System.out.println("thread: " + thread);
                    System.out.println("exception: " + exception);
                    System.out.println("UncoughtExceptionHandler: END");
                }//uncaughtException()
            }
        );

        //シャットダウンフックを設定する
        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                public void run() {
                    System.out.println("****");
                    System.out.println("shutdownHook(): BEGIN");
                    System.out.println("currentThread" + Thread.currentThread());
                    System.out.println("shutdownHook(): END");
                }//run()
            }
        );

        //3秒後に 0除算をして例外を出す Thread
        new Thread("MyThread") {
            public void run() {
                System.out.println("MyThread: BEGIN");
                try {
                    System.out.println("MyThread: SLEEP...");
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                    ;
                }

                //0除算
                @SuppressWarnings("unused")
                int x = 1 / 0;

                //ここには来ない
                System.out.println("MyThread: END");
            }//run()
        }.start();

        System.out.println("main: END");
    }//main()

}//class

/*
main: BEGIN
main: END
MyThread: BEGIN
MyThread: SLEEP...
****
UncoughtExceptionHandler: BEGIN
currentThread: Thread[MyThread,5,main]
thread: Thread[MyThread,5,main]
exception: java.lang.ArithmeticException: / by zero
UncoughtExceptionHandler: END
****
shutdownHook(): BEGIN
currentThreadThread[Thread-0,5,main]
shutdownHook(): END

*/