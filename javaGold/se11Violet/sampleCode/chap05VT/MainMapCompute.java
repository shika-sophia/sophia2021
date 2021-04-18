/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainMapCompute.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 関数型インターフェイスと ラムダ式
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content Map with Lambda / p473 / List 10-9
 * @content V Map.compute(K, BiFunction<K,V,V>)
 *          V Map.conputeIfPresent(K, BiFunction<K,V,V>)
 *          V Map.computeIfAbsent(K, BiFunction<K,V,V>)
 *          引数: <? super K>, <? super V>
 *          戻値: <? extends V>
 * @author shika
 * @date 2021-04-18
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.HashMap;
import java.util.Map;

public class MainMapCompute {

    public static void main(String[] args) {
        var map = new HashMap<String,String>(
            Map.of("orange","みかん"));

//        //---- compute() ----
//        map.compute("orange", ComputeDefine::trans);
//        map.compute("melon", ComputeDefine::trans);
//        System.out.println("map: " + map);
//
        //---- computeIfPresent() ----
        map.computeIfPresent("orange", ComputeDefine::trans);
        map.computeIfPresent("melon", ComputeDefine::trans);
        System.out.println("map: " + map);

//        //---- computeIfAbsent() ----
//        map.computeIfAbsent("orange", ComputeDefine::trans);
//        map.computeIfAbsent("melon", ComputeDefine::trans);
//        System.out.println("map: " + map);
    }//main()

}//class

class ComputeDefine {
    //for compute(), conputeIfPresent()
    public static String trans(String key, String value) {
        return key.charAt(0) + value;
    }

    //for computeIfAbsent()
    public static String trans(String key) {
        return key;
    }
}//class

/*
//====== Result ======
//---- compute() ----
map: {melon=mnull, orange=oみかん}

【註】 "" + null -> 「null」という文字列に自動変換

//---- computeIfPresent() ----
map: {orange=oみかん}

//---- computeIfAbsent() ----
map: {melon=melon, orange=みかん}
*/