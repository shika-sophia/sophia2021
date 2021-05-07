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
/* Appendix 2021-05-07
 * @costTime 14:59 - 15:17 ( 17 分)
 * @correctRate 正答率 93.33 ％ ( 〇14問 / 全15問 )
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
        ・protected Object[][] getContents()を @Override
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
    => ◆DateFormatクラス abstract
        Dateクラスのためのフォーマットを提供
        static final
        DateFormat getDateInstance(int DateFormat定数, Locale)
            DateFormat.DEFAULT MEDIUMと同じ
            DateFormat.FULL
            DateFormat.LONG
            DateFormat.MEDIUM
            Dateformat.SHORT

〇 （9） A
    => ◆NumberFormat abstract
        static NumberFormat getInstance([Locale])
        void setIntegerMaximumDigits(int)  整数部分の最大桁数を指定
        void setFractionMaximunDigits(int) 小数部分の最大桁数を指定
        Minimunも同様

〇 （10） D
    => ◆SimpleDateFormat
        new SimpleDateFormat(String pattern [, Locale])

Ｘ （11） D -> C
    => LocalDateなど java.timeの DateTimeAPIは
        コンストラクタ private設定。= newできない
        不変オブジェクトとなり、スレッドセーフなクラスを提供。
        GoF||Immutableパターン||

〇 （12） A
    => LocalDate LocalDate.of(int year, int month, int dayOfMonth)
       LocalDate LocalDate.of(int, Month列挙型, int)

〇 （13） C
Ｘ （14） B -> A
    => ◆ZonedDateTimeクラス
         タームゾーン付き日時を表す
         ZoneId.of(String timeZone/regionName)
         "UTC": 協定世界時
         "UTC-7": 協定世界時から７時間遅らせた時間。
             UTC = 8:00 -> UTC-7 = 15:00

    => ◆java.time.temporal.ChronoUnit列挙型
        ChronoUnit.HOURS.between(
            Temporal beginInclusive「=含む」, Temporal endExclusive「=含まない」)

Ｘ （15） D -> C
    => ◆Instantクラス
        static Instant Instant.now()
        Insatnt Instant.parse(String "1970-01-01T00:00:00Z")
        Intstant Instant.EPOCH "1970-01-01T00:00:00Z" = エポック起点を返す
        Instant ChronoZonedDateTime.toInstant()
        Instant ChronoZonedDateTime.toInstant(ZoneOffset)
            ┗ LocalDateTimeからはこれ。

    => ◆ZoneOffsetクラス
        ZoneOffset ZoneOffset.of(String)
            引数に "+2"など文字列でタイムゾーン OffsetIDを渡す
            "Asia/Tokyo"などは不可。 DateTimeException

    => ◆LocalDateTime -> ZonedDateTime
        ZonedDateTime LocalDatTime.atZone(ZoneId)
        ZoneId ZoneId.of("Asia/Tokyo") "UTC-9"も可。

    => ◆LocalDateTime -> OffsetDateTime
        OffsetDateTime LocalDateTime.atOffset(ZoneOffset)

開始時刻 11:52
終了時刻 12:21
所要時間 29 分
正答率 73.33 ％ ( 〇11問 / 全15問 )
*/

/*
//====== 2021-05-07 ======
 Locale, Format [２回目]
〇 （1） B, E, F
〇 （2） B, E
〇 （3） B
〇 （4） A
〇 （5） C
〇 （6） C
〇 （7） D
〇 （8） B
〇 （9） A
〇 （10） D
〇 （11） C
〇 （12） A
〇 （13） C
〇 （14） A
Ｘ （15） B -> C
      ZoneOffset ZoneOffset.of(String) "+2"などを指定
      ZoneId ZoneId.of(String) "Asia/Tokyo"など地域情報を指定。

      Instant Instant.now()
      Instant Instant.parse("1970-01-01T00:00:00Z")
      Instant ZonedDateTime.toInstant()
      Instant LocalDateTime.toInstant(ZoneOffset)

      OffsetDateTime LocalDateTime.atOffset(ZoneOffset)
      ZonedDateTime LocalDateTime.atZone(ZoneId)

開始時刻 14:59
終了時刻 15:17
所要時間 17 分
正答率 93.33 ％ ( 〇14問 / 全15問 )
*/

