/**
 * @title multiThread / chap06MT / reentrant / MainReentrant.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第６章 Read-Write Lock / List 6-6
 * @class ReentrantData
 * 		  //ReentrantReadWriteLockクラスを用いて、旧 ReadWriteLockの機能を実現
 * @author shika
 * @date 2021-03-06
 */
package multiThread.chap06MT.reentrant;

import multiThread.chap06MT.readWriteLock.ReadThread;
import multiThread.chap06MT.readWriteLock.ReadWriteData;
import multiThread.chap06MT.readWriteLock.WriteThread;

public class MainReentrant {

    public static void main(String[] args) {
        ReadWriteData data = new ReentrantData(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriteThread(data, "abcdefghijklmnopqrstuvwxyz").start();
    }//main()

}//class

/*
Thread-5 reads {*, *, *, *, *, *, *, *, *, *}
Thread-1 reads {*, *, *, *, *, *, *, *, *, *}
Thread-4 reads {*, *, *, *, *, *, *, *, *, *}
Thread-3 reads {*, *, *, *, *, *, *, *, *, *}
Thread-0 reads {*, *, *, *, *, *, *, *, *, *}
Thread-2 reads {*, *, *, *, *, *, *, *, *, *}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-5 reads {a, a, a, a, a, a, a, a, a, a}
Thread-2 reads {a, a, a, a, a, a, a, a, a, a}
Thread-1 reads {a, a, a, a, a, a, a, a, a, a}
Thread-4 reads {a, a, a, a, a, a, a, a, a, a}
Thread-3 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {a, a, a, a, a, a, a, a, a, a}
Thread-0 reads {B, B, B, B, B, B, B, B, B, B}
Thread-1 reads {B, B, B, B, B, B, B, B, B, B}
Thread-4 reads {B, B, B, B, B, B, B, B, B, B}
Thread-2 reads {B, B, B, B, B, B, B, B, B, B}
Thread-3 reads {B, B, B, B, B, B, B, B, B, B}
Thread-5 reads {B, B, B, B, B, B, B, B, B, B}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-5 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {b, b, b, b, b, b, b, b, b, b}
Thread-0 reads {b, b, b, b, b, b, b, b, b, b}
Thread-2 reads {b, b, b, b, b, b, b, b, b, b}
Thread-4 reads {b, b, b, b, b, b, b, b, b, b}
Thread-1 reads {b, b, b, b, b, b, b, b, b, b}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-1 reads {C, C, C, C, C, C, C, C, C, C}
Thread-3 reads {C, C, C, C, C, C, C, C, C, C}
Thread-0 reads {C, C, C, C, C, C, C, C, C, C}
Thread-2 reads {C, C, C, C, C, C, C, C, C, C}
Thread-5 reads {C, C, C, C, C, C, C, C, C, C}
Thread-4 reads {C, C, C, C, C, C, C, C, C, C}

 */
