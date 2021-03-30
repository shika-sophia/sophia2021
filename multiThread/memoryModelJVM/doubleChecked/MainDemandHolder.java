/**
 * @title multiThread / memoryModelJVM / doubleChecked / MainDemandHolder.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-10
 * @content Initialization on DemandHolderパターン
 * @content 遅延初期化により、必要に応じてインスタンスを生成し保持する
 * @see List B-8 MainSingleThread
 * @see List B-9 MainDoubleChecked
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM.doubleChecked;

import java.time.LocalDateTime;

class MySystem {
    private static class DemandHolder {
        public static MySystem instance = new MySystem();
    }//class DemandHolder

    private LocalDateTime now = LocalDateTime.now();

    private MySystem() { }

    public LocalDateTime getNow() {
        return now;
    }

    public static MySystem getInstance() {
        return DemandHolder.instance;
    }
}//class MySystem

public class MainDemandHolder {

    public static void main(String[] args) {
        new Thread(() -> {
            var instance = MySystem.getInstance();
            printDate(instance);
        }).start();

        new Thread(() -> {
            var instance = MySystem.getInstance();
            printDate(instance);
        }).start();

    }//main()

    private static void printDate(MySystem instance) {
        if(instance != null) {
            System.out.println(
                Thread.currentThread().getName() + ": " + instance.getNow());
        } else {
            System.out.println(Thread.currentThread().getName() + ": null");
        }
    }//printDate()

}//class

/*
Thread-1: 2021-03-30T15:55:36.140639600
Thread-0: 2021-03-30T15:55:36.140639600

【考察】
ナノ秒単位で一致 = 同一インスタンス。同様の動作。
今回は synchronized, volatileを使っていない。
クラスの初期化は JVM仕様上、スレッドセーフに行われる。

ネストクラスの初期化は、
スレッドが MySystem.getInstance()に触れるまで行われないし、MySystemのインスタンスも生成しない。
MySystem.getInstance()されたとき初めて ネストクラスのロードが行われ初期化される。
これを 遅延初期化(lazy initialization)という。

getInstance()をしたスレッドは、instanceに代入された値を持ち返る。

*/