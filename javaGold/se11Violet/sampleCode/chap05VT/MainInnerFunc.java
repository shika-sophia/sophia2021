/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainInnerFunc.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p183 / List 5-2, 5-7
 * @content 関数型インターフェイス Function<T, T>を匿名クラスで定義
 * @content 同 ラムダ式で定義
 * @author shika
 * @date 2021-04-04
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.function.Function;

public class MainInnerFunc {

    public static void main(String[] args) {
//        String strRe = new Function<String, String>() {
//            public String apply(String str) {
//                return "Hello " + str;
//            }
//        }.apply("shika");

        Function<String,String> func = s -> "Hello " + s;
        String strRe = func.apply("shika");
        System.out.println(strRe);
    }//main()
}//class

/*
Hello shika
*/