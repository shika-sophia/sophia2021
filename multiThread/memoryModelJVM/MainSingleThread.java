/**
 * @title multiThread / memoryModelJVM / MainSingleThread.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-8
 * @content 第１章 SingleThreadExecutionパターン / synchronizedによりパフォーマンスは上がらず
 * @see List B-9
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

import java.time.LocalDate;

class SingleThreadExecution {
    static SingleThreadExecution instance = null;
    private LocalDate now = LocalDate.now();

    private SingleThreadExecution() { }

    public LocalDate getNow() {
        return now;
    }

    public static synchronized SingleThreadExecution getInstance() {
        if (instance == null) {
            instance = new SingleThreadExecution();
        }

        return instance;
    }//getInstance()

}//class SingleThreadExecution

public class MainSingleThread {

    public static void main(String[] args) {

        new Thread(() -> {
            var instance = SingleThreadExecution.getInstance();
            printDate(instance);
        }).start();

        new Thread(() -> {
            var instance = SingleThreadExecution.getInstance();
            printDate(instance);
        }).start();

    }//main()

    private static void printDate(SingleThreadExecution instance) {
        if(instance != null) {
            System.out.println(
                Thread.currentThread().getName() + ": " + instance.getNow());
        } else {
            System.out.println(Thread.currentThread().getName() + ": null");
        }
    }//printDate()

}//class

/*
Thread-0: 2021-03-30
Thread-1: 2021-03-30
*/