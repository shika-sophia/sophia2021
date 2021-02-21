/**
 * @title javaGold / selfLearn / DJchap05LocalDate.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◇練習問題 5.3, p199 / ◆章末問題, p227
 * @author shika
 * @date 2021-02-21
 */
package javaGold.selfLearn;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DJchap05LocalDate {

    public static void main(String[] args) {
        //[1]現在日時を取得し、月と分を表示
        var now = LocalDateTime.now();
        int month = now.getMonthValue();
        int minute = now.getMinute();

        System.out.printf("now: %tF, %1$tT \n", now);
        System.out.println("month: " + month);
        System.out.println("minute: " + minute);
        System.out.println();

        //[2]今日を基点に20日後の日時
        LocalDateTime after20d = now.plusDays(20L);
        System.out.printf("after20days: %tF \n", after20d);
        System.out.println();

        //◆章末問題[1]④５日と６時間後
        Duration duration = Duration.parse("P6DT5H");
        LocalDateTime after5d = now.plus(duration);

        System.out.printf("after5days6hours: %tF %1$tT \n", after5d);
        //⑤Period
        Period period = Period.between(
            LocalDate.parse("2020-03-12"),
            LocalDate.parse("2020-11-05"));
        System.out.printf("%dヵ月 %d日間 \n",
            period.getMonths(), period.getDays());
    }//main()

}//class

/*
//====== Result [1] ======
now: 2021-02-21, 17:38:12
month: 2
minute: 38
//====== Result [2] ======
after20days: 2021-03-13

//====== Result 章末問題 ======
after5days6hours: 2021-02-28 00:01:18
7ヵ月 24日間

＊Duration.parse("6D5H");
    -> java.time.format.DateTimeParseException
    => P, T が必要。

＊LocalDate.parse("2020/03/12")
    -> java.time.format.DateTimeParseException
    => 区切り「/」ではだめで、「-」にする。
*/