/**
 * @title multiThread / chap02MT / unsafeArrayList / MainArrayList.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable
 * @content 補講２ ArrayListの Thread-unsafeを検証するプログラム。
 *          -> ConcurrentModificationExceptionを出す。
 *
 * @class MainArrayList                  //main(), new ArrayList, new Thread(list).start()
 * @class WriteListThread extends Thread //Thread.run(){ add(), remove()}
 * @class ReadListThread extends Thread  //Thread.run(){ println() }
 *
 * @author shika
 * @date 2021-02-25
 */
package multiThread.chap02MT.unsafeArrayList;

import java.util.ArrayList;
import java.util.List;

public class MainArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new WriteListThread(list).start();
        new ReadListThread(list).start();
    }//main()

}//class

/*
//====== Result ======
(意図どうりの結果)
Exception in thread "ReadTread" java.util.ConcurrentModificationException
at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1042)
at java.base/java.util.ArrayList$Itr.next(ArrayList.java:996)
at multiThread.chap02MT.unsafeArrayList.ReadListThread.run(ReadSyncListThread.java:15)

＊java.util.ConcurrentModificationException
ReadSyncListThread.run()内の
    for(int n : list) {         <- ここで出る。
        System.out.println(n);
    }

WriteListThread.run（）の add()や remove()では出ないんだ。

＊ArrayList$Itr.checkForComodification(ArrayList.java:1042)
例外表示の「$Itr」はインナークラス？かな。たぶん Iteratorクラス。
checkForComodification() というメソッドで、
for文内の ArrayList変更をチェックしているようです。
*/