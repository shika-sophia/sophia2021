/**
 * @title javaGoF / chap04JG / factoryMethod / MainFactoryMethod.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第４章 FactoryMethod / List 4-1, 4-2, 4-3, 4-4, 4-5
 * @class MainFactoryMethod //◆main(), new IdCardFactory(), create()
 * @package ---- framework ----
 * @class Factory //Productインスタンスを生成
 * @class Product //製品を表すクラス
 * @package ---- idCard ----
 * @class IdCardFactory extends Factory //IdCardインスタンスを生成
 * @class IdCard extends Product        //IdCardを表すクラス
 * @author shika
 * @date 2021-04-17
 */
package javaGoF.chap04jgFactory.factoryMethod;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javaGoF.chap04jgFactory.factoryMethod.framework.Factory;
import javaGoF.chap04jgFactory.factoryMethod.framework.Product;
import javaGoF.chap04jgFactory.factoryMethod.idCard.IdCardFactory;

public class MainFactoryMethod {

    public static void main(String[] args) {
        Factory factory = new IdCardFactory();
        Product card1 = factory.create("結城浩");
        Product card2 = factory.create("とむら");
        Product card3 = factory.create("佐藤花子");
        card1.use();
        card2.use();
        card3.use();

        //---- print ownerList, ownerMap ----
        List<String> ownerList =
            ((IdCardFactory)factory).getOwnerList();
        System.out.println("ownerList: " + ownerList);

        Map<Integer, String> ownerMap =
            ((IdCardFactory)factory).getOwnerMap();
        for(Entry<Integer, String> entry : ownerMap.entrySet()) {
            System.out.printf("ID %d: OWNER %s \n",
                entry.getKey(), entry.getValue());
        }//for ownerMap
    }//main()

}//class

/*
結城浩(ID 1) のカードを作ります。
とむら(ID 2) のカードを作ります。
佐藤花子(ID 3) のカードを作ります。
結城浩(ID 1) のカードを使います。
とむら(ID 2) のカードを使います。
佐藤花子(ID 3) のカードを使います。

ownerList: [結城浩, とむら, 佐藤花子]
ID 1: OWNER 結城浩
ID 2: OWNER とむら
ID 3: OWNER 佐藤花子

【解答】 練習問題 4-2
IdCardFactory.createProduct(), registerProduct()に
synchronizedが付いているのは、マルチスレッドで実行したとき
同じ idにならないように排他制御している。

【Java仕様】
テキストは 2004年刊のため、ジェネリック以前と思われ、
List, Mapが無記の <Object>仕様だったので補っておきました。

*/