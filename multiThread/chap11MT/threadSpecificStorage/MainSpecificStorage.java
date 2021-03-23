/**
 * @title multiThread / chap11MT / threadSpecificStorage / MainSpecificStorage.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第11章 Thread-Specific-Storage / List 11-3, 11-4, 11-5, 11-6
 * @content サンプル２ / TSパターンを使ったプログラム
 * @author shika
 * @date 2021-03-24
 */
package multiThread.chap11MT.threadSpecificStorage;

public class MainSpecificStorage {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }//main()

}//class

/*
Alice: BEGIN
Bobby: BEGIN
Chris: BEGIN
Bobby: END
Alice: END
Chris: END
(ファイルがないときは自動生成される)

//---- Alice_log.txt ----
i = 0
i = 1
i = 2
i = 3
i = 4
i = 5
i = 6
i = 7
i = 8
i = 9
==== End of Log ====
 */
