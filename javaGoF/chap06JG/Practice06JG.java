/**
 * @title javaGoF / chap06JG / Practice06JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第６章 Prototype / 練習問題 6-1, 6-2
 * @author shika
 * @date 2021-04-22
 */
/* Appendix 2021-04-22
 * @costTime 10:14 - 10:22 ( 7 分)
 * @correctRate 正答率 75.00 ％ ( 〇6問 / 全8問 )
 */
package javaGoF.chap06JG;

import javaGold.PracticeEditor;

public class Practice06JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-22 ======
 第６章 Prototype / 練習問題 6-1
〇 （1） createClone()の重複、MessageBox, Underlineの解消
〇 （2） Productに defaultメソッドとして定義すると
Ｘ （3） clone()は Productで未定義と出る。
Ｘ （4） interfaceは clone()対象外だからだろうか。
〇 （5） Cloneableインターフェイスは clone()を定義しておらずマーカーインターフェイス

    =>【解答】 p393
    Productを interface -> classにして、
    createClone()を実装する
    || Template パターン ||を利用する。
    Productは、MessageBox, Underlineの superなので、
    両クラスに継承される。
    => @see prototypeRV パッケージ

    (別解) ConcreteProductクラスに記述して、両クラスに継承しても可

 6-2
〇 （1） java.lang.Objectは Cloneableを実装しているか
〇 （2） Objectに実装していたら、clone()を使うクラスは実装しなくてもよかろう。
〇 （3） なので、Objectに Cloneableは付いていない。

開始時刻 10:14
終了時刻 10:22
所要時間 7 分
正答率 75.00 ％ ( 〇6問 / 全8問 )
*/

