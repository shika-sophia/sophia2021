/**
 * @title multiThread / chap09MT / futureCallable / MainCallable.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Futureパターン / List 9-6, 9-7
 * @content Callable, FutureTaskを利用した Futureパターン
 * @author shika
 * @date 2021-03-16
 */
package multiThread.chap09MT.futureCallable;

import multiThread.chap09MT.futureData.AbsData;

public class MainCallable {

    public static void main(String[] args) {
        //---- instance ----
        System.out.println("main BEGIN");
        var host = new HostCallable();
        AbsData data1 = host.request(10, 'A');
        AbsData data2 = host.request(20, 'B');
        AbsData data3 = host.request(30, 'C');

        //---- other job (sleep) ----
        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main otherJob END");

        //---- print getData ----
        System.out.println("data1: " + data1.getContent());
        System.out.println("data2: " + data2.getContent());
        System.out.println("data3: " + data3.getContent());
        System.out.println("main END");
    }//main()
}//class

/*
main BEGIN
    request(10, A) BEGIN
    request(10, A) END
    request(20, B) BEGIN
    request(20, B) END
    request(30, C) BEGIN
    making RealData(10,A)
    making RealData(20,B)
    request(30, C) END
    making RealData(30,C)
main otherJob BEGIN
    making RealData(10,A)
main otherJob END
data1: AAAAAAAAAA
    making RealData(20,B)
data2: BBBBBBBBBBBBBBBBBBBB
    making RealData(30,C)
data3: CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
main END

*/

