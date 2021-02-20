/**
 * @title javaGold / selfLearn / DJchap05String.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◇練習問題 5.2 / p180
 * @author shika
 * @date 2021-02-20
 */
package javaGold.selfLearn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DJchap05regex {
    public static void main(String[] args) {
        //[1]
        String str = "住所は〒160-0000 新宿区高田馬場0-0-0 \n"
                + "あなたの住所は〒210-9999 横浜市緑区1-1-1";

        Pattern regex = Pattern.compile("〒[0-9]{3}-[0-9]{4}");
        Matcher match = regex.matcher(str);
        while(match.find()) {
            System.out.println(match.group());
        }//while

        //[2]
        String str2 = "お問い合わせは support@examle.com まで";
        String regex2 = "[a-z_0-9]+(-+.][a-z_0-9]+)*@[a-z0-9]+([-.][a-z_0-9]+)*.[a-z_0-9]+([-.][a-z_0-9]+)*";
        String replacement = "<a href='melto: $0'>$0</a>";

        String str2RP = str2.replaceAll(regex2, replacement);
        System.out.println(str2RP);
    }//main()
}//class

/*
〒160-0000
〒210-9999
お問い合わせは <a href='melto: support@examle.com'>support@examle.com</a> まで

＊while(match.find()) がないと、IlleagalStateExceptionが throw される。
＊replaceAll()内？で使用する「$0」で matchした文字列を表せる。

*/
