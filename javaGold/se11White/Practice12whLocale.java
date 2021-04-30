/**
 * @title javaGold / se11White / Practice12whLocale.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第12章 Locale, Format
 * @author shika
 * @date 2021-04-30
 */
/* Appendix 2021-04-30
 * @costTime 11:52 - 12:21 ( 29 分)
 * @correctRate 正答率 73.33 ％ ( 〇11問 / 全15問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice12whLocale {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-30 ======
 第12章 Locale, Format
〇 （1） B, E, F
    => es_ES スペイン
〇 （2） B, E
〇 （3） B
    => Locale("en")と言語コードのみ指定した場合、
        国コードを取得すると""空文字。nullではない。
        コンストラクタで Locale("en", "")と定義されている。

〇 （4） A
Ｘ （5） D -> C
    ◆Resourceクラスの定義要件
        ・ListResourceBundeleを継承
        ・必ず publicクラス
        ・Object[][] getContents()を @Override
        ・package, クラス名は任意

〇 （6） C
    => 言語コード、国コードが合致しなくても、デフォルトファイルがあれば検出可。
    MissingResourceExceptionになるのは、
    baseNameが違っているか、
    ファイル名だけ指定している場合、同じ階層にないか、
    パッケージの階層の相対パスが違っているか

〇 （7） D
    ◆ResoourceBundle.Controlクラス
    ResoourceBundle.Control getControl(Control定数)
        検索ファイルの指定をすることができる
        Control.FORMAT_DEFAULT default値。クラスファイルとプロパティファイル
        Control.FORMAT_CLASS   クラスファイルのみ
        Control.FORMAT_PROPERTIES プロパティファイルのみ
    BesourceBundle.getBundle(String baseName, Locale, Control)
        第３引数に渡す。指定したファイルがなければ、他ファイルがあっても、
        MissingResourceException

〇 （8） B
〇 （9） A
〇 （10） D
Ｘ （11） D: String
〇 （12） A
〇 （13） C
Ｘ （14） B
Ｘ （15） D

開始時刻 11:52
終了時刻 12:21
所要時間 29 分
正答率 73.33 ％ ( 〇11問 / 全15問 )
*/

