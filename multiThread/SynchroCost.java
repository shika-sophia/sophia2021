/**
 * @title multiThread / SyncroCost.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable 練習問題 2-3
 * @content List A2-3 / syncronized と immutable の処理時間を計測。
 * @author shika
 * @date 2021-02-25
 */
package multiThread;

public class SynchroCost {
    private static final long CALL_COUNT = 1_000_000_000L;

    public static void main(String[] args) {
        trial("NotSync", new NotSync());
        trial("Sync", new Sync());
    }//main()

    private static void trial(String msg, Object obj) {
        long start = System.currentTimeMillis();
        System.out.println(msg + ": BEGIN");

        for(int i = 0; i < CALL_COUNT; i++) {
            obj.toString();
        }

        long end = System.currentTimeMillis();
        System.out.println(msg + ": END");
        System.out.println("cost time: " + (end - start) + " msec");
    }//trial()
}//class SynchroCost

class NotSync {
    private final String objName = "[NotSync]";

    @Override
    public String toString() {
        return objName;
    }
}//class NotSync

class Sync {
    private final String objName = "[Sync]";

    @Override
    public synchronized String toString() {
        return objName;
    }
}//class Sync

/*
＊immutable
NotSync: BEGIN
NotSync: END
cost time: 395 msec

＊synchronized
Sync: BEGIN
Sync: END
cost time: 1159 msec
*/