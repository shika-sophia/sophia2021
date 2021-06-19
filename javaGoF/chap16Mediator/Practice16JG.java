/**
 * @title javaGoF / chap16Mediator / Practice16JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第16章 Mediator / 練習問題 16-1, 16-2
 * @author shika
 * @date 2021-06-19
 */
/* Appendix 2021-06-19
 * @costTime 11:54 - 12:07 ( 12 分)
 * @correctRate 正答率 54.55 ％ ( 〇6問 / 全11問 )
 */
package javaGoF.chap16Mediator;

import javaGold.PracticeEditor;

public class Practice16JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-19 ======
 第16章 Mediator / 練習問題 16-1
〇 （1） 問 サンプルにおいて「４文字以上」を実装するなら、どのクラスか
〇 （2） 状況判断のロジックは全て loginFrameMediatorクラスに集中している。
〇 （3） passChange()の if(textUser.getText().length() > 4)
Ｘ （4） if(textPass.getText().length() > 4)を変更。
    => if(textUser.getText().length() >= 4
          && textPass.getText().length() > 4) が正解

 16-2
〇 （1） 問 ConcreteCompoの各クラスは IMediator mediatorフィールドを持つので
〇 （2） interface IComponentに記述し一本化することは可能か
Ｘ （3） 可能だし、setMediator(this)で代入しているオブジェクトも同じものだが、
Ｘ （4） mediator.changeCompo()のように各クラスから Madiatorへの通信に利用しているので
Ｘ （5） 各クラスのフィールドに置いておくと思ったけど、superのフィールドでもそれはできる。
〇 （6） コードを見たとき、これが仲介役の mediatorだとすぐにわかるメリットはあるが、
Ｘ （7） 一本化しても問題ないんかな。解答で確認。
    => interfaceはインスタンスフィールドを持てないので一本化はできない。
    *  extends Buttonで、java.awt.Buttonなど各部品の superを呼出ているので
    *  abstract classのフィールドを作ろうと思っても継承できない。
    *  Javaは多重継承不可。

開始時刻 11:54
終了時刻 12:07
所要時間 12 分
正答率 54.55 ％ ( 〇6問 / 全11問 )
*/

