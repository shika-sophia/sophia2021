/**
 * @title multiThread / memoryModelJVM / doubleChecked / MainDoubleCheched.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-9
 * @content DoubleChechedLockingパターン / ２回テストしてロックするパターンの危険性
 * @see List B-8  MainSingleThread
 * @see List B-10 MainDemandHolder
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM.doubleChecked;

import java.time.LocalDateTime;

class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance = null;
    private LocalDateTime now = LocalDateTime.now();

    private DoubleCheckedLocking() { }

    public LocalDateTime getNow() {
        return now;
    }

    public static DoubleCheckedLocking getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if(instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }//synchronized
        }//if

        return instance;
    }//getInstance()
}//class

public class MainDoubleChecked {

    public static void main(String[] args) {
        new Thread(() -> {
            var instance = DoubleCheckedLocking.getInstance();
            printDate(instance);
        }).start();

        new Thread(() -> {
            var instance = DoubleCheckedLocking.getInstance();
            printDate(instance);
        }).start();

    }//main()

    private static void printDate(DoubleCheckedLocking instance) {
        if(instance != null) {
            System.out.println(
                Thread.currentThread().getName() + ": " + instance.getNow());
        } else {
            System.out.println(Thread.currentThread().getName() + ": null");
        }
    }//printDate()

}//class

/*
Thread-0: 2021-03-30T15:25:01.963033300
Thread-1: 2021-03-30T15:25:01.963033300

【考察】
ナノ秒単位で一致 = 同一インスタンス
SingleThreadExecutionの synchronizedは getInstance()メソッドごとだったが、
DoubleCheckdedは、２回テストすることにより、
synchronized{ } に入るのは、最初の１回だけとなった。

しかし、スレッドＡが synchronized{ } を抜ける前に、
スレッドＢが instance != nullで instanceを持ち返り、
reorderによって、instanceの値が nowより先に見えて
nowが nullのままという可能性はあるとのこと。

instanceに volatileを付記すれば、ちゃんと機能するが
synchronized, volatileで SingleThreadより重くなっては意味がない。

結城氏は DoubleCheckedLockingパターンだと、
JVMメモリモデルのもとでは、うまくいかない可能性があると指摘する。
*/