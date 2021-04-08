/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainTryWithResource.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p398 / List 9-2
 * @content try-with-resource / 処理内容は List 9-1と同じ
 * @author shika
 * @date 2021-04-08
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainTryWithResource {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try(var outStream = new FileOutputStream(
                new File(dir + "data.txt"), true);
            var inStream = new FileInputStream(
                new File(dir + "data.txt"))) {

            outStream.write(0);
            outStream.write("efg".getBytes());
            outStream.write(98);

            int data = 0;
            while((data = inStream.read()) != -1) {
                System.out.print(data + " ");
            }//while

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- console ----
0 97 98 99 99 0 101 102 103 98

//---- data.txt ----
 abcc efgb

【考察】
＊FileOutputStream(File, boolean append):
    第2引数は追記するかどうか。 trueで追記。デフォルトで false 先頭から上書き。

＊try-with-resourceで 2文あるケース
close()は finallyの前に、最新のインスタンス(下の行 inStream)から close()する。
 */
