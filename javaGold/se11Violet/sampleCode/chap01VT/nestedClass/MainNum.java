/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / MainNum.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p35 ネストクラス /
 * @content List 1-26 / フィールドへのアクセス
 * @author shika
 * @date 2021-03-22
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

class Outer {
    private int num = 100;

    class Inner {
        private int num = 200;

        void method(int num) {
            num++;
            this.num++;
            Outer.this.num++;
            System.out.println("num: " + num); //結果: 301 ローカル変数
            System.out.println(
                    "this.num: " + this.num);  //201 Inner.num
            System.out.println(
                    "Outer.this.num: " + Outer.this.num); //101 Outer.num
        }//method()
    }//class Inner
}//class Outer

public class MainNum {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(300);
    }//main()
}//class MainNum

/*
num: 301
this.num: 201
Outer.this.num: 101
*/