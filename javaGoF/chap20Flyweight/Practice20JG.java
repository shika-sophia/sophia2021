/**
 * @title javaGoF / chap20Flyweight / Practice20JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第20章 Flyweight / 練習問題 20-1, 20-2, 20-3
 * @author shika
 * @date 2021-06-27
 */
/* Appendix 2021-06-27
 * @costTime 07:29 - 07:33 ( 4 分)
 * @correctRate 正答率 60.00 ％ ( 〇3問 / 全5問 )
 */
package javaGoF.chap20Flyweight;

import javaGold.PracticeEditor;

public class Practice20JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-27 ======
 第20章 Flyweight / 練習問題 20-1
Ｘ （1） BigStringがない。Factoryは singletonだし..Mainで入れ替え

 20-2
Ｘ （1） Mainで確認

 20-3
〇 （1） synchronizedは シングルスレッド環境では必要ないが、
〇 （2） マルチスレッド環境になったとき、Mapを読み込んでnull判定するのと、
〇 （3） Mapにput()して書き込むのを同期(=他Threadを割り込ませない)させるため。

開始時刻 07:29
終了時刻 07:33
所要時間 4 分
正答率 60.00 ％ ( 〇3問 / 全5問 )
*/

