/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainLinkedList.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p249 / List 6.13
 * @content LinkedList
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.Arrays;
import java.util.LinkedList;

public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(
            Arrays.asList("丑","寅","卯"));
        System.out.println(list);

        list.addFirst("子");
        list.addLast("辰");
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);
    }//main()

}//class

/*
[丑, 寅, 卯]
[子, 丑, 寅, 卯, 辰]

【考察】 addFirst(), addLast()は Listでサポートしておらず、
利用するなら ポリモーフィズムで Listの変数に LinkedListを入れるのではなく、
変数も LinkedListにする必要がある。

getFirst(): 子
getLast():  辰
removeFirst(): 子
removeLast():  辰
[丑, 寅, 卯]

【考察】
getは取り出すだけで消去せず。
removeは取り出した後、要素を消去。
*/