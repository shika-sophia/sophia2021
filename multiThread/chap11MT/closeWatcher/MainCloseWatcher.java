/**
 * @title multiThread / chap11MT / closeWatcher / MainCloseWatcher.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第11章 Thread-Specific-Storageパターン / List A11-1, A11-2
 * @content 練習問題 11-3 解答 / ClientThreadの終了を監視する新たな WatcherThreadを起動
 * @author shika
 * @date 2021-03-25
 */
package multiThread.chap11MT.closeWatcher;

public class MainCloseWatcher {

    public static void main(String[] args) {
        new ClientThreadAutoClose("Alice").start();
        new ClientThreadAutoClose("Bobby").start();
        new ClientThreadAutoClose("Chris").start();
    }//main()

}//class

/*
Alice: BEGIN
Bobby: BEGIN
Chris: BEGIN
startWatcher() for Alice: BEGIN
startWatcher() for Chris: BEGIN
startWatcher() for Bobby: BEGIN
Chris: END
Bobby: END
Alice: END
startWatcher() for Chris: END
startWatcher() for Bobby: END
startWatcher() for Alice: END

 */
