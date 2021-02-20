/**
 * @title javaGold / selfLearn / DJchap05String.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◇練習問題 5.1 / p161
 * @author shika
 * @date 2021-02-20
 */
package javaGold.selfLearn;

import java.util.stream.Stream;

public class DJchap05String {

    public static void main(String[] args) {
        String str = "プログラミング";
        String subStr = str.substring(str.indexOf('ミ'));
        System.out.println("subStr: " + subStr);
        System.out.println();

        String str2 ="白石\t香織\t女\t24\t神奈川県";
        String[] splitAry = str2.split("\t");
        String joined = String.join("&", splitAry);
        System.out.println(joined);
        System.out.println();

        Stream.of("鈴木\t太郎\t男\t50\t広島県",
                  "白石\t香織\t女\t24\t神奈川県")
            .map(s -> s.replace("\t"," & "))
            .forEach(System.out::println);

    }//main()

}//class

/*
subStr: ミング

白石&香織&女&24&神奈川県

鈴木 & 太郎 & 男 & 50 & 広島県
白石 & 香織 & 女 & 24 & 神奈川県
*/