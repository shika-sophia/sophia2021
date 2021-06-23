/**
 * @title javaGoF / chap18Memento / Practice18JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第18章 Memento / 練習問題 18-1, 18-2, 18-3, 18-4
 * @author shika
 * @date 2021-06-23
 */
/* Appendix 2021-06-23
 * @costTime 11:21 - 11:32 ( 10 分)
 * @correctRate 正答率 70.00 ％ ( 〇7問 / 全10問 )
 */
package javaGoF.chap18Memento;

import javaGold.PracticeEditor;

public class Practice18JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-23 ======
 第18章 Memento / 練習問題 18-1
〇 （1） 問 Caretakerが自由にMementoにアクセスできると どうなるか
Ｘ （2） 答 Mementoを Mainで改変できるようになり、
Ｘ （3） マルチスレッド環境ではMementoの整合性が保てなくなる可能性がある。
    => 【解答】
    *  Caretakerで Mementoに直接アクセスして改変できるようにすると
    *  Caretaker / Memento Originator 間の独立性が失われる。
    *  Originator内部の構造が変化した場合、Caretakerも修正が必要になる。
    *
    *  narrow interfaceの範囲である限り、(そのメソッドしか使っていなければ)
    *  Caretakerは Memento Originatorから独立していられ、
    *  Caretakerを修正せずに、自由に改変が可能となる。

 18-2
〇 （1） 問 保存すべき情報が大量になるとメモリ空間を圧迫する。対処法は？
Ｘ （2） 答 外部のFileや、DBに接続して、そちらに情報を管理する。
    => 【解答】
    *  Memeto間の差分をとることで、少し省量化できる。
    *  18-4の Serializeで ファイル保存もメモリ軽減に役立つ

 18-3
〇 （1） 問 Mementoに int numberというフィールドを追加する。
〇 （2） Mementoから値の取得、値の変更可。Gamerからは値の取得のみ、Mainはどちらも不可。
〇 （3） 答 private int number;とし、getterを package-privateに設定する。

 18-4
〇 （1） Serialization version
〇 （2）  package serializeに記述

開始時刻 11:21
終了時刻 11:32
所要時間 10 分
正答率 70.00 ％ ( 〇7問 / 全10問 )
*/

