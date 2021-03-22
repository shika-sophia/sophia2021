/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / MainOuter.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p33 ネストクラス
 * @content List 1-24 / Innerクラスのインスタンス、メソッドへのアクセス
 * @author shika
 * @date 2021-03-22
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

import javaGold.se11Violet.sampleCode.chap01VT.nestedClass.Enclosing.InnerB;

class Enclosing {
    private int valInsta = 100;         //インスタンスフィールド
    private static int valStatic = 200; //staticフィールド

    class InnerA {              //非staticクラス（インナークラス）
        void methodInsta() {
            System.out.println("InnerA.methodInsta() valInsta:" + valInsta);
            System.out.println("InnerA.methodInsta() valStatic" + valStatic);
        }

        //static void methodStatic() { }
    }//class InnerA

    static class InnerB {		//static class
        void methodInsta() {
            //System.out.println("InnerB.methodInsta valInsta" + valInsta);
            System.out.println("InnerB.methodInsta valStatic" + valStatic);
        }

        static void methodStatic() {
            //System.out.println("InnerB.methodStatic valInsta" + valInsta);
            System.out.println("InnerB.methodStatic() valStatic" + valStatic);
        }
    }//class InnerB
}//class Enclosing

public class MainOuter {

    public static void main(String[] args) {
        Enclosing en = new Enclosing();
        Enclosing.InnerA a = en.new InnerA();
        //Enclosing.InnerB b = new Enclosing.InnerB();
        //これでも可。Encosingの後ろに「（）」不要。 en.InnerB()は不可。

        a.methodInsta();
        InnerB.methodStatic();
    }//main()

}//class MainOuter

/*
InnerA.methodInsta() valInsta:100
InnerA.methodInsta() valStatic200
InnerB.methodStatic() valStatic200

*/