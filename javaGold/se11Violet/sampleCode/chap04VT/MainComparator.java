/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainComparator.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p261 / List 6.19
 * @content TreeMap(Comparator), Arrays.sort(Comparator)
 * @content Comparatorインターフェイスは compare(T, T)のみを持つ関数型なので ラムダ式を利用できる。
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MainComparator {

    public static void main(String[] args) {
//    	  //---- Comparator 匿名クラス ----
//        var data = new TreeMap<String, String>(
//            new Comparator<String>() {
//                @Override
//                public int compare(String x, String y) {
//                    return x.length() - y.length();
//                }//compare()
//            }
//        );//data

        //---- Comparator ラムダ式 ----
        var dataMap = new TreeMap<String, String>(
            (x, y) -> -(x.length() - y.length()));

        dataMap.put("Rose", "バラ");
        dataMap.put("Sunflower", "ひまわり");
        dataMap.put("Morning Glory", "あさがお");
        System.out.println(dataMap);
        System.out.println();

        //====== define Array, List ======
        var dataAry = new String[] {
            "バラ","あさがお","チューリップ","さくら"
        };

        List<String> dataList = new ArrayList<>(Arrays.asList(dataAry));

        //---- Arrays.sort(Comparator) ----
        System.out.println("dataAry: " + Arrays.toString(dataAry));
        Arrays.sort(dataAry, (x, y) -> x.length() - y.length());
        System.out.println("sort(dataAry): " + Arrays.toString(dataAry));

        //---- List.sort(Comparator) ----
        System.out.println("dataList: " + dataList);
        dataList.sort((x, y) -> x.length() - y.length());
        System.out.println("dataList.sort(): " + dataList);
    }//main()

}//class

/*
//====== Comparator 匿名クラス ======
{Rose=バラ, Sunflower=ひまわり, Morning Glory=あさがお}

//====== Comparator Lambda ======
{Morning Glory=あさがお, Sunflower=ひまわり, Rose=バラ}

//====== Arrays.sort(T[], Comparator) ======
dataAry: [バラ, あさがお, チューリップ, さくら]
sort(dataAry): [バラ, さくら, あさがお, チューリップ]

//====== List.sort(Comparator) =======
dataList: [バラ, あさがお, チューリップ, さくら]
dataList.sort(): [バラ, さくら, あさがお, チューリップ]
 */

