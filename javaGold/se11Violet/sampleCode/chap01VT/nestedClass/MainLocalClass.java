/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / MainLocalClass.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p37
 * @content List 1-28 / ローカルクラス
 * @author shika
 * @date 2021-03-23
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

class OuterClass {
    private static int fldStatic = 1;
    private int fldInsta = 2;

    void outerMethod(final int argFinal, int argVarious) {
        final int localFinal = 5;
        int localVarious = 6;

        class InnerLocal {
            void innerMethod() {
                System.out.println("fldStatic = " + fldStatic);
                System.out.println("fldInsta = " + fldInsta);
                System.out.println("argFinal = " + argFinal);
                System.out.println("argVarious = " + argVarious);
                System.out.println("localFinal = " + localFinal);
                System.out.println("localVarious = " + localVarious);

                //argVarious = 100;
                //localVarious = 100;
                //コンパイルエラー: Local variable localVarious defined in an enclosing scope
                //              must be final or effectively final.
            }//methodInner()
        }//class InnerLocal

        new InnerLocal().innerMethod();
    }//methodOuter()
}//class OuterClass

public class MainLocalClass {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod(3, 4);
    }//main()

}//class MainLocalClass

/*
fldStatic = 1
fldInsta = 2
argFinal = 3
argVarious = 4
localFinal = 5
localVarious = 6

*/