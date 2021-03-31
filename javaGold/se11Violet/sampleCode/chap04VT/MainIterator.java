/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainIterator.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p237 / List 6.2, 6.3, 6.4, 6.5
 * @content ArrayListの for節中の remove()は ConncurrentModificationExecptionで不可。
 *          Iteratorを使うと可能になる。
 * @content ListIterator<T> extends Iterator<T>
 * 				listTerator(int size): ListIterator<T>を生成
 *              hasPrevious(), previous()
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainIterator {

    public static void main(String[] args) {
        List<String> dataList = new ArrayList<>(
            Arrays.asList("バラ","ひまわり","あさがお","さくら"));

//        for (var str : dataList) {
//            System.out.println(str);
//            //dataList.remove(dataList.indexOf(str));
//        }//for str
//        System.out.println();

        Iterator<String> itr = dataList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            //itr.remove();
        }//while
        System.out.println("dataList: " + dataList);
        System.out.println();

        ListIterator<String> itrList = dataList.listIterator(dataList.size());
        while(itrList.hasPrevious()) {
            System.out.println(itrList.previous());
        }//while
    }//main()

}//class

/*
//====== for str ======
バラ
ひまわり
あさがお
さくら

//====== Collection.remove() in for{ } ======
//dataList.remove(dataList.indexOf(str));
Exception in thread "main"
    java.util.ConcurrentModificationException

//====== Iterator.remove() ======
バラ
ひまわり
あさがお
さくら

dataList: []

//====== IteratorList.previous() ======
さくら
あさがお
ひまわり
バラ

*/
