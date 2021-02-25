/**
 * @title multiThread / chap02MT / copyOnWrite / MainCopyOnWrite.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable
 * @content 補講２ java.util.concurrent.CopyOnWriteArrayList の Thread-safeを確認するプログラム。
 *
 * @class MainCopyOnWrite
 *        //main(),
 *        //new CopyOnWriteArrayList,
 *        //new Thread(list).start()
 *
 * @author shika
 * @date 2021-02-25
 */
package multiThread.chap02MT.copyOnWrite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import multiThread.chap02MT.synchronizedList.ReadSyncListThread;
import multiThread.chap02MT.synchronizedList.WriteListThread;

public class MainCopyOnWrite {

    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<>();
        new WriteListThread(list).start();
        new ReadSyncListThread(list).start();
    }//main()

}//class

/*
2209 41602665 80940774 115330419 151412435 182895748 216325374 251141083

＊Thread.sleep(1000)で 1秒眠っている間に
WriteThreadで add()されている 数が synchronizedListに比べ、桁違い増える。
CopyOnWriteの処理にその分 時間が掛かっているということ。
*/