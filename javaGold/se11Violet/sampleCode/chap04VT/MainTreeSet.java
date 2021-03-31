/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainTreeSet.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p253 / List 6.15
 * @content TreeSet
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.Arrays;
import java.util.TreeSet;

public class MainTreeSet {

    public static void main(String[] args) {
        var ts = new TreeSet<Integer>(
            Arrays.asList(1, 20, 30, 10, 60, 15));
        System.out.println("ts: " + ts);
        System.out.println("ts.descendingSet(): " + ts.descendingSet());
        System.out.println("ts.ceiling(15): " + ts.ceiling(15));
        System.out.println("ts.higher(15): " + ts.higher(15));
        System.out.println("ts.floor(15): " + ts.floor(15));
        System.out.println("ts.lower(15)" + ts.lower(15));
        System.out.println("ts.tailSet(15): " + ts.tailSet(15));
        System.out.println("ts.headSet(30, true):" + ts.headSet(30, true));
    }//main()

}//class

/*
ts: [1, 10, 15, 20, 30, 60]
ts.descendingSet(): [60, 30, 20, 15, 10, 1]
ts.ceiling(15): 15
ts.higher(15): 20
ts.floor(15): 15
ts.lower(15)10
ts.tailSet(15): [15, 20, 30, 60]
ts.headSet(30, true):[1, 10, 15, 20, 30]

*/