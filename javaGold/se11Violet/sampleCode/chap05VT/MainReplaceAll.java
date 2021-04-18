/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainReplaceAll.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 関数型インターフェイスと ラムダ式
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content Collection with Lambda / p472 / List 10-6, 10-7, 10-8
 * @content void List.replaceAll(UnaryOperator<E>)
 *          void Map.replaceAll(BiFunction<K,V,V>)
 *          boolean Collecion.removeIf(Predicate<? super E>)
 * @author shika
 * @date 2021-04-18
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainReplaceAll {

    public static void main(String[] args) {
        //---- List 10-6 ----
        List<String> list = new ArrayList<>(
            Arrays.asList("バラ","チューリップ","あさがお"));
        List<String> listCopy = new ArrayList<>(list);
        listCopy.replaceAll(v -> {
            if(v.length() < 3) {
                return v;
            } else {
                return v.substring(0, 3);
            }
        });

        System.out.println("listCopy: " + listCopy);

        //---- List 10-7 ----
        var map = new HashMap<String,String>(
            Map.of("orange","みかん","apple","りんご","strawberry","いちご"));
        map.replaceAll((k,v) -> k.charAt(0) + v);
        System.out.println("map: " + map);

        //---- List 10-8 ----
        list.add("ヒヤシンス");
        System.out.println("list: " + list);

        list.removeIf(v -> v.length() > 4);
        System.out.println("list: " + list);
    }//main()

}//class

/*
//====== List 10-6 ======
listCopy: [バラ, チュー, あさが]

//====== List 10-7 =======
map: {strawberry=sいちご, orange=oみかん, apple=aりんご}

//====== List 10-7 =======
list: [バラ, チューリップ, あさがお, ヒヤシンス]
list: [バラ, あさがお]
*/