/**
 * @title multiThread / chap09MT / futureData / MainFuture.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Futureパターン / List 9-1, 9-2, 9-3, 9-4, 9-5
 * @author shika
 * @date 2021-03-16
 */
package multiThread.chap09MT.futureData;

public class MainFuture {

    public static void main(String[] args) {
        //---- instance ----
        System.out.println("main BEGIN");
        HostFuture host = new HostFuture();
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
    request(10, A) BEGIN
    request(20, B) BEGIN
    request(20, B) BEGIN
    request(30, C) BEGIN
    making RealData(10,A)
    making RealData(20,B)
    request(30, C) BEGIN
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

