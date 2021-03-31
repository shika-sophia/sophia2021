/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainHashSet.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p252 / List 6.14
 * @content HashSet
 * @content 集合演算 addAll(), removeAll(), retainAll()
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.Arrays;
import java.util.HashSet;

public class MainHashSet {

    public static void main(String[] args) {
        var hs = new HashSet<Integer>(
            Arrays.asList(1, 20, 30, 10, 30, 60, 15));
        var hs2 = new HashSet<Integer>(
                Arrays.asList(10, 20, 99));

        System.out.println("hs: " + hs);
        System.out.println("hs.size(): " + hs.size());
        System.out.println("hs.contains(1): " + hs.contains(1));
        System.out.println("hs.containsAll(hs2): " + hs.containsAll(hs2));
        System.out.println("hs.remove(1): " + hs.remove(1));
        System.out.println();
        System.out.println("hs: " + hs);
        System.out.println("hs2: " + hs2);

        //hsをコピー
        var hs3 = new HashSet<Integer>(hs);

        //和集合
        hs.addAll(hs2);
        System.out.println("和集合 hs.addAll(hs2): " + hs);
        //hsを初期化
        hs.clear();
        hs.addAll(hs3);

        //差集合
        hs.removeAll(hs2);
        System.out.println("差集合 hs.removeAll(hs2): " + hs);
        //hsを初期化
        hs.clear();
        hs.addAll(hs3);

        //積集合
        hs.retainAll(hs2);
        System.out.println("積集合 hs.retainAll(hs2): " + hs);

    }//main()

}//class

/*
hs: [1, 20, 10, 60, 30, 15]
hs.size(): 6
hs.contains(1): true
hs.containsAll(hs2): false
hs.remove(1): true

hs: [20, 10, 60, 30, 15]
hs2: [99, 20, 10]
和集合 hs.addAll(hs2): [99, 20, 10, 60, 30, 15]
差集合 hs.removeAll(hs2): [60, 30, 15]
積集合 hs.retainAll(hs2): [20, 10]

*/