/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / MainNumberFormat.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-9, 11-10
 * @content 数値と通貨の NumberFormat(Locale)
 *          String NumberFormat.format(double/long)
 *          Number NumberFormat.parse(String)
 * @author shika
 * @date 2021-04-29
 */
package javaGold.se11Violet.sampleCode.chap11Locale;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MainNumberFormat {

    public static void main(String[] args) {
        //---- NumberFormat / JP ----
        NumberFormat jpNum = NumberFormat.getInstance();
        NumberFormat jpCur = NumberFormat.getCurrencyInstance();
        System.out.println("日本の数値: " + jpNum.format(12345.678d));
        System.out.println("日本の通貨: " + jpCur.format(50000));

        //---- NumberFormat / US ----
        NumberFormat usNum = NumberFormat.getInstance(Locale.US);
        NumberFormat usCur = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("米国の数値: " + usNum.format(12345.678d));
        System.out.println("米国の通貨: " + usCur.format(50000));

        //---- NumberFormat / GERMAN ----
        NumberFormat deNum = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat deCur = NumberFormat.getCurrencyInstance(Locale.GERMAN);
        System.out.println("独国の数値: " + deNum.format(12345.678d));
        System.out.println("独国の通貨: " + deCur.format(50000));

        try {
            Number value1 = deNum.parse("12345.678");
            long value2 = (long) deCur.parse("50000 ¤");
            System.out.println("独国value1: " + value1);
            System.out.println("独国value2: " + value2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
日本の数値: 12,345.678
日本の通貨: ￥50,000
米国の数値: 12,345.678
米国の通貨: $50,000.00

//---- NumberFormat.format(double/long) ----
独国の数値: 12.345,678
独国の通貨: 50.000,00 ¤

//---- NumberFormat.parse(String)
独国value1: 12345678
独国value2: 50000


【考察】
ちゃんとできていない。doubleを Numberにすると小数が無視される。
型を doubleにすると ClassCastException
    Long -> Doubleのキャストはできませんと言われる。

//double value1 = (double) deNum.parse("12345.678");
//java.lang.ClassCastException:
//class java.lang.Long cannot be cast to class java.lang.Double
//(in module java.base of loader 'bootstrap')


deCur.parse("50000")だと ParseException
    parse()するなら、通貨単位が必要。

てか、独マルクの通貨マーク「¤」、これかい、しかも後ろに。
Localeって、€_EU ユーロに対応しているのかな？
Ｘ Locale(EU), Locale.EUROPE 存在しないって by Eclipse。
*/