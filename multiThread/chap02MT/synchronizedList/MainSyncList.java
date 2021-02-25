/**
 * @title multiThread / chap02MT / synchronizedList / MainSyncList.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable
 * @content 補講２ Collections.synchronizedList()の Thread-safeを確認するプログラム。
 *
 * @class MainSyncList
 *        //main(),
 *        //Collections.synchronizedList(new ArrayList),
 *        //new Thread(list).start()
 * @class WriteListThread extends Thread
 *        //Thread.run(){ add(), remove() }
 *        //〔 = unsafeArrayList.WriteListThreadと同じもの〕
 * @class ReadSyncListThread extends Thread
 *        //Thread.run(){
 *            synchronized(list) { println() }}
 *
 * @author shika
 * @date 2021-02-25
 */
package multiThread.chap02MT.synchronizedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainSyncList {

    public static void main(String[] args) {
        final List<Integer> list =
            Collections.synchronizedList(new ArrayList<>());
        new WriteListThread(list).start();
        new ReadSyncListThread(list).start();
    }//main()

}//class

/*
:
2530 2530 2530 2530 2530 2531 2531 2531 2537 2537
2581 2581 2581 2581 2581 2690 2690
:
＊例外は出ず。

＊final List<Integer> list
finalなのに add(), remove()できるんだ。

＊println()を print()にすると、表示が出なくなる。
-> Thread.sleep()で表示された。

＊if (count % 10 == 0 && count != 0) {
  System.out.println();
}
count++;
  こんなのを付けてみたが、改行されない。
*/