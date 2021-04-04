/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainFuncImple.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p182 / List 5-1
 * @content 関数型インターフェイス Function<T, T>を 実装したクラス
 * @author shika
 * @date 2021-04-04
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.function.Function;

class MyFunc implements Function<String,String> {
    @Override
    public String apply(String str) {
        return "Hello " + str;
    }
}//class MyFunc

public class MainFuncImple {
    public static void main(String[] args) {
        MyFunc obj = new MyFunc();
        String strRe = obj.apply("shika");
        System.out.println(strRe);
    }//main()

}//class MainFuncImple

/*
Hello shika
*/

