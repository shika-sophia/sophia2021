/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainNavigable.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p269 / List 6.23
 * @content Queue, Stack, (Deque extends Queue), ArrayDeque
 * @content ArrayDeque実装クラスで Queue, Stackの両方のデータ構造を表す。
 * @author shika
 * @date 2021-04-01
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> data = new ArrayDeque<>();
        data.addLast(10);
        data.addLast(15);
        data.addLast(30);

        //Stack 末尾から追加、末尾から取り出す LIFO or FILO
        System.out.println("data: " + data);
        System.out.println("data.getLast(): " + data.getLast());
        System.out.println("data: " + data);
        System.out.println();

        //Queue 末尾から追加、先頭から取り出す FIFO
        System.out.println("data: " + data);
        System.out.println("data.removeFirst(): " + data.removeFirst());
        System.out.println("data: " + data);
    }//main()

}//class

/*
data: [10, 15, 30]
data.getLast(): 30
data: [10, 15, 30]

data: [10, 15, 30]
data.removeFirst(): 10
data: [15, 30]

 */
