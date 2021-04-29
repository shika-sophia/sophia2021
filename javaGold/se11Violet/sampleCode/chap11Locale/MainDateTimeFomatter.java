/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / MainDateTimeFormatter.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-13
 * @content DateTimeFormatter.ISO_DATE
 *          DateTimeFormatter DateTimeFormatter.ofLocalizedDate(FormatStyle)
 *          DateTimeFormatter DateTimeFormatter.localizedBy(Locale)
 *          String LocalDate.format(DateTimeFormatter)
 *          String DateTimeFormatter.format(LocalDate) 上記と同じ結果
 *
 *          FormatStyle[] FormatStyle.values()
 *          DateTimeFormatter DateTimeFormatter.ofLocalizedDate(FormaStyle)
 *          DateTimeFormatter DateTimeFormatter.localizedBy(Locale)
 *
 * @author shika
 * @date 2021-04-29
 */
package javaGold.se11Violet.sampleCode.chap11Locale;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.apache.catalina.tribes.util.Arrays;

public class MainDateTimeFomatter {

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();

        //---- DateTimeFormatter.ISO_DATE ----
        DateTimeFormatter dtfBase = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter dtfDefault = DateTimeFormatter.ISO_DATE;
        System.out.println("LocalDateTime: " + today);
        System.out.println("BASIC_ISO_DATE: " + today.format(dtfBase));
        System.out.println("today.format(dtfDefault): " + today.format(dtfDefault));
        System.out.println("dtfDefault.format(today): " + dtfDefault.format(today));
        System.out.println();

        //---- ofLocalizedDate(FormatStyle) ----
        DateTimeFormatter dtfFull =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("today.format(dtfFull): " + today.format(dtfFull));

        final FormatStyle[] fsAry = FormatStyle.values();
        System.out.println("Enum<FormatStyle>: " + Arrays.toString(fsAry));

        for(FormatStyle fs : fsAry) {
            DateTimeFormatter dtfEnum =
                    DateTimeFormatter.ofLocalizedDate(fs);
            System.out.println("today.format(dtfEnum): " + today.format(dtfEnum));
        }//for
        System.out.println();

        //---- localizedBy(Locale) ----
        LocalDate date = LocalDate.of(2021, 5, 24); //桁不足に「0」を補わなくても大丈夫
        DateTimeFormatter dtfUs = dtfFull.localizedBy(Locale.US);
        System.out.println("date: " + date);
        System.out.println("Locale: " + dtfUs.getLocale()
            + " / "+ dtfUs.getLocale().getDisplayName());
        System.out.println("date.format(dtfUs): " + date.format(dtfUs));
        System.out.println();
    }//main()

}//class

/*
LocalDateTime: 2021-04-29T14:35:23.851491200
BASIC_ISO_DATE: 20210429
today.format(dtfDefault): 2021-04-29
dtfDefault.format(today): 2021-04-29 <- 上記と同じ結果

//---- ofLocalizedDate(FormatStyle) ----
today.format(dtfFull): 2021年4月29日木曜日

Enum<FormatStyle>: {FULL, LONG, MEDIUM, SHORT}
today.format(dtfEnum): 2021年4月29日木曜日 //FULL
today.format(dtfEnum): 2021年4月29日            //LONG
today.format(dtfEnum): 2021/04/29         //MEDIUM
today.format(dtfEnum): 2021/04/29         //SHORT

//---- localizedBy(Locale) ----
date: 2021-05-24
Locale: en_US / 英語 (アメリカ合衆国)
date.format(dtfUs): Monday, May 24, 2021

*/