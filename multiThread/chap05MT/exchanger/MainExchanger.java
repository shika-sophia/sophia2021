/**
 * @title multiThread / chap05MT / exchanger / MainExchanger.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / List 5-6, 7, 8
 * @content Exchangerクラスによるオブジェクト交換
 * @author shika
 * @date 2021-03-04
 */
package multiThread.chap05MT.exchanger;

import java.util.concurrent.Exchanger;

public class MainExchanger {

    public static void main(String[] args) {
        var exchanger = new Exchanger<char[]>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerThread(exchanger, buffer1, 314159).start();
        new ConsumerThread(exchanger, buffer2, 265358).start();
    }//main()

}//class

/*
ConsumerThread: BEFORE exchange()
ProducerThread: A ->
ProducerThread: B ->
ProducerThread: C ->
ProducerThread: D ->
ProducerThread: E ->
ProducerThread: F ->
ProducerThread: G ->
ProducerThread: H ->
ProducerThread: I ->
ProducerThread: J ->
ProducerThread: BEFORE exchange()
ProducerThread: AFTER  exchange()
ConsumerThread: AFTER  exchange()
ConsumerThread: -> A
ConsumerThread: -> B
ProducerThread: K ->
ConsumerThread: -> C
ProducerThread: L ->
ProducerThread: M ->
ConsumerThread: -> D
ProducerThread: N ->
ConsumerThread: -> E
ProducerThread: O ->
ConsumerThread: -> F
ProducerThread: P ->
ConsumerThread: -> G
ProducerThread: Q ->
ConsumerThread: -> H

*/

