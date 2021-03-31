/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainImmutableList.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p241 / List 6.9, 6.10, 6.11, 6.6
 * @content 不変リスト / Arrays.asList(),
 *                    Collection.of(),
 *                    Collections.unmodifiableCollection()
 * @content 不変リストの要素が参照型だと、要素の変更が可能。
 * @author shika
 * @date 2021-03-31
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainImmutableList {

    public static void main(String[] args) {
        //ArrayListコンストラクタの引数に Arrays.asList()は 不変ではない
        List<String> dataList = new ArrayList<>(
            Arrays.asList("バラ","ひまわり","あさがお","さくら"));

        dataList.set(0, "チューリップ");
        System.out.println("dataList: " + dataList);

        //不変リストに変更
        //dataList = Collections.unmodifiableList(dataList);
        //dataList.set(0, "バラ"); //UnsupportedOperationException
        //dataList.add("ポプラ");   //UnsupportedOperationException
        //System.out.println("dataList: " + dataList);

        //不変リスト Arrays.asList(), Collection.of()
//        String[] dataAry = new String[] {
//            "バラ","ひまわり","あさがお","さくら",};
//        //List<String> dataListImmu = Arrays.asList(dataAry);
//        List<String> dataListImmu = List.of(dataAry);
//        dataListImmu.add("ポプラ");     //UnsupportedOperationException
//        dataListImmu.set(0, "チューリップ");//UnsupportedOperationException
//        System.out.println("dataListImmu: " + dataListImmu);

        //参照型を要素に持つと不変性が崩れ、変更可
        List<StringBuilder> dataListBuilder = List.of(
            new StringBuilder("いろは"),
            new StringBuilder("にほへ"),
            new StringBuilder("とちり")
        );
        System.out.println("dataListBuilder: " + dataListBuilder);
        //要素の参照型を変更
        dataListBuilder.get(0).append("色は匂へど");
        System.out.println("dataListBuilder: " + dataListBuilder);

    }//main()

}//class

/*
//====== new ArrayList<>(Arrays.asList()) ======
//dataList.set(0, "チューリップ");
dataList: [チューリップ, ひまわり, あさがお, さくら]

//====== 不変リストに変更 ======
//dataList = Collections.unmodifiableList(dataList);
Exception in thread "main"
    java.lang.UnsupportedOperationException

//====== List list = Arrays.asList() ======
//list.add(), set()
java.lang.UnsupportedOperationException
【考察】 asList()は Listの皮を被った配列。
List要素への変更は元の配列にも影響する。

//====== List list = List.of() ======
//list.add(), set()
java.lang.UnsupportedOperationException
【考察】
 [Java9-] Collection.of():不変リストを作るメソッド

//====== List<StringBuilder> ======
dataListBuilder: [いろは, にほへ, とちり]

//list.get(0).append()
dataListBuilder: [いろは色は匂へど, にほへ, とちり]

 */