/**
 * @title multiThread / memoryModelJVM / doubleChecked / MainSingleThread.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-8
 * @content 第１章 SingleThreadExecutionパターン / synchronizedによりパフォーマンスは上がらず
 * @see List B-9  MainDoubleChecked
 * @see List B-10 MainDemandHolder
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM.doubleChecked;

import java.time.LocalDateTime;

class SingleThreadExecution {
    private static SingleThreadExecution instance = null;
    private LocalDateTime now = LocalDateTime.now();

    private SingleThreadExecution() { }

    public LocalDateTime getNow() {
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
Thread-0: 2021-03-30T15:11:47.650404900
Thread-1: 2021-03-30T15:11:47.650404900

【考察】
ナノ秒単位で一致 = 同一インスタンス

    if(instance == null){
        instance = new SingleThreadExecution();
    }

    return instance;

なので、instanceが nullでないときは、新たに生成されずに
フィールドにある instanceが返る。

*/