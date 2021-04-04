/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainAnonyLambda.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p186 / List 5-5, 5-6
 * @content 関数型インターフェイスの 匿名クラスと ラムダ式による定義
 * @author shika
 * @date 2021-04-04
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.Arrays;
import java.util.List;

public class MainAnonyLambda {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tanaka", "Sato");

//        //---- 匿名クラス ----
//        list.replaceAll(new UnaryOperator<String>() {
//            public String apply(String str) {
//                return str.toUpperCase();
//            }//apply()
//        });

        //---- ラムダ式 ----
        list.replaceAll(s -> s.toUpperCase());

        //---- print result ----
        System.out.println("list: " + list);
    }//main()

}//class

/*
list: [TANAKA, SATO]
*/