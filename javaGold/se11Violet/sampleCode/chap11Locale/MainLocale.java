/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / MainLocale.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-1, 11-2
 * @content Locale, getLanguage(), getCountry()
 * @author shika
 * @date 2021-04-28
 */
package javaGold.se11Violet.sampleCode.chap11Locale;

import java.util.Locale;

public class MainLocale {

    public static void main(String[] args) {
        //---- List 11-1 ----
        showProperty("デフォルト: ", Locale.getDefault());
        showProperty("new Locale(): ", new Locale("ja", "JP"));
        showProperty("Locale.JAPAN: ", Locale.JAPAN);
        showProperty("Locale.JAPANESE: ", Locale.JAPANESE);

        //---- List 11-2 ----
    }//main()

    private static void showProperty(String str, Locale locale) {
        System.out.println(str + "locale = " + locale.toString());
        System.out.println(str + "language = " + locale.getLanguage());
        System.out.println(str + "country = " + locale.getCountry());
    }//showProperty()
}//class

/*
デフォルト: locale = ja_JP
デフォルト: language = ja
デフォルト: country = JP

new Locale(): locale = ja_JP
new Locale(): language = ja
new Locale(): country = JP

Locale.JAPAN: locale = ja_JP
Locale.JAPAN: language = ja
Locale.JAPAN: country = JP

Locale.JAPANESE: locale = ja
Locale.JAPANESE: language = ja
Locale.JAPANESE: country =

*/