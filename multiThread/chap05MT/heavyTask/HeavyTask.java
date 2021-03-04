/**
 * @title multiThread / chap05MT / producerConsumer / MainArrayBlocking.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / List 5-1, 5-2, 5-3, 5-4
 * @content 練習問題 5-7 / HeavyTaskを中断可能にする。
 * @author shika
 * @date 2021-03-04
 */
package multiThread.chap05MT.heavyTask;

public class HeavyTask {

    public void execute(int BOUND) {

        for(int i = 0; i < BOUND; i++) {
            doHeavyTask(BOUND);
        }
    }//execute()
    private void doHeavyTask(int BOUND) {
        try {
            System.out.println(Thread.currentThread().getName() + ": doHeavyTask()");
            Thread.sleep(BOUND);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }//doHeavyTask

    public static void main(String[] args) {
        Thread thHeavy = Thread.currentThread();
        new LimitThread(thHeavy).start();

        var here = new HeavyTask();
        here.execute(10000);
    }//main()

}//class

/*
main: doHeavyTask()
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at multiThread.chap05MT.heavyTask.HeavyTask.doHeavyTask(HeavyTask.java:15)
    at multiThread.chap05MT.heavyTask.HeavyTask.execute(HeavyTask.java:8)
    at multiThread.chap05MT.heavyTask.HeavyTask.main(HeavyTask.java:28)

*/