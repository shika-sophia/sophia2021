/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / NestedInner.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p30 ネストクラス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content nestedClass 例文 〔DJ: 9.4 / p439 / DJ-123〕
 * @author shika
 * @date 2021-03-22
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

public class NestedInner {
    private String str1 = "Outerインスタンスフィールド";
    private static String str2 = "Outerクラスメンバー";

    private class Inner {
        private String str1 = "Innerインスタンスフィールド";
        private static final String str2 = "Innerクラスメンバー";

        public void show() {
            System.out.println(NestedInner.this.str1);//Outerインスタンスフィールド
            System.out.println(NestedInner.str2);     //Outerクラスメンバー
        }//show()
    }//class Inner

    public void run() {
        var inner = new Inner();
        inner.show();
        System.out.println(inner.str1); //Innerインスタンスフィールド
        System.out.println(Inner.str2); //Innerクラスメンバー

    }//run()

    public static void main(String[] args) {
        var here = new NestedInner();
        here.run();
    }//main()

}//class

/*
Outerインスタンスフィールド
Outerクラスメンバー
Innerインスタンスフィールド
Innerクラスメンバー
*/