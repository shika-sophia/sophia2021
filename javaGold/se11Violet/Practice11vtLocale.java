/**
 * @title javaGold / se11Violet / Practice11vtLocale.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第11章 Locale, Format
 * @author shika
 * @date 2021-05-01
 */
/* Appendix 2021-05-01
 * @costTime 11:57 - 12:12 ( 14 分)
 * @correctRate 正答率 84.62 ％ ( 〇11問 / 全13問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice11vtLocale {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-01 ======
 第11章 Locale, Format
〇 （1） A, D
〇 （2） D
〇 （3） C
〇 （4） C
〇 （5） A, C
〇 （6） D
    => ResourceBundle.getObject(String key)
    引数 int indexは定義されておらず、String keyでなければコンパイルエラー。

〇 （7） F
〇 （8） C
      => プロパティファイル内の 「data= 」は ""を返す。 nullではない。

〇 （9） F
     => Hashtable.get(String key)は引数1つのみ
        Properties.getProperty(String key [, String default])
        なら第２引数に default値を設定でき、keyが存在しない場合に defaultを返す。

Ｘ （10） B -> F
       => LocalDateに対し、
    ofLocaizedDateTime(FormatStyle)で生成した DateTimeFormatterを使用
    実行時に UnsupportedTemporalTypeException

〇 （11） D
     => LocalDate.parse(
             CharSequence target, DateTimeFormatter) で
     LocalDateが生成され、デフォルト設定で表示すると、
     FormatSytle.MEDIUMと同じ表示。

〇 （12） C
Ｘ （13） B -> E
    => DateTimeFormatter.ofPattern("yyyy month: M")
    monthの「o」「t」は不明なパターンとして IllegalArgumentException (runtime)
    "yyyy 'month:' M"なら、「month: 」を文字列として認識する。

開始時刻 11:57
終了時刻 12:12
所要時間 14 分
正答率 84.62 ％ ( 〇11問 / 全13問 )
*/

