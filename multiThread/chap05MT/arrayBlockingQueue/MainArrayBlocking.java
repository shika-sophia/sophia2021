/**
 * @title multiThread / chap05MT / arrayBlockingQueue / MainArrayBlocking.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / List 5-5 ArrayBlockingQueue
 * @author shika
 * @date 2021-03-03
 */
package multiThread.chap05MT.arrayBlockingQueue;

import multiThread.chap05MT.producerConsumer.CakeTable;
import multiThread.chap05MT.producerConsumer.EaterThread;
import multiThread.chap05MT.producerConsumer.MakerThread;

public class MainArrayBlocking {

    public static void main(String[] args) {
        CakeTable table = new CakeTableBlocking(3);
        new MakerThread("MakerThread-1", table, 31415L).start();
        new MakerThread("MakerThread-2", table, 92653L).start();
        new MakerThread("MakerThread-3", table, 58979L).start();
        new EaterThread("EaterThread-1", table, 32384L).start();
        new EaterThread("EaterThread-2", table, 62643L).start();
        new EaterThread("EaterThread-3", table, 38327L).start();
    }//main()

}//class

/*
//====== ArrayBlockingQueue ======
MakerThread-2 puts [Cake No.0 by MakerThread-2]
EaterThread-1 takes [Cake No.0 by MakerThread-2]
MakerThread-1 puts [Cake No.1 by MakerThread-1]
EaterThread-2 takes [Cake No.1 by MakerThread-1]
MakerThread-3 puts [Cake No.2 by MakerThread-3]
EaterThread-3 takes [Cake No.2 by MakerThread-3]
MakerThread-2 puts [Cake No.3 by MakerThread-2]
EaterThread-1 takes [Cake No.3 by MakerThread-2]
MakerThread-3 puts [Cake No.4 by MakerThread-3]
EaterThread-2 takes [Cake No.4 by MakerThread-3]
MakerThread-1 puts [Cake No.5 by MakerThread-1]
EaterThread-3 takes [Cake No.5 by MakerThread-1]
MakerThread-2 puts [Cake No.6 by MakerThread-2]
EaterThread-1 takes [Cake No.6 by MakerThread-2]
MakerThread-3 puts [Cake No.7 by MakerThread-3]
EaterThread-3 takes [Cake No.7 by MakerThread-3]
MakerThread-1 puts [Cake No.8 by MakerThread-1]
EaterThread-2 takes [Cake No.8 by MakerThread-1]
MakerThread-2 puts [Cake No.9 by MakerThread-2]
EaterThread-1 takes [Cake No.9 by MakerThread-2]
MakerThread-1 puts [Cake No.10 by MakerThread-1]
EaterThread-3 takes [Cake No.10 by MakerThread-1]
MakerThread-1 puts [Cake No.11 by MakerThread-1]
EaterThread-1 takes [Cake No.11 by MakerThread-1]
MakerThread-3 puts [Cake No.12 by MakerThread-3]
MakerThread-3 puts [Cake No.13 by MakerThread-3]
EaterThread-2 takes [Cake No.12 by MakerThread-3]
EaterThread-3 takes [Cake No.13 by MakerThread-3]
MakerThread-2 puts [Cake No.14 by MakerThread-2]
EaterThread-2 takes [Cake No.14 by MakerThread-2]
MakerThread-2 puts [Cake No.15 by MakerThread-2]
EaterThread-2 takes [Cake No.15 by MakerThread-2]
MakerThread-3 puts [Cake No.16 by MakerThread-3]
EaterThread-3 takes [Cake No.16 by MakerThread-3]

*/

