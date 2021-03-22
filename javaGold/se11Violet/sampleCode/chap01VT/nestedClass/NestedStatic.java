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

public class NestedStatic {
    private static class MyHelper {
        public void show() {
            System.out.println("nested static: show()");
        }//show()
    }//class MyHelper

    public void run() {
        var helper = new MyHelper();
        helper.show();
    }//run()

    public static void main(String[] args) {
        var here = new NestedStatic();
        here.run();

        var helper = new NestedStatic.MyHelper();
        helper.show();
    }//main()
}//class

/*
nested static: show()
nested static: show()
 */
