/**
 * @title javaGold / selfLearn / DJchap05String.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◇練習問題 5.1, p161 / ◆章末問題, p227
 * @author shika
 * @date 2021-02-20, 02-21
 */
package javaGold.selfLearn;

import java.util.stream.Stream;

public class DJchap05String {

    public static void main(String[] args) {
        //[1]
        String str = "プログラミング";
        String subStr = str.substring(str.indexOf('ミ'));
        System.out.println("subStr: " + subStr);
        System.out.println();

        //[2]
        String str2 ="白石\t香織\t女\t24\t神奈川県";
        String[] splitAry = str2.split("\t");
        String joined = String.join("&", splitAry);
        System.out.println(joined);
        System.out.println();

        //[2]改
        Stream.of("鈴木\t太郎\t男\t50\t広島県",
                  "白石\t香織\t女\t24\t神奈川県")
            .map(s -> s.replace("\t"," & "))
            .forEach(System.out::println);
        System.out.println();

        //◆章末問題 [1]①最後に登場する「きゃく」の位置を取得
        String str3 = "となりのきゃくはよくきゃくくうきゃくだ";
        int index = str3.lastIndexOf("きゃく");
        System.out.println("index: " + index);

        //② printf()
        System.out.printf(
            "%sの気温は %.2f℃です。\n", "千葉", 17.256d);

        //③ replace()
        String str4 = "彼女の名前は花子です。";
        System.out.println(str4.replace("彼女", "妻"));

    }//main()

}//class

/*
subStr: ミング

白石&香織&女&24&神奈川県

鈴木 & 太郎 & 男 & 50 & 広島県
白石 & 香織 & 女 & 24 & 神奈川県

//====== Result 章末問題 ======
index: 15
千葉の気温は 17.26℃です。
妻の名前は花子です。
*/