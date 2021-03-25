/**
 * @title javaGold / se11Violet / sampleCode / chap02VT / AnnoSafeVarags.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第２章 Annotation / @SafeVarags / p63 List 2-7-5
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 11.2 アノテーション / p545 / DJ-157 / Oracle公式 document
 * @content 山本「@SafeVaragsは final, static, privateのみ」と言うが
 * 			独習「Oracle公式 documentの例」とある。この例文は山本にも掲載されていた。
 * 			どちらが正しいか検証
 * @author shika
 * @date 2021-03-25
 */
package javaGold.se11Violet.sampleCode.chap02VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnoSafeVarags {
   @SafeVarargs
   static void m (List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tempList = Arrays.asList(42);
        array[0] = tempList;
        String str = stringLists[0].get(0);
        System.out.println(str);
    } // m ()

    public static void main(String[] args) {
        List<String> flowerList = new ArrayList<>(
            Arrays.asList("あさがお","さくら","ゆり"));

        AnnoSafeVarags.m(flowerList);
//        var here = new AnnoSafeVarags();
//        here.m(flowerList);
    }//main()

}//class

/*
〔Eclipse警告〕
型の安全性: 可変引数パラメーター stringLists 経由の潜在的なヒープ汚染
  ↓
@SafeVarargsを付記

コンパイルは通るが実行時例外
Exception in thread "main" java.lang.ClassCastException:
    class java.lang.Integer cannot be cast to class java.lang.String (
    java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
    at javaGold.se11Violet.sampleCode.chap02VT.AnnoSafeVarags.m(AnnoSafeVarags.java:25)
    at javaGold.se11Violet.sampleCode.chap02VT.AnnoSafeVarags.main(AnnoSafeVarags.java:33)

//---- staticを除去 ----
コンパイルエラー:
@SafeVarargs 注釈は非 final インスタンス・メソッド m に適用できません

//---- privateのみを付記 ----
上記コンパイルエラーは解決

//---- finalのみを付記 ----
上記コンパイルエラーは解決

山本の言ったことが正しい。
 */
