/**
 * @title javaGold / se08Black / Practice06bkDateTimeAPI.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content 第６章 Date, Time, Formatter
 * @author shika
 * @date 2021-05-07
 */
/* Appendix 2021-05-07
 * @costTime 09:03 - 09:15 ( 11 分)
 * @correctRate 正答率 86.67 ％ ( 〇13問 / 全15問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice06bkDateTimeAPI {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-07 ======
 Date, Time, Formatter
〇 （1） B
    => ◆Date and Time APIのパッケージ
        java.time: 日付・時刻を表すコアAPI (ISO-8601 標準カレンダー)
        java.time.chrono: ISO-8601以外の和暦など、独自カレンダも可。
        java.time.format: フォーマット、解析用のAPI
        java.time.temporal: 日時の単位、長さ、フィールド(項目)
        java.time.zone: タイムゾーンのAPI

    => ◆java.time
        LocalDate, LocalTime, LocalDateTime
            時差情報を含まない現地日時
        OffsetTime, OffsetDateTime
            時差情報を含む日時
        ZonedDateTime
            地域情報を含む
        Year, YearMonth, MonthDay

    => ◆時差
        JST: Japan Standard Time 日本標準時 UCT+9:00
        UTC: Universal Time Coodinated 協定世界時

〇 （2） C
      => ◆LocalDate.now()
          now(Clock): システムクロックを表す java.time.Clock
          now(ZoneId): 地域情報のID java.time.ZonedId

〇 （3） C, D
     => ◆Enum<Month>
         LocalDate.of(int year, int month, int dayOfMonth)
         LocalDate.of(int, Month, int)

         int Month.ordinal(): 0-11の値
         int Month.getValue(): 1-12の値

〇 （4） D, E
    => ◆DateTimeAPIのインターフェイス
        TemporalAccessor: 読み取り専用のメソッド
        Temporal: 読み、書き用メソッド
            ※DateTimeAPIは不変オブジェクト、
            書き込みもフィールドを変更しているのではなく、
            新たなフィールドを持つ新しいオブジェクトを生成している。

〇 （5） B, E
    => java.timeの列挙型
        DayOfWeeK, Month

〇 （6） C
    => LocalDate.parse(String)
        ISO-8601に準拠した文字列。「-」「:」は省略不可。

〇 （7） B
〇 （8） D
    => static LocalDate LocalDate.from(TemporalAccessor)
        TemporalAccessor: DateTimeAPIの各クラスのsuper
        Offset, Zonedから LocalDateを作るときに利用。

    => LocalDateTime.from(LocalDate.now())
        引数に時間の情報がないので、DateTimeExceotion (Runtime)
       LocalDate.from(LocalDateTime.now())は情報が失われるがコンパイルは通る。

〇 （9） D
    => TempralUnitインターフェイス, ChronoUnit列挙型

〇 （10） D?
    => <R extends Temporal> R Temporal.AddTo(R temporal, long amount)
       long Temporal.between(Temporal begin, Temporal end)
           endは含まず
Ｘ （11） B -> A
    => static ZoneId ZoneId.systemDefault()

〇 （12） D
    => TemporalAmountインターフェイス: 時間量
        Period: 期間、時期
        Duration: 時間の間隔
            ※時差やタイムゾーンとは関係ない (？意味が分からない p212)

〇 （13） C, E
    => SimpleDateFormatter / Date, Calendar用のフォーマッター
        スレッドセーフではない
    => DateTimeFormatter 不変クラス / DateTimeAPIが不変オブジェクト
        スレッドセーフ
〇 （14） C
Ｘ （15） A, B, C
    => java.time.Instant
        単一時点 1970-01-01T00:00:00からの経過秒（エポック秒）を表すクラス
        Instant Instant.now()
        Instant ofEpochMilli(long epochMilli)
        Instant ofEpochSecond(long epochSecond)
        Instant ofEpochSecond(long epochSecond, long nanoAdjustment)
        Instant toEpockMilli(long)

    => ZonedDateTime.toInstant()
       LocalDateTime.toInstant(ZonedOffset)

開始時刻 09:03
終了時刻 09:15
所要時間 11 分
正答率 86.67 ％ ( 〇13問 / 全15問 )
*/

