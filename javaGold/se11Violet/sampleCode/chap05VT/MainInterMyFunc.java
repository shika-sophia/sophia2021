/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainInterMyFunc.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p184 / List 5-3
 * @content 独自定義の関数型インターフェイス @FunctionalInterface
 * @author shika
 * @date 2021-04-04
 */
package javaGold.se11Violet.sampleCode.chap05VT;

@FunctionalInterface
interface IMyFunc<T> {
    public abstract void foo(T t);     //抽象メソッド１つ
    public abstract String toString(); //Objectクラスの抽象は可
    boolean equals(Object obj);        //Objectクラス、public abstractは暗黙付記される
    static void X() { }                //static
    default void Y() { }               //default
}//interface

public class MainInterMyFunc {

    public static void main(String[] args) {
        IMyFunc<String> inter = s -> System.out.println("Hello " + s);
        inter.foo("shika");
    }//main()
}//class

/*
Hello shika
*/