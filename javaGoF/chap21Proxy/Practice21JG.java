/**
 * @title javaGoF / chap21Proxy / Practice21JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第21章 Proxy / 練習問題 21-1, 21-2
 * @author shika
 * @date 2021-06-28
 */
/* Appendix 2021-06-28
 * @costTime 16:26 - 16:32 ( 6 分)
 * @correctRate 正答率 100.00 ％ ( 〇7問 / 全7問 )
 */
package javaGoF.chap21Proxy;

import javaGold.PracticeEditor;

public class Practice21JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-28 ======
 第21章 Proxy / 練習問題 21-1
〇 （1） サンプルを修正。PrinterProxy.realize(){ new Printer() }から
〇 （2） realize( Class.forName(String).newInstance() }に変更。

 21-2
〇 （1） synchronizedの意味。
〇 （2） マルチスレッド環境で、realのnull判定と、realへの代入を同期させないと、
〇 （3） 他Threadに割り込まれる可能性があり、データレースを起こす。
〇 （4） このサンプルでは特に、Printインスタンスの生成に時間が掛かるので、
〇 （5） 割り込まれる可能性が高くなる。シングルスレッドなら問題は起きない。

開始時刻 16:26
終了時刻 16:32
所要時間 6 分
正答率 100.00 ％ ( 〇7問 / 全7問 )
*/

