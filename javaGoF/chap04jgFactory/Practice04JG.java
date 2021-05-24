/**
 * @title javaGoF / chap04JG / Practice04JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第４章 FactoryMethod / 練習問題 4-1, 4-2, 4-3
 * @author shika
 * @date 2021-04-17
 */
/* Appendix 2021-04-17
 * @costTime 08:26 - 08:34 ( 7 分)
 * @correctRate 正答率 60.00 ％ ( 〇3問 / 全5問 )
 */
package javaGoF.chap04jgFactory;

import javaGold.PracticeEditor;

public class Practice04JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-17 ======
 第４章 FactoryMethod / 練習問題 4-1
Ｘ （1） IdCardクラスの public: どのクラスからもアクセス可。
Ｘ （2） IdCardFactoryをもとに、たくさんの IdCardインスタンスを生成。
    => IdCardは publicではないという問題
    パッケージプライベートにすることで、
    同パッケージのFactoryからしかインスタンス生成をできないようにしている。
    他パッケージから直接 new Idcard()は不可にできる。

 4-2
〇 （1） Id番号と ownerの対応表(別紙)
    => IdCard, IdCardFactoryを修正

 4-3
〇 （1） abstractは継承先でOverrideして実装する前提。
〇 （2） コンストラクタは継承不可なので、abstract不可。
     => abstractにしたければコンストラクタではなく、メソッドにする

開始時刻 08:26
終了時刻 08:34
所要時間 7 分
正答率 60.00 ％ ( 〇3問 / 全5問 )
*/

