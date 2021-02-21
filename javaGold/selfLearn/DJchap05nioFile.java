/**
 * @title javaGold / selfLearn / DJchap05nioFile.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◆章末問題[2][3], p227
 * @author shika
 * @date 2021-02-21
 */
/*
//[2]
 * Ｘ① import java.lang.regex.Pattern;
 * 	=>java.util.～
 * ② try
 * ③　Paths.get()
 * ④ readLine()
 * ⑤ matcher(⑥ line)
 * ⑦ group()
 */
package javaGold.selfLearn;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DJchap05nioFile {

    public static void main(String[] args) {
        //[3]
        if(args.length < 2) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println(
                "< ! > コマンドライン引数を２つ以上 指定してください。\n");
            System.exit(0);
        }

        String joined = String.join(",", args);
        String path = "./data.dat";

        try(BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(path),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE)){
            writer.write(joined);

        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep();
            System.out.printf(
                "< ! > %s のファイルが見つかりません。\n", path);
            e.printStackTrace();
        }

        System.out.println(path + " に書き込み完了");
    }//main()

}//class

/*
>javac DJchap05nioFile.java -encoding UTF-8

>java DJchap05nioFile
< ! > コマンドライン引数を２つ以上 指定してくださ い。

>java DJchap05nioFile 1 2 3 4 5 6
./data.dat に書き込み完了
(data.datを生成)
1,2,3,4,5,6
*/