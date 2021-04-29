/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / MainOfPattern.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-14, 11-15
 * @content DatetimeFormatter DateTimeFormatter.ofPattern(String pattern)
 *          DatetimeFormatter DateTimeFormatter.ofPattern(String　pattern, Locale)
 *          JapaneseDate.of()
 *              DatatimeFormatter.ofPattern("G yy年")
 *              jpDate.format(pattern) -> 令和3年
 *          JapaneseDate -> LocalDate
 *          	LocalDate.parse(String pattern, DateTimeFormatter)
 *
 * @author shika
 * @date 2021-04-29
 */
package javaGold.se11Violet.sampleCode.chap11Locale;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainOfPattern {

    public static void main(String[] args) {
        final LocalDate date = LocalDate.of(2021, 01, 20);
        final String[] patternAry =
            {"G yy年 E", "GGGG YYYY年 EEEE", "GGGGG YYYYY年 EEEEE"};
        System.out.println("patternAry: " + Arrays.toString(patternAry));

        //---- ofPattern(pattern) ----
        List<DateTimeFormatter> formatList =
            Arrays.stream(patternAry)
                .map(p -> DateTimeFormatter.ofPattern(p))
                .collect(Collectors.toList());
        formatList.stream()
            .map(f -> date.format(f))
            .forEach(System.out::println);

        //---- ofPattern(pattern, Locale.US) ----
        List<DateTimeFormatter> formatListUS =
            Arrays.stream(patternAry)
                .map(p -> DateTimeFormatter.ofPattern(p, Locale.US))
                .collect(Collectors.toList());
        formatListUS.stream()
            .map(f -> date.format(f))
            .forEach(System.out::println);

        //---- JapaneseDate ----
        final JapaneseDate jpDate = JapaneseDate.of(2021, 05, 24);
        System.out.println("jpDate: " + jpDate);
        formatList.stream()
            .map(f -> jpDate.format(f))
            .forEach(System.out::println);
        formatListUS.stream()
            .map(f -> jpDate.format(f))
            .forEach(System.out::println);

        //---- JapaneneDate -> LocalDate ----
        DateTimeFormatter dtfFull =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String jpDateStr = jpDate.format(dtfFull);
        LocalDate ldt = LocalDate.parse(jpDateStr, dtfFull);
        System.out.println("JapaneseDate: " + jpDateStr);
        System.out.println("LocalDate: " + ldt);

        //---- ofPattern(), parse() ----
        DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy年 MM月 dd日 EEEE");
        String str = "2021年 01月 30日 土曜日";
        LocalDate ldt2 = LocalDate.parse(str, format);
        System.out.println("str: " + str);
        System.out.println("LocalDatetime: " + ldt2);
    }//main()

}//class

/*
//---- ofPattern(pattern) ----
patternAry: [G yy年 E, GGGG YYYY年 EEEE, GGGGG YYYYY年 EEEEE]
西暦 21年 水
西暦 2021年 水曜日
AD 02021年 水

//---- ofPattern(pattern, Locale.US) ----
AD 21年 Wed
Anno Domini 2021年 Wednesday
A 02021年 W

//---- JapaneseDate ----
jpDate: Japanese Reiwa 3-05-24
令和 03年 月
令和 2021年 月曜日
R 02021年 月

//---- JapaneseDate / Locale_US ----
Reiwa 03年 Mon
Reiwa 2021年 Monday
R 02021年 M

//---- JapaneneDate -> LocalDate ----
JapaneseDate: 2021年5月24日月曜日
LocalDate: 2021-05-24

//---- ofPattern(), parse() ----
str: 2021年 01月 30日 土曜日
LocalDatetime: 2021-01-30

"YYYY年"だと parse()不可という例外。
"YYYY年"は「西暦 2021年」に変換されるパターンなので、
parse()するなら、strにも「西暦 」を付けねばならない。
と思ったが、「西暦 」付けてもあかんかった。
"yyyy年"ならＯＫ。
*/