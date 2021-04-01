/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainNavigable.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p263 / List 6.21
 * @content NavigableSet, NavigableMap
 * @content あいまい検索、自然順序で近似する他候補を取得
 * @author shika
 * @date 2021-04-01
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.Map.Entry;
import java.util.TreeMap;

public class MainNavigable {

    public static void main(String[] args) {
        var data = new TreeMap<String, String>(){
            {
                put("peak", "高くなる");
                put("peach", "もも");
                put("peace", "平和");
                put("piece", "1切れ");
            }
        };
        for(Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        String key = "pear";
        if(data.containsKey(key)) {
            System.out.printf(
                "key: %s = value: %s \n", key, data.get(key));
        } else {
            System.out.println("検索中の単語 " + key + " は見つかりません。");
            System.out.print(data.lowerKey(key) + " または ");
            System.out.print(data.higherKey(key));
            System.out.println(" ですか？");
        }
    }//main()

}//class

/*
peace = 平和
peach = もも
peak = 高くなる
piece = 1切れ

検索中の単語 pear は見つかりません。
peak または piece ですか？

検索中の単語 apear は見つかりません。
null または peace ですか？

【考察】
ソート後の TreeMapの並び順は上記。
lowerKey(),higherKey()の該当なしだと nullとなる。

他
ceilingEntry(), ceilingKey()
floorEntry(), floorKey()
lowerEntry(), higherEntry()
headMap(), tailMap()

上記メソッドの戻り値
Key -> K
Entry -> Map.Entry<K, V>
Map -> NavigableMap<K, V>
*/