/**
 * @title javaGoF / chap15Facade / Practice15JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第15章 Facade / 練習問題 15-1, 15-2
 * @author shika
 * @date 2021-06-17
 */
/* Appendix 2021-06-17
 * @costTime 12:57 - 12:59 ( 2 分)
 * @correctRate 正答率 100.00 ％ ( 〇3問 / 全3問 )
 */
package javaGoF.chap15Facade;

import javaGold.PracticeEditor;

public class Practice15JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-17 ======
 第15章 Facade / 練習問題 15-1
〇 （1） 各クラスを extends PageMakerFacadeとし、
〇 （2） 各クラスの コンストラクタを protectedに変更。
    => 【解答】
    *  各クラスを 無印クラス(package private)に変更。
    *  これだと、本当にパッケージ外からは見えない。
    *
    *  継承関係にしたので protectedにしたが、
    *  考えてみたら、継承して引き継ぐフィールドやメソッドは何もないので
    *  継承する意味はない。パッケージプライベートで十分ということになる。
    => 継承関係を解消、package privateに変更。

 15-2
〇 （1）  PageMakerFacade.linkPage()を追加。
    => 【解答】
    *  Enumeration Properties.propertyNames()
    *  boolean Enumeration.hasNext()
    *  Object  Enumeration.nextElement()
    *  String  Propeties.getProperty(String key)
    *  によって Propertiesクラスの各「key=value」を取り出し、
    *
    *  HtmlWriterFacade.mailto(String url, String caption)に投げている。
    *

開始時刻 12:57
終了時刻 12:59
所要時間 2 分
正答率 100.00 ％ ( 〇3問 / 全3問 )
*/

