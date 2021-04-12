/** 
 * @title javaGoF / chap03JG / Practice03JG.java 
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第３章 TemplateMethod / 練習問題 3-1, 3-2, 3-3, 3-4
 * @author shika 
 * @date 2021-04-12 
 */ 
/* Appendix 2021-04-12 
 * @costTime 10:09 - 10:19 ( 9 分) 
 * @correctRate 正答率 100.00 ％ ( 〇8問 / 全8問 )
 */ 
package javaGoF.chap03JG;

import javaGold.PracticeEditor;

public class Practice03JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/* 
//====== 2021-04-12 ====== 
 第３章 TemplateMethod / 練習問題 3-1
〇 （1） InputStreamの調査(別紙)   

 3-2
〇 （1） メソッドに付す finalはメソッドの Overrideを禁止する。   
〇 （2） display()という、３クラスにまたがるロジックはここだけにして、subで Overrideしないよう finalにしている。   

 3-3
〇 （1） open(), print(), close()は現在 public設定だけど   
〇 （2） 同一パッケージ or 継承関係内からの参照にするには protectedに変更すればいい。   

 3-4
〇 （1） AbsDisplayを abstract classにしたのは display()の具体的記述をしたかったから、   
〇 （2） Java7までインターフェイスでは abstractメソッドしか認められてなかったので 抽象クラスに記述するしかなかった。   
〇 （3） Java8以降、インターフェイスで default, staticが追加され、具象メソッドの記述が可能になった。   

開始時刻 10:09
終了時刻 10:19
所要時間 9 分
正答率 100.00 ％ ( 〇8問 / 全8問 )
*/ 

