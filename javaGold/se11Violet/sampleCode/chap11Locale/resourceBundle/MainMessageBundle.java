/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / resourceBundle / MainMessageBundle.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-16, 11-17, 11-18
 * @content MessageFormat
 *              String format(String pattern, Object... param)
 *          ResourceBundle.getBundle() with MessageFormat
 * @see webPractice/localeJsp/interLocaleMessage.jsp
 * @author shika
 * @date 2021-04-28
 */
package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainMessageBundle {

    public static void main(String[] args) {
        //---- MessageFormat.format() ----
        String pattern = "こんにちは {0} さん。 私は {1} です。";
        Object[] param = {"Duke", "Taro"};
        String msg = MessageFormat.format(pattern, param);
        System.out.println(msg);

        Object[][] paramAry = {
            {"Shika", "Yuri"},
            {"Nao", "Misa"}
        };

        MessageFormat mf = new MessageFormat(pattern);
        for (Object[] paramBit : paramAry) {
            String msg2 = mf.format(paramBit);
            System.out.println(msg2);
        }//for

        //---- ResourceBundle.getBundle() with MessageFormat ----
        String here = System.getProperty("sun.java.command"); //ここの完全修飾名
        String dir = here.substring(0, here.lastIndexOf("."));//クラス名を除去
        dir = dir + "."; //「.」を追加。下記 旧dirと同じ dirを作成。
        //String dir = "javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.";
        //System.out.println(dir);

        Locale[] localeAry = {Locale.JAPAN, Locale.US, Locale.GERMANY};
        for(Locale locale : localeAry) {
            ResourceBundle rb =
                ResourceBundle.getBundle(dir + "resource.msg", locale);
            System.out.println("morning: " + rb.getString("morning"));
            System.out.println("night: " + rb.getString("night"));

            DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
            DateTimeFormatter dtfLocale = dtf.localizedBy(locale);
            System.out.println("now: " +
                MessageFormat.format(
                    rb.getString("now"), //propertiesファイルから key「now」の値を読み込み
                    LocalDate.now().format(dtfLocale))); //今日の各国Locale表記を代入
        }//for

    }//main()

}//class

/*
こんにちは Duke さん。 私は Taro です。

こんにちは Shika さん。 私は Yuri です。
こんにちは Nao さん。 私は Misa です。

//---- ResourceBundle.getBundle() with MessageFormat ----
morning: おはようございます
night: おやすみなさい
now: 現在時刻は 2021年4月29日木曜日 です

morning: Good Morning
night: Good Night
now: It is Thursday, April 29, 2021 Now

morning: Guten Morgen
night: Gute Nacht
now: Es ist jetzt Donnerstag, 29. April 2021

//====== propertiesファイル ======
◆msg_ja_JP.properties
morning = \u304a\u306f\u3088\u3046\u3054\u3056\u3044\u307e\u3059
night = \u304a\u3084\u3059\u307f\u306a\u3055\u3044
now = \u73fe\u5728\u6642\u523b\u306f {0} \u3067\u3059

◆msg_en_US.properties
morning = Good Morning
night = Good Night
now = It is {0} Now

◆msg_de_DE.properties
morning = Guten Morgen
night = Gute Nacht
now = Es ist jetzt {0}

 */
