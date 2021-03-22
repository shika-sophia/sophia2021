/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / MainNum.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p34 ネストクラス /
 * @content List 1-25 / 自クラスの Innerクラスをインスタンス。
 * @author shika
 * @date 2021-03-22
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

public class MainSame {
    class InnerInsta {
        void show() {
            System.out.println("InnerInsta");
        }
    }//class InnerInsta

    static class InnerStatic {
        static void show() {
            System.out.println("InnerStatic");
        }
    }//class InnerStatic

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        var here = new MainSame();
        here.new InnerInsta().show();
        //new InnerInsta().show(); 不可

        new InnerStatic().show();
        new MainSame.InnerStatic().show();
        MainSame.InnerStatic.show();
        InnerStatic.show();
    }//main()

}//class MainSame

/*
InnerInsta
InnerStatic
InnerStatic
InnerStatic
InnerStatic

【考察】 自クラスの Innerクラスをインスタンスする場合
非staticの InnerInstaは 自クラスのインスタンスも必要。
staticの InnerStaticは 自クラスのインスタンス不要で、
InnerStatic.method()でＯＫ。
MainSameのインスタンスを付けようとすると警告「staticにアクセスしてください」と出る。
*/