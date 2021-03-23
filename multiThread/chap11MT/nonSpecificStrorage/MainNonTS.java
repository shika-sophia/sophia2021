/**
 * @title multiThread / chap11MT / nonSpecificStrorage / MainNonTS.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第11章 Thread-Specific-Storage / List 11-1, 11-2
 * @content サンプル１ / TSパターンを使ってないプログラム
 * @author shika
 * @date 2021-03-24
 */
package multiThread.chap11MT.nonSpecificStrorage;

public class MainNonTS {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");

        for(int i = 0; i <10; i++) {
            LogNonTS.printLog("i = " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for

        LogNonTS.close();
        System.out.println("main: END");
    }//main()

}//class

/*
//---- console ----
main: BEGIN
main: END

//---- logNonTS.txt ----
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
