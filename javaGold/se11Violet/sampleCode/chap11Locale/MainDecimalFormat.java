/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / MainDecimalFormat.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-11
 * @content フォーマットで桁数を指定、そこに変数の値を代入
 *          new DecimalFormat(String pattern)
 *          String DecimalFormat.format(T value)
 *
 * @author shika
 * @date 2021-04-29
 */
package javaGold.se11Violet.sampleCode.chap11Locale;

import java.text.DecimalFormat;

public class MainDecimalFormat {

    public static void main(String[] args) {
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.78);
        customFormat("\u00a5###,###.###", 12345.78);
    }//main()

    private static void customFormat(String pattern, double value) {
        var df = new DecimalFormat(pattern);
        System.out.println(df.format(value));
    }//customFormat()

}//class

/*
123,456.789
123456.79  <- フォーマットの桁が少なくても値に合わせて拡大。
000123.780 <- 桁に合わせて、値の桁不足は「0」を表示。
$12,345.78
¥12,345.78 <- 半角「¥」は ""内でエスケープ記号なので Unicode「\u00a5」

【考察】
Ｘ format(pattern, value)は未定義。コンストラクタ時に要パターン登録。

「¥」は Font"cosolas" だと「\」で表記されるため、正しく表示されない。
    「\\」だと 「\12,345.78」
    「¥¥」だと 「¥¥12,345.78」 こうなる。
Unicode「\u00a5」 -> 「¥」は覚えておこう。
*/